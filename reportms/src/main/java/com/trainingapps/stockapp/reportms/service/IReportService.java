package com.trainingapps.stockapp.reportms.service;

import com.trainingapps.stockapp.reportms.exceptions.ReportNotFoundException;
import com.trainingapps.stockapp.reportms.dto.CreateReportRequest;
import com.trainingapps.stockapp.reportms.dto.ReportDetails;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * Author: Devesh Yadav
 * service interface
 */
@Validated
public interface IReportService {

    ReportDetails generateReportInPeriod(@Valid CreateReportRequest request);

    ReportDetails findReportDetailsById(@Min(1) Long reportId) throws ReportNotFoundException;

}
