package com.trainingapps.stockapp.stockms.service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trainingapps.stockapp.stockms.dto.AddStockRequest;
import com.trainingapps.stockapp.stockms.dto.DecreaseQuantityRequest;
import com.trainingapps.stockapp.stockms.dto.IncreaseQuantityRequest;
import com.trainingapps.stockapp.stockms.dto.StockDetails;
import com.trainingapps.stockapp.stockms.entity.Stock;
import com.trainingapps.stockapp.stockms.exceptions.InvalidUnitsException;
import com.trainingapps.stockapp.stockms.exceptions.NotEnoughUnitsException;
import com.trainingapps.stockapp.stockms.exceptions.StockNotFoundException;
import com.trainingapps.stockapp.stockms.repository.IStockRepository;
import com.trainingapps.stockapp.stockms.util.StockUtil;

/*
 * Service class contains methods: add stock,
 *Find stock details by Id,
 *Increase the units ,
 * Decrease the units from old one
 */
@Transactional
@Service
public class StockServiceImpl implements IStockService {
	@Autowired
	private IStockRepository repository;

	@Autowired
	private StockUtil stockUtil;

	@Override
	public StockDetails addStock(@Valid AddStockRequest request) throws InvalidUnitsException {
		Stock stock = new Stock();
		stock.setStockName(request.getStockName());
		stock.setUnits(request.getUnits());
		stock.setPrice(request.getPrice());
		stock = repository.save(stock);

		return stockUtil.toStockDetails(stock);

	}

	@Override
	public StockDetails findStockDetailsById(@Min(1) Long id) throws StockNotFoundException {
		Stock stock = findById(id);
		return stockUtil.toStockDetails(stock);

	}

	@Override
	public Stock findById(@Min(1) Long id) throws StockNotFoundException {
		Optional<Stock> optional = repository.findById(id);
		if (!optional.isPresent()) {
			throw new StockNotFoundException("stock not found for id=" + id);
		}
		Stock stock = optional.get();
		return (stock);

	}

	@Override
	public StockDetails increaseQuantity(@Valid IncreaseQuantityRequest request)
			throws InvalidUnitsException, StockNotFoundException {
		Stock stock = findById(request.getId());
		int oldUnits = stock.getUnits();
		stock.setUnits(oldUnits + request.getNewUnits());
		return stockUtil.toStockDetails(stock);

	}

	@Override
		public StockDetails decreaseQuantity(@Valid DecreaseQuantityRequest request) throws InvalidUnitsException , StockNotFoundException,NotEnoughUnitsException{
			Stock stock=findById(request.getId());
			int  oldUnits=stock.getUnits();
			int requestedUnits=request.getUnits();
			if(oldUnits<requestedUnits) {
				throw new NotEnoughUnitsException("Not Enough Units");
			}
			stock.setUnits(oldUnits - requestedUnits);	
			return stockUtil.toStockDetails(stock);
			
		}

}
