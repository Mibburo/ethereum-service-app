/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ethereumserviceapp.service;

import com.example.ethereumserviceapp.contract.CaseMonitor;
import com.example.ethereumserviceapp.model.Case;
import com.example.ethereumserviceapp.contract.VcRevocationRegistry;
import java.util.List;
import java.util.Optional;
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

    public void updateCase(Case monitoredCase);

    public boolean checkIfCaseExists(String uuid);

    //remove when monitorService is completed
    public List<Case> getAllCases();

    //remove when monitorService is completed
    public void monitorCases();
    public VcRevocationRegistry getRevocationContract();

    public boolean checkRevocationStatus(String uuid);

    public void revokeCredentials(String uuid);

}
