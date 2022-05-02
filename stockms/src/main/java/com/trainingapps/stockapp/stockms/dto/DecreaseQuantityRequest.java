package com.trainingapps.stockapp.stockms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/*
 *  DecreaseQuantityRequest dto has units to decrease there values using id
 */
public class DecreaseQuantityRequest {
	@Min(1)
	@NotNull
	private Long id;
	
	@Min(1)
	@NotNull
	private int units;

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
