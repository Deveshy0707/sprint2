package com.trainingapps.stockapp.orderms.service;

import com.trainingapps.stockapp.orderms.dto.CreatedOrderRequest;
import com.trainingapps.stockapp.orderms.dto.OrderDetails;
import com.trainingapps.stockapp.orderms.exceptions.OrderNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Validated
public interface ICreatedOrderService {

    OrderDetails create(@NotNull @Valid CreatedOrderRequest request);

    OrderDetails findOrderDetailsById(@Min(1)Long orderId)throws OrderNotFoundException;

    List<OrderDetails>findAllOrders(@NotEmpty  String startDate,@NotEmpty String endDate);

    List<OrderDetails>findAllOrders(LocalDate startDate, LocalDate endDate);
}
