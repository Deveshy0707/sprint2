package com.trainingapps.stockapp.reportms.dto;

import java.util.List;

public class OrderDetails {
    private Long orderId;
    private String orderDate;
    private double orderPrice;
    private List<OrderStockDetails> stocks;

    public List<OrderStockDetails> getStocks() {
        return stocks;
    }

    public void setStocks(List<OrderStockDetails> stocks) {
        this.stocks = stocks;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

}
