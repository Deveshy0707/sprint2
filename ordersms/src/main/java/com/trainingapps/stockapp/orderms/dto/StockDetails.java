package com.trainingapps.stockapp.orderms.dto;

/*
 *  StockDetails class contains stock information: stock id, units, namme and price
 */

public class StockDetails {
    private Long id;
    private int units;
    private String stockName;
    private double price;

    public StockDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
