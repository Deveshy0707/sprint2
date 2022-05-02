package com.trainingapps.stockapp.deliveryms.entity;

import com.trainingapps.stockapp.deliveryms.constant.DeliveryStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Table(name="deliveries")
@Entity

public class Delivery {
    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false)
    private Long orderId;
    //LocalDate deliveredDate=LocalDate.now();
    private LocalDate deliveredDate;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(LocalDate deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return id.equals(delivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

