package com.trainingapps.stockapp.stockms.manualtesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trainingapps.stockapp.stockms.dto.AddStockRequest;
import com.trainingapps.stockapp.stockms.dto.DecreaseQuantityRequest;
import com.trainingapps.stockapp.stockms.dto.IncreaseQuantityRequest;
import com.trainingapps.stockapp.stockms.dto.StockDetails;
import com.trainingapps.stockapp.stockms.service.IStockService;

/*
 * Manual class was created for manual testing(before controller)
 */
@Component
public class ManualTesting {

	@Autowired
	private IStockService service;

	public void runUI() {

		try {
			AddStockRequest addStockRequest1 = new AddStockRequest();

			addStockRequest1.setStockName("jio");
			addStockRequest1.setUnits(10);
			addStockRequest1.setPrice(1000);
			StockDetails stock1 = service.addStock(addStockRequest1);
			display(stock1);

			Long stockDetails1Id = stock1.getId();
			StockDetails stocks = service.findStockDetailsById(stockDetails1Id);
			display(stocks);

			int newUnits = 5;
			IncreaseQuantityRequest increaseRequest = new IncreaseQuantityRequest();
			increaseRequest.setId(stockDetails1Id);
			increaseRequest.setNewUnits(newUnits);
			StockDetails increasedStock = service.increaseQuantity(increaseRequest);
			display(increasedStock);

			int units = 2;
			DecreaseQuantityRequest decreaseRequest = new DecreaseQuantityRequest();
			decreaseRequest.setId(stockDetails1Id);
			decreaseRequest.setUnits(units);
			StockDetails decreaseStock = service.decreaseQuantity(decreaseRequest);
			display(decreaseStock);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	void display(StockDetails stock) {
		System.out
				.println(stock.getId() + "-" + stock.getStockName() + "-" + stock.getPrice() + "-" + stock.getUnits());
	}

}
