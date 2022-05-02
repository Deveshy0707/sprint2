package com.trainingapps.stockapp.suppliedstockms.dto;


/**
 * @author DELL
 * supplied stock details
 *
 */
public class SuppliedStockDetails {
	private long id;
	private long stockId;
	private long supplierId;
	private String suppliedDate;
	private Double suppliedCost;
	private int units;// number of units supplied

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public void setSuppliedDate(String dateText) {
		this.suppliedDate = dateText;
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
