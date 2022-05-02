package com.trainingapps.stockapp.stockms.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trainingapps.stockapp.stockms.exceptions.InvalidIdException;
import com.trainingapps.stockapp.stockms.exceptions.InvalidUnitsException;
import com.trainingapps.stockapp.stockms.exceptions.NotEnoughUnitsException;
import com.trainingapps.stockapp.stockms.exceptions.StockNotFoundException;

/*
 * All the exceptions will be handled by this centralized exception handler
 */

@Component
@RestControllerAdvice
public class CentralizedExceptionHandler {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(StockNotFoundException.class)
	public String handleStudentNotFound(StockNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ InvalidIdException.class, InvalidUnitsException.class, NotEnoughUnitsException.class,
			MethodArgumentNotValidException.class, ConstraintViolationException.class })
	public String handleInvalid(Exception e) {
		return e.getMessage();
	}

}
