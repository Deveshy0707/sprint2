package com.trainingapps.stockapp.orderms.repository;

import com.trainingapps.stockapp.orderms.entity.CreatedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ICreatedOrderRepository extends JpaRepository<CreatedOrder,Long> {

    @Query("from CreatedOrder where orderDate between :startDate and :endDate ")
    List<CreatedOrder>findInPeriod(@Param("startDate")LocalDate startDate,@Param("endDate") LocalDate endDate);
}
