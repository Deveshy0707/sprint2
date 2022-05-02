package com.trainingapps.stockapp.deliveryms.service;

import com.trainingapps.stockapp.deliveryms.dto.AddDeliveryRequest;
import com.trainingapps.stockapp.deliveryms.dto.ChangeDeliveryStatus;
import com.trainingapps.stockapp.deliveryms.dto.DeliveryDetails;
import com.trainingapps.stockapp.deliveryms.entity.Delivery;
import com.trainingapps.stockapp.deliveryms.exceptions.DeliveryOrderNotFoundException;
import com.trainingapps.stockapp.deliveryms.exceptions.InvalidDeliveryStatusTypeException;

public interface IDeliveryService {
    DeliveryDetails add(AddDeliveryRequest request) ;

    DeliveryDetails findDeliveryDetailsByOrderId(Long orderid) throws DeliveryOrderNotFoundException;

    DeliveryDetails changeDeliveryStatus(ChangeDeliveryStatus request) throws InvalidDeliveryStatusTypeException, DeliveryOrderNotFoundException;
}
