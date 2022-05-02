package com.trainingapps.stockapp.orderms.entity;

import javax.persistence.*;
import java.util.Objects;

/*
 * OrderStock is an entity class with the information about ordered stocks.
 * primary key: id
 * pricePerUnit will be fetched from stocks module on the basis of stockId
 */

@Table(name="orderstock")
@Entity
public class OrderStock {
    @GeneratedValue
    @Id
    private Long id;
    @Column(nullable = false)
    private Long stockId;
    @Column(nullable = false)
    private Integer units;
    @Column(nullable = false)
    private Double pricePerUnit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderStock)) return false;
        OrderStock that = (OrderStock) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
