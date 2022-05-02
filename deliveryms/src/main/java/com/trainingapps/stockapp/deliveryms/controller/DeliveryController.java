package com.trainingapps.stockapp.deliveryms.controller;

import com.trainingapps.stockapp.deliveryms.dto.AddDeliveryRequest;
import com.trainingapps.stockapp.deliveryms.dto.ChangeDeliveryStatus;
import com.trainingapps.stockapp.deliveryms.dto.DeliveryDetails;

import com.trainingapps.stockapp.deliveryms.service.IDeliveryService;
import com.trainingapps.stockapp.deliveryms.util.DeliveryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/delivery")
@RestController
public class DeliveryController {
    @Autowired
    private IDeliveryService service;

    @Autowired
    private DeliveryUtil deliveryUtil;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add")
    public DeliveryDetails add(@RequestBody AddDeliveryRequest request) throws Exception {
        DeliveryDetails response = service.add(request);
        return response;
    }


    @GetMapping("/findbyid/{id}")
    public DeliveryDetails findDeliveryDetailsbyId(@PathVariable ("id") Long id)throws Exception{
        DeliveryDetails response=service.findDeliveryDetailsByOrderId(id);
        return  response;
    }
    @PutMapping("/changestatus")
    public DeliveryDetails changeDeliveryStatus(@RequestBody ChangeDeliveryStatus request)throws Exception{
        DeliveryDetails response=service.changeDeliveryStatus(request);
        return response;
    }
}
