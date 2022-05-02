package com.trainingapps.stockapp.orderms.service;

import com.trainingapps.stockapp.orderms.dto.CreatedOrderRequest;
import com.trainingapps.stockapp.orderms.dto.OrderDetails;
import com.trainingapps.stockapp.orderms.dto.StockDetails;
import com.trainingapps.stockapp.orderms.dto.StockRequest;
import com.trainingapps.stockapp.orderms.entity.CreatedOrder;
import com.trainingapps.stockapp.orderms.entity.OrderStock;
import com.trainingapps.stockapp.orderms.exceptions.OrderNotFoundException;
import com.trainingapps.stockapp.orderms.repository.ICreatedOrderRepository;
import com.trainingapps.stockapp.orderms.util.DateUtil;
import com.trainingapps.stockapp.orderms.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

/*
 * Service class contains methods: to create order,
 *  calculate  total order cost, find orders by id, find all orders
 */

@Service
public class CreatedOrderServiceImpl implements ICreatedOrderService {

    @Autowired
    private OrderUtil orderUtil;

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private ICreatedOrderRepository orderRepository;

    @Transactional
    @Override
    public OrderDetails create(CreatedOrderRequest request){
        CreatedOrder createdOrder = new CreatedOrder();
        createdOrder.setOrderDate(LocalDate.now());
        List<StockRequest> stocksRequestData = request.getStocksRequest();
        List<OrderStock> orderedStocks = stocksRequestData.stream().
                map(stockRequest -> convertToOrderStock(stockRequest))
                .collect(Collectors.toList());
        createdOrder.setOrderedStocks(orderedStocks);
        double orderCost = totalOrderCost(orderedStocks);
        createdOrder.setOrderPrice(orderCost);
        createdOrder = orderRepository.save(createdOrder);
        return orderUtil.toOrderDetails(createdOrder);
    }

    public double totalOrderCost(Collection<OrderStock> stocks) {
        System.out.println("inside totalOrder cost=" + stocks.size());
        double total = stocks.stream().
                mapToDouble(orderStock -> orderStock.getPricePerUnit() * orderStock.getUnits())
                .sum();
        return total;
    }

    OrderStock convertToOrderStock(StockRequest request) {
        StockDetails stockDetails = orderUtil.fetchStockDetails(request.getStockId());
        OrderStock orderStock = new OrderStock();
        orderStock.setStockId(request.getStockId());
        orderStock.setPricePerUnit(stockDetails.getPrice());
        orderStock.setUnits(request.getOrderedUnits());
        return orderStock;
    }


    @Override
    public OrderDetails findOrderDetailsById(Long orderId) throws OrderNotFoundException{
		Optional<CreatedOrder> optional = orderRepository.findById(orderId);
        if (!optional.isPresent()) {
            throw new OrderNotFoundException("Order not found");
        }
        CreatedOrder createdOrder = optional.get();
		OrderDetails response = orderUtil.toOrderDetails(createdOrder);
        return response;
    }

    @Override
    public List<OrderDetails> findAllOrders(LocalDate startDate, LocalDate endDate) {
        List<CreatedOrder> orders = orderRepository.findInPeriod(startDate, endDate);
        List<OrderDetails> desired = orderUtil.toListOrderDetail(orders);
        return desired;
    }

    @Override
    public List<OrderDetails> findAllOrders(String startDateText, String endDateText) {
        LocalDate startDate = dateUtil.convertToDate(startDateText);
        LocalDate endDate = dateUtil.convertToDate(endDateText);
        return findAllOrders(startDate, endDate);
    }
}
