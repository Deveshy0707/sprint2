package com.trainingapps.stockapp.orderms.dto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/*
 *  CreatedOrderRequest dto has a list of type StockRequest dto as field
 */

public class CreatedOrderRequest {
    @NotEmpty
    private List<StockRequest> stocksRequest;

    public List<StockRequest> getStocksRequest() {
        return stocksRequest;
    }

    public void setStocksRequest(List<StockRequest> stocksRequest) {
        this.stocksRequest = stocksRequest;
    }
}
