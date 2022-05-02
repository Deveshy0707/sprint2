package com.trainingapps.stockapp.suppliedstockms.frontend;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.trainingapps.stockapp.suppliedstockms.dto.AddSupplyStockRequest;
import com.trainingapps.stockapp.suppliedstockms.dto.SuppliedStockDetails;
import com.trainingapps.stockapp.suppliedstockms.service.ISuppliedStockService;

/**
 * @author DELL for manual testing runUI method is created and for display the
 *         display method has been created
 *
 */
@Component
public class ManualTesting {

	@Autowired
	private ISuppliedStockService service;

	void runUI() {
		try {
			System.out.println("***adding supplied Stock****");
			AddSupplyStockRequest requestData1 = new AddSupplyStockRequest();

			requestData1.setStockId((long) 7);
			requestData1.setSupplierId((long) 3);
			requestData1.setSuppliedDate("05-04-2022");
			requestData1.setUnits(5);
			requestData1.setSuppliedCost(50000.0);

			SuppliedStockDetails suppliedStock1 = service.add(requestData1);

			AddSupplyStockRequest requestData2 = new AddSupplyStockRequest();

			requestData2.setStockId((long) 3);
			requestData2.setSupplierId((long) 4);
			requestData2.setSuppliedDate("06-04-2022");
			requestData2.setUnits(5);
			requestData2.setSuppliedCost(10000.0);

			SuppliedStockDetails suppliedStock2 = service.add(requestData2);

			AddSupplyStockRequest requestData3 = new AddSupplyStockRequest();

			requestData3.setStockId((long) 2);
			requestData3.setSupplierId((long) 2);
			requestData3.setSuppliedDate("07-04-2022");
			requestData3.setUnits(5);
			requestData3.setSuppliedCost(8000.0);

			SuppliedStockDetails suppliedStock3 = service.add(requestData3);

			System.out.println("***Displaying the record****");
			display(suppliedStock1);
			display(suppliedStock2);
			display(suppliedStock3);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	void display(SuppliedStockDetails supplyStock) {
		System.out.println(supplyStock.getId() + " - " + supplyStock.getStockId() + " - " + supplyStock.getSupplierId()
				+ " - " + supplyStock.getSuppliedDate() + " - " + supplyStock.getUnits() + " - "
				+ supplyStock.getSuppliedCost());
	}
}
