package com.trainingapps.stockapp.orderms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/*
 *  StockRequest contains stockId and orderedUnits
 *  These will be taken as input while creating an order
 */

public class StockRequest {

    @Min(1 )
    @NotNull
    private Long stockId;

    @Min(1 )
    @NotNull
    private int orderedUnits;

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public int getOrderedUnits() {
        return orderedUnits;
    }

    public void setOrderedUnits(int orderedUnits) {
        this.orderedUnits = orderedUnits;
    }
}
