package com.trainingapps.stockapp.reportms.service;

import com.trainingapps.stockapp.reportms.exceptions.ReportNotFoundException;
import com.trainingapps.stockapp.reportms.dto.OrderDetails;
import com.trainingapps.stockapp.reportms.util.ReportUtil;
import com.trainingapps.stockapp.reportms.dto.CreateReportRequest;
import com.trainingapps.stockapp.reportms.dto.ReportDetails;
import com.trainingapps.stockapp.reportms.entity.Report;
import com.trainingapps.stockapp.reportms.repository.IReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Author: Devesh Yadav
 * service implementation class
 */
@Transactional
@Service
public class ReportServiceImpl implements  IReportService{
    @Autowired
    private IReportRepository repository;
    @Autowired
    private ReportUtil reportUtil;

    /**
     * For a time period,
     * if report doesn't exist in database then generating new report
     * if report already exists in database then returning it
     *
     */
    @Override
    public ReportDetails generateReportInPeriod(CreateReportRequest request) {
        LocalDate startDate=reportUtil.stringToDate(request.getStartPeriod());
        LocalDate endDate=reportUtil.stringToDate(request.getEndPeriod());
        List<Report> reports=repository.findReportInPeriod(startDate, endDate);
        if(!reports.isEmpty()){
            Report report=reports.get(0);
            ReportDetails response=reportUtil.reportToReportDetails(report);
            return response;
        }
        Report report= makeReport(request);
        report=repository.save(report);
        ReportDetails response=reportUtil.reportToReportDetails(report);
        return response;
    }

    /**
     * finding report by id
     *
     */
    @Override
    public ReportDetails findReportDetailsById(Long reportId) throws ReportNotFoundException{
        Optional<Report> optional= repository.findById(reportId);
        if(optional.isEmpty()){
            throw new ReportNotFoundException("report not found in database");
        }
        Report record= optional.get();
        ReportDetails response=reportUtil.reportToReportDetails(record);
        return response;
    }



    public Report makeReport(CreateReportRequest request){
        List<OrderDetails> list= reportUtil.getListOfOrderDetails(request.getStartPeriod(), request.getEndPeriod());
        Report record=new Report();
        double totalSalePrice=totalSale(list);
        record.setOrdersCount((long) list.size());
        record.setTotalSaleAmount(totalSalePrice);
        record.setStartPeriod(reportUtil.stringToDate(request.getStartPeriod()));
        record.setEndPeriod(reportUtil.stringToDate(request.getEndPeriod()));
	record.setCreatedDate(LocalDate.now());
        return record;
    }
    public double totalSale(Collection<OrderDetails> list){
        double amount=0;
        for(OrderDetails it: list){
            amount+=it.getOrderPrice();
        }
        return amount;

    }

}
