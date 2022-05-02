package com.trainingapps.stockapp.stockms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.stockapp.stockms.dto.AddStockRequest;
import com.trainingapps.stockapp.stockms.dto.DecreaseQuantityRequest;
import com.trainingapps.stockapp.stockms.dto.IncreaseQuantityRequest;
import com.trainingapps.stockapp.stockms.dto.StockDetails;
import com.trainingapps.stockapp.stockms.exceptions.InvalidUnitsException;
import com.trainingapps.stockapp.stockms.exceptions.NotEnoughUnitsException;
import com.trainingapps.stockapp.stockms.exceptions.StockNotFoundException;
import com.trainingapps.stockapp.stockms.service.IStockService;

/*
 *  Base url: /stocks
 *  Add stock using: /stocks/create
 *  Find stock by id: /stocks/byId/{orderId}
 *  Increase in units by: /stocks/increase
 *  Decrease in units by: /stocks/decrease
 */

@RequestMapping("/stocks")
@RestController
public class StockController {

	@Autowired
	private IStockService service;

	@PostMapping(value = "/add")
	public StockDetails add(@RequestBody AddStockRequest requestData) throws InvalidUnitsException {
		return service.addStock(requestData);

	}

	@GetMapping("/byId/{id}")
	public StockDetails findById(@PathVariable Long id) throws StockNotFoundException {
		return service.findStockDetailsById(id);

	}

	@PutMapping("/increase")
	public StockDetails increase(@RequestBody IncreaseQuantityRequest request)
			throws InvalidUnitsException, StockNotFoundException {
		return service.increaseQuantity(request);

	}

	@PutMapping("/decrease")
	public StockDetails decrease(@RequestBody DecreaseQuantityRequest request)
			throws InvalidUnitsException, StockNotFoundException, NotEnoughUnitsException {
		return service.decreaseQuantity(request);

	}

}
