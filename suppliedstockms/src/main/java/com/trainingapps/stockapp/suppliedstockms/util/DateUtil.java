package com.trainingapps.stockapp.suppliedstockms.util;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

/**
 * @author DELL Date format "dd-MM-yyyy" converting date to string and 
 * string to date
 *
 */
@Component
public class DateUtil {

	final String pattern = "dd-MM-yyyy";

	private DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);

// convert String to LocalDate format
	public LocalDate convertToDate(String text) {
		LocalDate date = LocalDate.parse(text, format);
		return date;
	}

// convert LocalDate to String format
	public String convertToText(LocalDate date) {
		String text = date.format(format);
		return text;
	}
}
