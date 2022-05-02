package com.trainingapps.stockapp.orderms.util;

import com.trainingapps.stockapp.orderms.constant.AvailabilityStatus;
import com.trainingapps.stockapp.orderms.dto.OrderDetails;
import com.trainingapps.stockapp.orderms.dto.OrderStockDetails;
import com.trainingapps.stockapp.orderms.dto.StockDetails;
import com.trainingapps.stockapp.orderms.entity.CreatedOrder;
import com.trainingapps.stockapp.orderms.entity.OrderStock;
import com.trainingapps.stockapp.orderms.exceptions.InvalidAvailabilityStatusException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
 * OrderUtil class 
 * Methods to: convert CreatedOrder object to OrderDetails object,
 *             convert OrderStock to OrderStockDetails,
 *             convert String to enum
 *             fetch stock details from stocks module 
 */

@Component
public class OrderUtil {
	
	@Value("${stocks.baseUrl}")
    private String baseStocksUrl;

    @Autowired
    private DateUtil dateUtil;
    
    @Autowired
    private RestTemplate restTemplate;

    public List<OrderDetails>toListOrderDetail(Collection<CreatedOrder>orders){
        return orders.stream().
                map(order->toOrderDetails(order)).collect(Collectors.toList());
    }

    public OrderDetails toOrderDetails(CreatedOrder order) {
        OrderDetails desired = new OrderDetails();
        desired.setOrderId(order.getId());
        String dateText = dateUtil.convertToText(order.getOrderDate());
        desired.setOrderPrice(order.getOrderPrice());
        desired.setOrderDate(dateText);
       List<OrderStockDetails> stocksDetail=toListOrderStockDetails(order.getOrderedStocks());
       desired.setStocks(stocksDetail);
        return desired;
    }

    public List<OrderStockDetails>toListOrderStockDetails(Collection<OrderStock> orderStocks){
        return orderStocks.stream().map(
              orderStock ->   toOrderStockDetails(orderStock)
        ).collect(Collectors.toList());
    }

    public OrderStockDetails toOrderStockDetails(OrderStock orderStock){
        OrderStockDetails desired=new OrderStockDetails();
        desired.setStockId(orderStock.getStockId());
        desired.setPricePerUnit(orderStock.getPricePerUnit());
        desired.setUnits(orderStock.getUnits());
        return desired;
    }

    public AvailabilityStatus toEnum(String availabilityText) throws InvalidAvailabilityStatusException {
        AvailabilityStatus values[] = AvailabilityStatus.values();
        for (AvailabilityStatus iterated : values) {
            String iteratedText = iterated.toString();
            if (iteratedText.equalsIgnoreCase(availabilityText)) {
                return iterated;
            }
        }
        throw new InvalidAvailabilityStatusException("Invalid availability status.");
    }

    /**
     * @Todo fetch stockdetails from stock microservice at integration time
     *
     * @param stockId
     * @return stock details
     */
    public StockDetails fetchStockDetails(Long stockId){
      
    	String fetchUrl= baseStocksUrl+"/byId/"+stockId;
    	StockDetails stockDetails=restTemplate.getForObject(fetchUrl, StockDetails.class);
    	return stockDetails;
    	
    }

}
