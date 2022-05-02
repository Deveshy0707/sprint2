package com.trainingapps.stockapp.suppliedstockms.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trainingapps.stockapp.suppliedstockms.exception.SuppliedStockNotFoundException;

/**
 * @author DELL central exceptional handling
 *
 */

@RestControllerAdvice
public class CentralisedExceptionHandling {

//	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler( SuppliedStockNotFoundException.class)
	public String handleNotFoundException(Exception e) {
		return e.getMessage();
	}
	

}
