package com.trainingapps.stockapp.suppliedstockms.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.trainingapps.stockapp.suppliedstockms.dto.AddSupplyStockRequest;
import com.trainingapps.stockapp.suppliedstockms.dto.SuppliedStockDetails;

import com.trainingapps.stockapp.suppliedstockms.exception.SuppliedStockNotFoundException;

/**
 * @author DELL
 * interface created for service class
 *
 */
@Validated
public interface ISuppliedStockService {
	SuppliedStockDetails add(@Valid AddSupplyStockRequest request);

	List<SuppliedStockDetails> findSuppliedStockDetailsByStockId(@Min(1) long stockId)
			throws SuppliedStockNotFoundException;

	List<SuppliedStockDetails> findSuppliedStockBySupplierId(Long supplierId, String startDateText, String endDateText);

}
