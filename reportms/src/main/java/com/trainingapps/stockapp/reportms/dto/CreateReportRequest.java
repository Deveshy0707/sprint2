package com.trainingapps.stockapp.reportms.dto;

import javax.validation.constraints.NotEmpty;

/**
 * Author: Devesh Yadav
 * Request dto class
 */
public class CreateReportRequest {

    @NotEmpty
    private String startPeriod;
    @NotEmpty
    private String endPeriod;

    public void setStartPeriod(String startPeriod) {
        this.startPeriod = startPeriod;
    }

    public void setEndPeriod(String endPeriod) {
        this.endPeriod = endPeriod;
    }

    public String getStartPeriod() {
        return startPeriod;
    }

    public String getEndPeriod() {
        return endPeriod;
    }

}
