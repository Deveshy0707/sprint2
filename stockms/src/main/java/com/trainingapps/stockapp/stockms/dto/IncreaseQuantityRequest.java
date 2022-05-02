package com.trainingapps.stockapp.stockms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/*
 *  IncreaseQuantityRequest dto has units to increase there values using id
 */

public class IncreaseQuantityRequest {
	@Min(1)
	@NotNull
	private Long id;
	
	@Min(1)
	@NotNull
	private int newUnits;

	public int getNewUnits() {
		return newUnits;
	}

	public void setNewUnits(int newUnits) {
		this.newUnits = newUnits;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
