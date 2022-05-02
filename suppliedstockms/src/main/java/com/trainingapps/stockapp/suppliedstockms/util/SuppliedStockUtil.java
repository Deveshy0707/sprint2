package com.trainingapps.stockapp.suppliedstockms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trainingapps.stockapp.suppliedstockms.dto.SuppliedStockDetails;
import com.trainingapps.stockapp.suppliedstockms.entity.SuppliedStock;

@Component
public class SuppliedStockUtil {
	@Autowired
	DateUtil dateUtil;

	public SuppliedStockDetails toSuppliedStockDetails(SuppliedStock suppliedStock) {
		SuppliedStockDetails details = new SuppliedStockDetails();
		details.setId(suppliedStock.getId());
		details.setStockId(suppliedStock.getStockId());
		details.setSupplierId(suppliedStock.getSupplierId());
		details.setSuppliedCost(suppliedStock.getSuppliedCost());

		String dateText = dateUtil.convertToText(suppliedStock.getSuppliedDate());
		details.setSuppliedDate(dateText);
		details.setUnits(suppliedStock.getUnits());
		return details;
	}

	public List<SuppliedStockDetails> toListSuppliedStockDetails(List<SuppliedStock> list) {
		List<SuppliedStockDetails> desired = new ArrayList<>();
		for (SuppliedStock stock : list) {
			SuppliedStockDetails response = toSuppliedStockDetails(stock);
			desired.add(response);
		}
		return desired;
	}
}
