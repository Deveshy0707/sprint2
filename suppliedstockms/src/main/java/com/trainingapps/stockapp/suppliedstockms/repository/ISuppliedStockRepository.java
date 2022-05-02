package com.trainingapps.stockapp.suppliedstockms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.trainingapps.stockapp.suppliedstockms.entity.SuppliedStock;

/**
 * @author DELL 
 *  findbyStockId method is created  to find the stock by stockId
 *  findBySupplierIdInPeriod is created to find by supplierId in given time frame 
 * 
 *
 */
@Repository
public interface ISuppliedStockRepository extends JpaRepository<SuppliedStock, Long> {

	List<SuppliedStock> findByStockId(long stockId);

	@Query("from SuppliedStock where supplierId = :supplierId and suppliedDate between :startDate and :endDate ")
	List<SuppliedStock> findBySupplierIdInPeriod(@Param("supplierId") Long supplierId,
			@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
