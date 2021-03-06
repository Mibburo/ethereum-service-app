/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ethereumserviceapp.service;

import java.util.List;
import java.util.Optional;

import com.example.ethereumserviceapp.contract.CaseMonitor;
import com.example.ethereumserviceapp.contract.VcRevocationRegistry;
import com.example.ethereumserviceapp.model.Case;
import com.example.ethereumserviceapp.model.CasePayment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.web3j.crypto.Credentials;

/**
 *
 * @author nikos
 */
public interface EthereumService {

    public Credentials getCredentials();

    public CaseMonitor getContract();

    public List<String> getAllCaseUUID();

    public Optional<Case> getCaseByUUID(String uuid);

    public void addCase(Case monitoredCase);

    public void deleteCaseByUuid(String uuid);

    public void updateCase(Case monitoredCase);

    //public void updateRejection(Case monitoredCase);

    public void addPayment(Case monitoredCase, CasePayment payment, Boolean sync);

    public boolean checkIfCaseExists(String uuid);

    public VcRevocationRegistry getRevocationContract();

    public boolean checkRevocationStatus(String uuid);

    public Page<String> getCaseUuidsPaginated(Pageable pageable);

    //public void revokeCredentials(String uuid);
}
