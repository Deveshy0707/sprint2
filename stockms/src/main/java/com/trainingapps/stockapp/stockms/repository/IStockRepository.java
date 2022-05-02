package com.trainingapps.stockapp.stockms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainingapps.stockapp.stockms.entity.Stock;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Long> {



}
