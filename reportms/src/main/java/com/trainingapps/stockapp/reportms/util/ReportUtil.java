package com.trainingapps.stockapp.reportms.util;


import com.trainingapps.stockapp.reportms.dto.OrderDetails;
import com.trainingapps.stockapp.reportms.dto.ReportDetails;
import com.trainingapps.stockapp.reportms.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Devesh Yadav
 * Utility class
 * conatining some methods for conversion
 */
@Component
public class ReportUtil {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${order.baseUrl}")
    private String ordermsBaseUrl;

    private final DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     * For conversion of Report object to ReportDetails
     *
     */
    public ReportDetails reportToReportDetails(Report obj){
        String startPeriod=dateToString(obj.getStartPeriod());
        String endPeriod=dateToString(obj.getEndPeriod());
        String createdDate=dateToString(obj.getCreatedDate());

        ReportDetails desired= new ReportDetails();

        desired.setId(obj.getId());
        desired.setStartPeriod(startPeriod);
        desired.setEndPeriod(endPeriod);
        desired.setCreatedDate(createdDate);
        desired.setTotalSaleAmount(obj.getTotalSaleAmount());
        desired.setOrdersCount(obj.getOrdersCount());

        return desired;
    }

    /**
     * For conversion of LocalDate object to String object
     *
     */
    public String dateToString(LocalDate date){
        String str=date.format(formatter);
        return str;
    }

    /**
     * For conversion of String object to LocalDate object
     *
     */
    public LocalDate stringToDate(String str){
        LocalDate date = LocalDate.parse(str, formatter);
        return date;
    }

    /**
     * For getting List<OrderDetails>, from orderms microservice
     *
     */
    public List<OrderDetails> getListOfOrderDetails(String startDate, String endDate){
        String url= ordermsBaseUrl + "/all/"+ startDate+ "/" +endDate;
        OrderDetails[] orders = restTemplate.getForObject(url, OrderDetails[].class);
        List<OrderDetails> list= Arrays.asList(orders);
        return list;
    }

}
