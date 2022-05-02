package com.trainingapps.stockapp.orderms.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Converts input String date to LocalDate and vice-versa
 */
@Component
public class DateUtil {

    final String pattern="dd-MM-yyyy";
    private DateTimeFormatter format =DateTimeFormatter.ofPattern(pattern);

    /*
       dd-MM-yyyy
       26-11-2021

     */
    public LocalDate convertToDate(String text){
        LocalDate date=LocalDate.parse(text, format);
        return date;
    }

    public String convertToText(LocalDate date){
        String text= date.format(format);
        return text;
    }



}
