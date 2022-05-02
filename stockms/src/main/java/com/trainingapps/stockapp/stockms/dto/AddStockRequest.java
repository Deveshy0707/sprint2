package com.trainingapps.stockapp.stockms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
 *  AddStockRequest dto has a list of entities as field
 */
public class AddStockRequest {

	@NotBlank
	private String stockName;
	@NotNull
	private int units;
	@NotNull
	private double price;

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
