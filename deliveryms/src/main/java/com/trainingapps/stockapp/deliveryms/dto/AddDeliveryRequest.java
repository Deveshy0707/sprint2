package com.trainingapps.stockapp.deliveryms.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.Min;
import java.time.LocalDate;

// To add Delivery Request
public class AddDeliveryRequest {
    @Min(1)
    private Long orderId;
    private String deliveredDate;
    public Long getOrderId() {
        return orderId;
    }

    public String getDeliveredDate() {
        return deliveredDate;
    }

}
