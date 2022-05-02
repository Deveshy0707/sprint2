package com.trainingapps.stockapp.orderms.repository;

import com.trainingapps.stockapp.orderms.entity.OrderStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderStockRepository extends JpaRepository<OrderStock,Long> {


}
