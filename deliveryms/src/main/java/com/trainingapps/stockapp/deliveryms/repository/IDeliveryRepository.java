package com.trainingapps.stockapp.deliveryms.repository;

import com.trainingapps.stockapp.deliveryms.entity.Delivery;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDeliveryRepository extends JpaRepository<Delivery,Long> {
    Optional<Delivery> findByOrderId(Long orderid);

}
