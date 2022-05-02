package com.trainingapps.stockapp.suppliedstockms.entity;

import java.time.LocalDate;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author DELL Entity class table name => SuppliedStockdetails primary field =
 *         PrimaryField =>id => Auto generated
 *
 */
@Table(name = "SuppliedStockdetails")
@Entity
public class SuppliedStock {
	@GeneratedValue
	@Id
	private Long id;
	@Column(nullable = false)
	private Long stockId;
	@Column(nullable = false)
	private Long supplierId;
	@Column(nullable = false)
	private LocalDate suppliedDate;
	@Column(nullable = false)
	private Double suppliedCost;
	@Column(nullable = false)
	private int units;

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

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public LocalDate getSuppliedDate() {

		return suppliedDate;
	}

	public void setSuppliedDate(LocalDate suppliedDate) {

		this.suppliedDate = suppliedDate;
	}

	public Double getSuppliedCost() {
		return suppliedCost;
	}

	public void setSuppliedCost(Double suppliedCost) {
		this.suppliedCost = suppliedCost;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuppliedStock other = (SuppliedStock) obj;
		return Objects.equals(id, other.id);
	}

}
