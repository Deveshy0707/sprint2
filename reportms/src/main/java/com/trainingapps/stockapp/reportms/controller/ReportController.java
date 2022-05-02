package com.trainingapps.stockapp.reportms.controller;

import com.trainingapps.stockapp.reportms.dto.CreateReportRequest;
import com.trainingapps.stockapp.reportms.dto.ReportDetails;
import com.trainingapps.stockapp.reportms.service.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Devesh Yadav
 * Rest Controller class
 */
@RequestMapping("/reports")
@RestController
public class ReportController {

    @Autowired
    private ReportServiceImpl service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/generate")
    public ReportDetails generateReport(@RequestBody CreateReportRequest request){
        ReportDetails response=service.generateReportInPeriod(request);

        return response;
    }

    @GetMapping("/findbyid/{id}")
    public ReportDetails findReportById(@PathVariable ("id") Long id) throws Exception {
        ReportDetails response=service.findReportDetailsById(id);

        return response;
    }
}
