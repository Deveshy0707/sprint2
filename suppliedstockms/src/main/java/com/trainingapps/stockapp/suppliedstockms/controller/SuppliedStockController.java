package com.trainingapps.stockapp.suppliedstockms.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.stockapp.suppliedstockms.dto.AddSupplyStockRequest;
import com.trainingapps.stockapp.suppliedstockms.dto.SuppliedStockDetails;
import com.trainingapps.stockapp.suppliedstockms.exception.SuppliedStockNotFoundException;
import com.trainingapps.stockapp.suppliedstockms.service.ISuppliedStockService;

/**
 * @author DELL 
 * 3 rest end points have been created
 * 1.)  localhost:8586/suppliedstock/add                        =>  for adding the supppliedstock details
 * 2.)  localhost:8586/suppliedstock/findByStockId/{stockId}    =>  for finding the suppplied stock by stockid
 * 3.)  localhst:8586/suppliedstock/findBySupplierId            =>  for findng by supplierId in given time frame
 *
 */

@RequestMapping("/suppliedstock")
@RestController
@Validated
public class SuppliedStockController {

	@Autowired
	private ISuppliedStockService service;

	@PostMapping("/add")
	public SuppliedStockDetails addSuppliedStock(@RequestBody @Valid AddSupplyStockRequest request) {
		return service.add(request);
	}
	//@RequestMapping(value="/findByStockId/{id}", method=RequestMethod.GET)
	@GetMapping("/findByStockId/{stockId}")
	public List<SuppliedStockDetails> findStockById(@PathVariable @Min(1) long stockId)
			throws SuppliedStockNotFoundException {
		List<SuppliedStockDetails> response = service.findSuppliedStockDetailsByStockId(stockId);
		return response;
	}

	@GetMapping("/findBySupplierId")
	public List<SuppliedStockDetails> findAll(@RequestParam Long supplierId, @RequestParam String startDate,
			@RequestParam String endDate) {
		List<SuppliedStockDetails> orders = service.findSuppliedStockBySupplierId(supplierId, startDate, endDate);
		return orders;
	}

}
