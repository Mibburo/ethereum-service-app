pragma solidity >=0.4.21;

contract CaseMonitor{

    Case[] cases; 
    mapping(bytes16 => uint) caseUuidToIndex; 
    
    CasePayment[] payments;
    mapping(bytes16 => uint) paymentUuidToIndex; 

    CaseRejection[] rejections;
    mapping(bytes16 => uint) rejectionUuidToIndex; 
    
    //defines a case along with its state
    struct Case {
        bytes16 uuid;
        uint latestDate;
        uint[] datesHistory;
        CaseState[] statesHistory; 
        uint[] payPerDayHistory;
        uint[] sumDailyValueHistory;
        CaseState currState;
        uint paymentOffset;
    }
    
    struct CasePayment{
        bytes16 uuid;
        uint[] paymentDateHistory;
        uint[] paymentValueHistory;
        CaseState[] paymentStateHistory;
    }

    struct CaseRejection {
        bytes16 uuid;
        uint rejectionCode;
        uint rejectionDate;
    }

    //possible case states 
    enum CaseState {
        Undefined,    //case has not been processed
        Accepted,     //case has been accepted
        Rejected,     //case has been rejected
        Paid,         //case has been paid 
        Suspended,    //case has been suspended
        Failed,       //case has failed to be paid
        NonPrincipal  //case belongs to a non principal household member
    }

    function _getCaseIndex(bytes16 _uuid) public view returns (uint) {
        return caseUuidToIndex[_uuid]; 
    }
    
    function _getPaymentIndex(bytes16 _uuid) public view returns (uint) {
        return paymentUuidToIndex[_uuid]; 
    }

    function _getRejectionIndex(bytes16 _uuid) public view returns (uint) {
        return rejectionUuidToIndex[_uuid]; 
    }

    function addCase(bytes16 _uuid, uint _date) public {

        //require that the case be unique (not already added) 
        require(!caseExists(_uuid));

        uint[] memory datesHistory = new uint[](1);
        datesHistory[0] = _date;
        CaseState[] memory statesHistory = new CaseState[](1);
        statesHistory[0] = CaseState.Undefined;
        uint[] memory payPerDayHistory = new uint[](1);
        uint[] memory sumDailyValueHistory = new uint[](1);
        payPerDayHistory[0] = 0;
        sumDailyValueHistory[0] = 0;

        //add the case 
        cases.push(Case(_uuid, _date, datesHistory, statesHistory, payPerDayHistory, sumDailyValueHistory, CaseState.Undefined, 0)); 
        uint newIndex = cases.length-1;
        caseUuidToIndex[_uuid] = newIndex;
        addCasePayment(_uuid);
        addCaseRejection(_uuid);
        
        //return the unique id of the new case
        //return newIndex;
    }
    
    function addCasePayment(bytes16 _uuid) public  {
        
        require(!paymentExists(_uuid));
        
        uint[] memory paymentDateHistory = new uint[](1);
        paymentDateHistory[0] = 0;
        uint[] memory paymentHistory = new uint[](1);
        paymentHistory[0] = 0;
        CaseState[] memory paymentStateHistory = new CaseState[](1);
        paymentStateHistory[0] = CaseState.Undefined;
        
        payments.push(CasePayment(_uuid, paymentDateHistory, paymentHistory, paymentStateHistory));
        
        uint newIndex = payments.length-1;
        paymentUuidToIndex[_uuid] = newIndex;
    }

    function addCaseRejection(bytes16 _uuid) public  {
        
        require(!rejectionExists(_uuid));
        
        rejections.push(CaseRejection(_uuid, 0, 0));
        
        uint newIndex = rejections.length-1;
        rejectionUuidToIndex[_uuid] = newIndex;
    }

    function updateCase(bytes16 _uuid, uint _date, CaseState _state, uint _payPerDay, uint _sumDaily, uint _offset) public {

        require(caseExists(_uuid));
        
        uint index = _getCaseIndex(_uuid);
        Case storage theCase = cases[index];
        
        theCase.latestDate = _date;
        theCase.datesHistory.push(_date);
        theCase.statesHistory.push(_state);
        theCase.payPerDayHistory.push(_payPerDay);
        theCase.sumDailyValueHistory.push(_sumDaily);
        theCase.currState= _state;
        theCase.paymentOffset = _offset;
    }

    function addPayment(bytes16 _uuid, CaseState _state, uint _pDate, uint _payHistory, uint _offset) public{

        require(caseExists(_uuid));
        
        uint caseIndex = _getCaseIndex(_uuid);
        Case storage theCase = cases[caseIndex];
        uint paymentIndex = _getPaymentIndex(_uuid);
        CasePayment storage payment = payments[paymentIndex];

        if(payment.paymentDateHistory[0] == 0){
            payment.paymentDateHistory[0] = _pDate;
            payment.paymentValueHistory[0] = _payHistory;
            payment.paymentStateHistory[0] = _state;
        } else{
            payment.paymentDateHistory.push(_pDate);
            payment.paymentValueHistory.push(_payHistory);
            payment.paymentStateHistory.push(_state);
        }

        theCase.paymentOffset = _offset;
    }

    function updateRejection(bytes16 _uuid, uint _rejectionCode, uint _rejectionDate) public{
        require(rejectionExists(_uuid));
        
        uint index = _getRejectionIndex(_uuid);
        CaseRejection storage rejectedCase = rejections[index];
        rejectedCase.rejectionCode = _rejectionCode;
        rejectedCase.rejectionDate = _rejectionDate;
    }

    function caseExists(bytes16 _uuid) public view returns (bool) {
        if (cases.length == 0)
            return false;

        if(cases[_getCaseIndex(_uuid)].uuid == _uuid){
            return true;
        }
        
        return false;
    }
    
    function paymentExists(bytes16 _uuid) public view returns (bool) {
        if (payments.length == 0)
            return false;

        if(payments[_getPaymentIndex(_uuid)].uuid == _uuid){
            return true;
        }
        
        return false;
    }

    function rejectionExists(bytes16 _uuid) public view returns (bool) {
        if (rejections.length == 0)
            return false;

        if(rejections[_getRejectionIndex(_uuid)].uuid == _uuid){
            return true;
        }
        
        return false;
    }

    function getAllCases() public view returns (bytes16[] memory) {
        bytes16[] memory output = new bytes16[](cases.length); 

        //get all ids 
        if (cases.length > 0) {
            uint index = 0;
            for (uint n = cases.length; n > 0; n--) {
                output[index++] = cases[n-1].uuid;
            }
        }
        return output; 
    }

    function getCase(bytes16 _uuid) public view returns (
        bytes16 uuid,
        uint creationDate,
        uint[] memory datesHistory,
        CaseState[] memory statesHistory,
        uint[] memory payPerDayHistory,
        uint[] memory sumDailyValueHistory,
        CaseState currState,
        uint paymentOffset) {
            
        require(caseExists(_uuid));

        Case storage theCase = cases[_getCaseIndex(_uuid)];
        
        
        return (theCase.uuid, theCase.latestDate, 
                 theCase.datesHistory, theCase.statesHistory, theCase.payPerDayHistory, theCase.sumDailyValueHistory, theCase.currState,
                 theCase.paymentOffset); 
        
    }
    
    function getPayment(bytes16 _uuid) public view returns (
        bytes16 uuid,
        uint[] memory paymentDateHistory,
        uint[] memory paymentValueHistory,
        CaseState[] memory paymentStateHistory) {
            
        require(paymentExists(_uuid));

        CasePayment storage payment = payments[_getPaymentIndex(_uuid)];
        return (payment.uuid, payment.paymentDateHistory, payment.paymentValueHistory, payment.paymentStateHistory); 
        
    }

    function getRejection(bytes16 _uuid) public view returns (
        bytes16 uuid,
        uint rejectionCode,
        uint rejectionDate) {
            
        require(rejectionExists(_uuid));

        CaseRejection storage rejection = rejections[_getRejectionIndex(_uuid)];
        return (rejection.uuid, rejection.rejectionCode, rejection.rejectionDate); 
        
    }

    function deleteCase(bytes16 _uuid) public {
        require(caseExists(_uuid));
        
        uint caseIndex = _getCaseIndex(_uuid);

        if(caseIndex != cases.length - 1){
            // switch the case to be deleted with the last case of the array and then pop it
            Case memory caseToDelete = cases[caseIndex];
            // find the uuid of the last case that will be switched and delete that pair from the key/value pair mapping
            bytes16 switchedUuid = cases[cases.length - 1].uuid;
            delete caseUuidToIndex[switchedUuid];
            cases[caseIndex] = cases[cases.length - 1];
            cases[cases.length - 1] = caseToDelete;
            // add the uuid of the switched case back to the mapping
            caseUuidToIndex[switchedUuid] = caseIndex;
        }

        cases.pop();
        
        deletePayment(_uuid);
        deleteRejection(_uuid);
    }
    
    function deletePayment(bytes16 _uuid) public {
        require(paymentExists(_uuid));
        
        uint paymentIndex = _getPaymentIndex(_uuid);

        if(paymentIndex != payments.length - 1){
            
            // switch the payment to be deleted with the last payment of the array and then pop it
            CasePayment memory paymentToDelete = payments[paymentIndex];
            // find the uuid of the last payment that will be switched and delete that pair from the key/value pair mapping
            bytes16 switchedUuid = payments[payments.length - 1].uuid;
            delete paymentUuidToIndex[switchedUuid];
            payments[paymentIndex] = payments[payments.length - 1];
            payments[payments.length - 1] = paymentToDelete;
            // add the uuid of the switched payment back to the mapping
            paymentUuidToIndex[switchedUuid] = paymentIndex;
        }
        
        payments.pop();
       
    }

    function deleteRejection(bytes16 _uuid) public {
        require(rejectionExists(_uuid));
        
        uint rejectionIndex = _getRejectionIndex(_uuid);

        if(rejectionIndex != rejections.length - 1){
            
            // switch the rejection of the case to be deleted with the last payment of the array and then pop it
            CaseRejection memory rejectionToDelete = rejections[rejectionIndex];
            // find the uuid of the last rejection that will be switched and delete that pair from the key/value pair mapping
            bytes16 switchedUuid = rejections[rejections.length - 1].uuid;
            delete rejectionUuidToIndex[switchedUuid];
            rejections[rejectionIndex] = rejections[rejections.length - 1];
            rejections[rejections.length - 1] = rejectionToDelete;
            // add the uuid of the switched payment back to the mapping
            rejectionUuidToIndex[switchedUuid] = rejectionIndex;
        }
        
        rejections.pop();
       
    }
}