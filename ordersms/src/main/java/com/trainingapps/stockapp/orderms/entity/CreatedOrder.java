package com.trainingapps.stockapp.orderms.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/*
 * CreatedOrder is the entity class that will contain the created orders. 
 * Primary key: id
 * One to Many relationship with another entity class: OrderStock
 */

@Table(name="created_orders")
@Entity
public class CreatedOrder {
    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false)
    private LocalDate orderDate;
    @Column(nullable = false)
    private Double orderPrice;


    @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @Column(nullable = false)
    private List<OrderStock> orderedStocks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public List<OrderStock> getOrderedStocks() {
        return orderedStocks;
    }

    public void setOrderedStocks(List<OrderStock> orderedStocks) {
        this.orderedStocks = orderedStocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreatedOrder)) return false;
        CreatedOrder that = (CreatedOrder) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
