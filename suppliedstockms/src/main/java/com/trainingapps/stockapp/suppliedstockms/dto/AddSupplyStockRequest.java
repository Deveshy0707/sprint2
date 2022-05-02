package com.trainingapps.stockapp.suppliedstockms.dto;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author DELL adding supplied stock
 * stockId => !< 1
 * supplierId => !< 1
 * suppliedCost => != null
 * units => !<  1
 *
 */
public class AddSupplyStockRequest {
	@Min(1)
	@Column(nullable = false)
	private long stockId;
	@Min(1)
	@Column(nullable = false)
	private long supplierId;
	@Column(nullable = false)
	private String suppliedDate;
	@Column(nullable = false)
	private Double suppliedCost;
	@Min(1)
	@Column(nullable = false)
	private int units;

	public long getStockId() {
		return stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSuppliedDate() {
		return suppliedDate;
	}

	public void setSuppliedDate(String suppliedDate) {
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
}
