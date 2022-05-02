package com.trainingapps.stockapp.deliveryms.controller;

import com.trainingapps.stockapp.deliveryms.exceptions.DeliveryOrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DeliveryOrderNotFoundException.class)
    public String notFoundExceptionHandling(Exception e){
        return e.getMessage();
    }


}


