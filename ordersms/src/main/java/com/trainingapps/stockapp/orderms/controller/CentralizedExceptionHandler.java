package com.trainingapps.stockapp.orderms.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trainingapps.stockapp.orderms.exceptions.InvalidAvailabilityStatusException;
import com.trainingapps.stockapp.orderms.exceptions.OrderNotFoundException;
import com.trainingapps.stockapp.orderms.exceptions.StockNotFoundException;

/*
 * All the exceptions will be handled by this centralized exception handler
 * HttpStatus.NOT_FOUND: 404
 * HttpStatus.BAD_REQUEST
 */

@RestControllerAdvice
public class CentralizedExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ OrderNotFoundException.class, StockNotFoundException.class })
	public String handleNotFound(OrderNotFoundException ex) {
		return ex.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ InvalidAvailabilityStatusException.class, MethodArgumentNotValidException.class,
			ConstraintViolationException.class })
	public String handleInvalid(Exception ex) {
		return ex.getMessage();
	}
}
