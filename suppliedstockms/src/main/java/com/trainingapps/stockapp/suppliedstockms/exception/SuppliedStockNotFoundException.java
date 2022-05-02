package com.trainingapps.stockapp.suppliedstockms.exception;

/**
 * @author DELL
 * if supplied stock is not found then return this exception
 *
 */
public class SuppliedStockNotFoundException extends Exception {
	public SuppliedStockNotFoundException(String msg) {
		super(msg);
	}

}
