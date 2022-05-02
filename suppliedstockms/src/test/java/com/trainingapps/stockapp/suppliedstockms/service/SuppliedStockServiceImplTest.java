package com.trainingapps.stockapp.suppliedstockms.service;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trainingapps.stockapp.suppliedstockms.dto.AddSupplyStockRequest;
import com.trainingapps.stockapp.suppliedstockms.dto.SuppliedStockDetails;
import com.trainingapps.stockapp.suppliedstockms.entity.SuppliedStock;
import com.trainingapps.stockapp.suppliedstockms.exception.SuppliedStockNotFoundException;
import com.trainingapps.stockapp.suppliedstockms.repository.ISuppliedStockRepository;
import com.trainingapps.stockapp.suppliedstockms.util.DateUtil;
import com.trainingapps.stockapp.suppliedstockms.util.SuppliedStockUtil;

@ExtendWith(MockitoExtension.class)
public class SuppliedStockServiceImplTest {
	@Mock
	ISuppliedStockRepository repository;

	@Mock
	SuppliedStockUtil suppliedStoclUtil;
	@InjectMocks
	@Spy
	SuppliedStockServiceImpl service;
	@Mock
	DateUtil dateUtil;

/**
 * @author DELL
 * scenerio  => when details is in database
 *
 */
	@Test
	public void test1_findSuppliedStockDetailsByStockId() {
		long id = 3L;
		System.out.println("inside test case");
		List<SuppliedStock> list = mock(List.class);

		List<SuppliedStock> list2 = new ArrayList<>();
		when(repository.findByStockId(id)).thenReturn(list2);

		Executable executable = () -> service.findSuppliedStockDetailsByStockId(id);
		Assertions.assertThrows(SuppliedStockNotFoundException.class, executable);

	}

/**
 * @author DELL
 * adding suppliedStockdetails test scenerio
 *
 */

	@Test
	public void test_add() {
		long stockId = (long) 2;
		long supplierId = (long) 3;
		String date = "04-04-2022";
		double cost = 45000.0;
		int unit = 5;
		AddSupplyStockRequest addSupply = new AddSupplyStockRequest();
		addSupply.setStockId(stockId);
		addSupply.setSupplierId(supplierId);
		addSupply.setSuppliedDate(date);
		addSupply.setSuppliedCost(cost);
		addSupply.setUnits(unit);

		SuppliedStockDetails details = mock(SuppliedStockDetails.class);
		SuppliedStock stock = mock(SuppliedStock.class);
		LocalDate localdate = LocalDate.of(2022, 04, 04);
		doReturn(stock).when(service).newSuppliedStock();
		when(dateUtil.convertToDate(date)).thenReturn(localdate);
		when(repository.save(stock)).thenReturn(stock);
		when(suppliedStoclUtil.toSuppliedStockDetails(stock)).thenReturn(details);

		SuppliedStockDetails result = service.add(addSupply);
		Assertions.assertSame(details, result);

	}
}
