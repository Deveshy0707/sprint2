package com.trainingapps.stockapp.reportms.controller;

import com.trainingapps.stockapp.reportms.exceptions.ReportNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * Author: Devesh Yadav
 * Centralized Exception Handling class
 */
@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ReportNotFoundException.class)
    public String notFoundExceptionHandling(Exception e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String invalidExceptionHandling(ConstraintViolationException e){
        return e.getMessage();
    }
}
