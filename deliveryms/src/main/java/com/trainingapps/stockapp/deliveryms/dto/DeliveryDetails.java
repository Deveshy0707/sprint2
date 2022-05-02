package com.trainingapps.stockapp.deliveryms.dto;

import com.trainingapps.stockapp.deliveryms.constant.DeliveryStatus;

import java.time.LocalDate;

// to get the details of the delivery
public class DeliveryDetails {

    private Long id;
    private Long orderId;
    private String deliveredDate;

    private String deliveryStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(String deliveredDate) {
        this.deliveredDate = deliveredDate;
    }


}
