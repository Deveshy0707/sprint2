package com.trainingapps.stockapp.stockms.util;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.trainingapps.stockapp.stockms.dto.StockDetails;
import com.trainingapps.stockapp.stockms.entity.Stock;


/*
 * StockUtil class 
 * Methods to: get complete StockDetails
 */
@Component
public class StockUtil {

	public StockDetails toStockDetails(@Valid Stock stock) {

		return new StockDetails(stock.getId(), stock.getUnits(), stock.getStockName(), stock.getPrice());

	}

}
