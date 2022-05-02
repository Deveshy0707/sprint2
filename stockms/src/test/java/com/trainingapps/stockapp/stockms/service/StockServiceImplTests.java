package com.trainingapps.stockapp.stockms.service;

import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trainingapps.stockapp.stockms.dto.StockDetails;
import com.trainingapps.stockapp.stockms.entity.Stock;
import com.trainingapps.stockapp.stockms.exceptions.StockNotFoundException;
import com.trainingapps.stockapp.stockms.repository.IStockRepository;
import com.trainingapps.stockapp.stockms.util.StockUtil;

@ExtendWith(MockitoExtension.class)
public class StockServiceImplTests {
	
	@Mock
	IStockRepository repository;

	@Mock
	StockUtil stockUtil;

	@InjectMocks
	@Spy
	StockServiceImpl service;

	/**
	 * scenario: when stock exists in database
	 */
	@Test
	public void test1_findStockDetailsById() throws StockNotFoundException {
		Long id = 1L;
		Stock stock = mock(Stock.class);
		Optional<Stock> optional = Optional.of(stock);
		when(repository.findById(id)).thenReturn(optional);

		StockDetails stockDetails = mock(StockDetails.class);
		when(stockUtil.toStockDetails(stock)).thenReturn(stockDetails);

		StockDetails result = service.findStockDetailsById(id);
		Assertions.assertSame(stockDetails, result);

	}

	/**
	 * scenario: when stock doesn't exist in database
	 */
	@Test
	public void test2_findtockDetailsById() {
		Long id = 1L;
		Optional<Stock> optional = Optional.empty();
		when(repository.findById(id)).thenReturn(optional);

		Executable executable = () -> service.findStockDetailsById(id);
		Assertions.assertThrows(StockNotFoundException.class, executable);

	}

}
