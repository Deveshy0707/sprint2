package com.trainingapps.stockapp.deliveryms.dto;


import java.time.LocalDate;

// to Change the status of delivery
public class ChangeDeliveryStatus {

    private String deliveryStatus;
    private Long orderId;
    private String deliveredDate;


    public String getDeliveryStatus() {
        return deliveryStatus;
    }
    public Long getOrderId() {
        return orderId;
    }

    public String getDeliveredDate() {
        return deliveredDate;
    }

}
