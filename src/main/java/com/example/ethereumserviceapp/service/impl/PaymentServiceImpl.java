package com.example.ethereumserviceapp.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.ethereumserviceapp.model.Case;
import com.example.ethereumserviceapp.model.CasePayment;
import com.example.ethereumserviceapp.model.State;
import com.example.ethereumserviceapp.model.entities.SsiApplication;
import com.example.ethereumserviceapp.service.EthereumService;
import com.example.ethereumserviceapp.service.MongoService;
import com.example.ethereumserviceapp.service.PaymentService;
import com.example.ethereumserviceapp.utils.EthAppUtils;
import com.example.ethereumserviceapp.utils.MonitorUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService{

    private EthereumService ethServ;
    private MongoService mongoServ;

    @Autowired
    public PaymentServiceImpl(EthereumService ethServ, MongoService mongoServ) {
        this.ethServ = ethServ;
        this.mongoServ = mongoServ;
    }

    @Override
    @Scheduled(cron = "0 0 0 1 * ?")
    public void startScheduledPayment(){
        List<String> uuids = this.ethServ.getAllCaseUUID();
        startPayment(LocalDateTime.now(), false);
    }    

    @Override
    public void startPayment(LocalDateTime dateNow, Boolean sync){
        
        List<String> uuids = this.ethServ.getAllCaseUUID();
        uuids.stream().forEach(uuid -> {
            // get the case from the block chain
            Optional<Case> theCase = this.ethServ.getCaseByUUID(uuid);
            //if the case does not exist or is a case belonging to a non principal member, continue to the next case
            if(!theCase.isPresent() || theCase.get().getState().equals(State.NONPRINCIPAL)){
                return;
            }
            Case caseToBePaid = theCase.get();
            LocalDateTime startDate = caseToBePaid.getHistory().entrySet().iterator().next().getKey();
            LocalDateTime currentDate = dateNow == null? LocalDateTime.now() : dateNow;
            Optional<SsiApplication> ssiApp = mongoServ.findByUuid(uuid);
            Set<String> householdAfms = ssiApp.get().getHouseholdComposition().stream().map(s -> s.getAfm()).collect(Collectors.toSet());
            List<SsiApplication> householdApps = mongoServ.findByTaxisAfmIn(householdAfms);
            if (caseToBePaid.getState().equals(State.ACCEPTED)) {
                if(startDate.isBefore(currentDate)){
                    calculatePayment(caseToBePaid, ssiApp.get(), householdApps, currentDate, sync);
                }
            }

            //TODO replace localdate now with asynchrous rejected date
            LocalDate rejectedDate = LocalDate.now();


            //if case is rejected then check the previous month history for days during which the case was accepted
            if (caseToBePaid.getState().equals(State.REJECTED) || caseToBePaid.getState().equals(State.SUSPENDED)) {
                // get the number of days of the previous month during which the case was accepted
                Long acceptedDates = caseToBePaid.getHistory().entrySet().stream().filter(
                        e -> (e.getKey().toLocalDate().compareTo(currentDate.toLocalDate().minusMonths(1)) >= 0) 
                        && e.getKey().toLocalDate().isBefore(rejectedDate == null? currentDate.toLocalDate() : rejectedDate.isBefore(currentDate.toLocalDate())? rejectedDate : currentDate.toLocalDate())
                        && e.getValue().equals(State.ACCEPTED)).count();
                if(acceptedDates.intValue() > 0){
                    //check payment credentials
                    if(ssiApp.isPresent() && ssiApp.get().getHouseholdPrincipal().getAfm().equals(ssiApp.get().getTaxisAfm())){
                        calculatePayment(caseToBePaid, ssiApp.get(), householdApps, currentDate, sync);
                    }
                } else if(caseToBePaid.getState().equals(State.REJECTED) ){
                    // if the case's state is rejected and there are no days during the month during which the case was accepted, delete it from the block chain 
                    ethServ.deleteCaseByUuid(uuid);
                }
            }
        });
    }

    private void calculatePayment(Case caseToBePaid, SsiApplication ssiApp, List<SsiApplication> householdApps, LocalDateTime currentDate, Boolean sync){
        List<SsiApplication> allHouseholdApps = mongoServ.findByTaxisAfmIn(EthAppUtils.fetchAllHouseholdAfms(ssiApp)); 
        BigDecimal paymentValue = MonitorUtils.calculateCurrentPayment(caseToBePaid, ssiApp, allHouseholdApps, currentDate.toLocalDate()).subtract(caseToBePaid.getOffset());
        log.info("payment value :{}", paymentValue);
        //Call to payment service
        State paymentState = paymentService(paymentValue, caseToBePaid, ssiApp, householdApps);
        addPayment(paymentValue, caseToBePaid, currentDate, paymentState, sync);
    }

    private State paymentService(BigDecimal valueToBePaid, Case caseToBePaid, SsiApplication ssiApp, List<SsiApplication> householdApps){
    
        //mock Call to external service
        if(!mockExternalPaymentService(valueToBePaid, caseToBePaid.getUuid()) || !EthAppUtils.areAppHouseholdAfmsTheSame(householdApps, ssiApp)){
            caseToBePaid.setOffset(valueToBePaid.compareTo(BigDecimal.ZERO) < 0? valueToBePaid.negate() : valueToBePaid);
            //caseToBePaid.setState(State.PAID);
            return State.FAILED;
        } 
         //set offset as the payment value if the total value is negative and set the total value to 0
        if (valueToBePaid.compareTo(BigDecimal.ZERO) < 0) {
            caseToBePaid.setOffset(valueToBePaid.negate());
            valueToBePaid = BigDecimal.ZERO;
        } else {
            caseToBePaid.setOffset(BigDecimal.ZERO);
        }
        return State.PAID;
    }

    private Boolean mockExternalPaymentService(BigDecimal valueToBePaid, String uuid){
        return true;
    }

    private void addPayment(BigDecimal valueToBePaid, Case caseToBePaid, LocalDateTime currentDate, State state, Boolean sync){
        //synchronize transactions for test data, only for failed payments so that the offset can be updated
        // if(sync && !state.equals(State.FAILED)){
        //     sync = false;
        // }
        CasePayment payment = new CasePayment();
        payment.setPaymentDate(currentDate);
        payment.setPayment(valueToBePaid);
        payment.setState(state);
        ethServ.addPayment(caseToBePaid, payment, sync);
        log.info("new payment :{}", payment);
    }
}
