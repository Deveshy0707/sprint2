package com.trainingapps.stockapp.deliveryms.util;

import com.trainingapps.stockapp.deliveryms.constant.DeliveryStatus;
import com.trainingapps.stockapp.deliveryms.dto.DeliveryDetails;
import com.trainingapps.stockapp.deliveryms.entity.Delivery;
import com.trainingapps.stockapp.deliveryms.exceptions.InvalidDeliveryStatusTypeException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DeliveryUtil {

    private DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public DeliveryDetails toDeliveryDetails(Delivery delivery){

        DeliveryStatus deliveryStatus=delivery.getDeliveryStatus();
        String deliveryText=deliveryStatus.toString();
        String date = dateToString(delivery.getDeliveredDate());

        DeliveryDetails desired=new DeliveryDetails();
        desired.setId(delivery.getId());
        desired.setOrderId(delivery.getOrderId());
        desired.setDeliveredDate(date);
        desired.setDeliveryStatus(deliveryText);
        return desired;
    }
    public String dateToString(LocalDate date){
        String str=date.format(formatter);
        return str;
    }

    public LocalDate stringToDate(String str){
        LocalDate date = LocalDate.parse(str, formatter);
        return date;
    }

    public DeliveryStatus toEnum(String deliveryText) throws InvalidDeliveryStatusTypeException {
        DeliveryStatus values[] = DeliveryStatus.values();
        for (DeliveryStatus iterated : values) {
            String iteratedText = iterated.toString();
            if (iteratedText.equalsIgnoreCase(deliveryText)) {
                return iterated;
            }
        }
        throw new InvalidDeliveryStatusTypeException("Invalid delivery status type") ;
    }
}
