package com.trainingapps.stockapp.reportms.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Author: Devesh Yadav
 * Entity class
 */
@Table(name = "Reports")
@Entity
public class Report {

    @GeneratedValue
    @Id
    private Long id;  //report id
    @Column(nullable=false)
    private LocalDate startPeriod;
    @Column(nullable=false)
    private LocalDate endPeriod;
    @Column(nullable=false)
    private LocalDate createdDate;
    @Column(nullable=false)
    private double totalSaleAmount;
    @Column(nullable=false)
    private Long ordersCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(LocalDate startPeriod) {
        this.startPeriod = startPeriod;
    }

    public LocalDate getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(LocalDate endPeriod) {
        this.endPeriod = endPeriod;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public double getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public void setTotalSaleAmount(double totalSaleAmount) {
        this.totalSaleAmount = totalSaleAmount;
    }

    public Long getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(Long ordersCount) {
        this.ordersCount = ordersCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return id.equals(report.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
