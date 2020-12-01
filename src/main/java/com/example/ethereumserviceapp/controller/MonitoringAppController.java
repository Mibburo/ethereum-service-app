package com.example.ethereumserviceapp.controller;

import java.lang.ProcessHandle.Info;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.example.ethereumserviceapp.model.Case;
import com.example.ethereumserviceapp.service.EthereumService;
import com.example.ethereumserviceapp.service.MongoService;
import com.example.ethereumserviceapp.service.MonitorService;
import com.example.ethereumserviceapp.utils.ByteConverters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MonitoringAppController {

    @Autowired
    EthereumService ethService;

    @Autowired
    MongoService mongoServ;

    @Autowired
    MonitorService monitorService;

    @GetMapping("/listCaseUuids")
    protected ModelAndView listCaseUuids(ModelMap model, HttpServletRequest request){

        List<String> ethUuids = ethService.getAllCaseUUID();
        model.addAttribute("ethUuids", ethUuids);

        return new ModelAndView("showCases");
        
    }

    @GetMapping("/getCase")
    protected ModelAndView getCase(@RequestParam(value = "uuid", required = true) String uuid, ModelMap model, HttpServletRequest request){

        Optional<Case> ethCase = ethService.getCaseByUUID(uuid);
        model.addAttribute("ethCase", ethCase.isPresent()? ethCase.get() : "");
        
        return new ModelAndView("showCase");
    }
    
}
