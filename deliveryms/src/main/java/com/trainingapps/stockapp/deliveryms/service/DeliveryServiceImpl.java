package com.trainingapps.stockapp.deliveryms.service;

import com.trainingapps.stockapp.deliveryms.constant.DeliveryStatus;
import com.trainingapps.stockapp.deliveryms.dto.AddDeliveryRequest;
import com.trainingapps.stockapp.deliveryms.dto.ChangeDeliveryStatus;
import com.trainingapps.stockapp.deliveryms.dto.DeliveryDetails;
import com.trainingapps.stockapp.deliveryms.entity.Delivery;
import com.trainingapps.stockapp.deliveryms.exceptions.DeliveryOrderNotFoundException;
import com.trainingapps.stockapp.deliveryms.exceptions.InvalidDeliveryStatusTypeException;
import com.trainingapps.stockapp.deliveryms.repository.IDeliveryRepository;
import com.trainingapps.stockapp.deliveryms.util.DeliveryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Transactional
@Service
public class DeliveryServiceImpl implements IDeliveryService {
    @Autowired
    private IDeliveryRepository repository;

    @Autowired
    private DeliveryUtil deliveryUtil;

    @Override
    public DeliveryDetails add(AddDeliveryRequest request)  {

        Optional<Delivery> optional = repository.findByOrderId(request.getOrderId());
        if (optional.isEmpty()) {
            Delivery delivery = new Delivery();
            delivery.setOrderId(request.getOrderId());
            delivery.setDeliveryStatus(DeliveryStatus.NOT_DISPATCHED);
            LocalDate deliveryDate= deliveryUtil.stringToDate(request.getDeliveredDate());
            delivery.setDeliveredDate(deliveryDate);
            delivery = repository.save(delivery);
            DeliveryDetails desired = deliveryUtil.toDeliveryDetails(delivery);
            return desired;
        }
        Delivery delivery = optional.get();
        DeliveryDetails response = deliveryUtil.toDeliveryDetails(delivery);
        return response;

    }

    @Override
    public DeliveryDetails findDeliveryDetailsByOrderId(Long orderid) throws DeliveryOrderNotFoundException {
        Delivery delivery =findByOrderId(orderid);
        DeliveryDetails response = deliveryUtil.toDeliveryDetails(delivery);
        return response;

    }
    public Delivery findByOrderId(Long orderid) throws DeliveryOrderNotFoundException {
        Optional<Delivery> optional = repository.findByOrderId(orderid);
        if (optional.isEmpty()) {
            throw new DeliveryOrderNotFoundException("delivery not found in database");
        }

        Delivery delivery = optional.get();
        return delivery;
    }

    @Override
    public DeliveryDetails changeDeliveryStatus(ChangeDeliveryStatus request) throws InvalidDeliveryStatusTypeException, DeliveryOrderNotFoundException {

        Delivery delivery = findByOrderId(request.getOrderId());
        DeliveryStatus status = deliveryUtil.toEnum(request.getDeliveryStatus());
        delivery.setDeliveryStatus(status);
        LocalDate deliveryDate= deliveryUtil.stringToDate(request.getDeliveredDate());
        delivery.setDeliveredDate(deliveryDate);
        delivery = repository.save(delivery);
        DeliveryDetails response = deliveryUtil.toDeliveryDetails(delivery);
        return response;


    }

}
