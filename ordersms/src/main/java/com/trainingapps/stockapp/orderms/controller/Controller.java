package com.trainingapps.stockapp.orderms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.stockapp.orderms.dto.CreatedOrderRequest;
import com.trainingapps.stockapp.orderms.dto.OrderDetails;
import com.trainingapps.stockapp.orderms.exceptions.OrderNotFoundException;
import com.trainingapps.stockapp.orderms.service.ICreatedOrderService;
import com.trainingapps.stockapp.orderms.util.OrderUtil;

/*
 *  Base url: /orders
 *  Create an order using: /orders/create
 *  Find order by id: /orders/byId/{orderId}
 *  Find all orders in a given period: /orders/all
 */

@RequestMapping("/orders")
@RestController
public class Controller {

	@Autowired
	ICreatedOrderService service;

	@Autowired
	OrderUtil util;

	@PostMapping("/create")
	public OrderDetails createOrder(@RequestBody CreatedOrderRequest request) {
		OrderDetails createdOrder = service.create(request);
		return createdOrder;
	}

	@GetMapping("/byId/{orderId}")
	public OrderDetails getById(@PathVariable Long orderId) throws OrderNotFoundException {
		OrderDetails orderDetails = service.findOrderDetailsById(orderId);
		return orderDetails;
	}

	@GetMapping("/all/{startDate}/{endDate}")
	public List<OrderDetails> findAll(@PathVariable String startDate, @PathVariable String endDate) {
		List<OrderDetails> orders = service.findAllOrders(startDate, endDate);
		return orders;
	}

}
