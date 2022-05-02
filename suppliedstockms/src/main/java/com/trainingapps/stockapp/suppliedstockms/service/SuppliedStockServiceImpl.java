package com.trainingapps.stockapp.suppliedstockms.service;

import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingapps.stockapp.suppliedstockms.dto.AddSupplyStockRequest;
import com.trainingapps.stockapp.suppliedstockms.dto.SuppliedStockDetails;
import com.trainingapps.stockapp.suppliedstockms.entity.SuppliedStock;
import com.trainingapps.stockapp.suppliedstockms.exception.SuppliedStockNotFoundException;
import com.trainingapps.stockapp.suppliedstockms.repository.ISuppliedStockRepository;
import com.trainingapps.stockapp.suppliedstockms.util.DateUtil;
import com.trainingapps.stockapp.suppliedstockms.util.SuppliedStockUtil;

/**
 * @author DELL implementing the service interface
 *
 */
@Transactional
@Service
public class SuppliedStockServiceImpl implements ISuppliedStockService {

	@Autowired
	private SuppliedStockUtil suppliedStockutil;
	@Autowired
	private DateUtil dateUtil;
	@Autowired
	private ISuppliedStockRepository repository;

	@Override
	public SuppliedStockDetails add(AddSupplyStockRequest request) {

		SuppliedStock suppliedStock = newSuppliedStock();
		suppliedStock.setStockId(request.getStockId());
		suppliedStock.setSupplierId(request.getSupplierId());
		LocalDate date = dateUtil.convertToDate(request.getSuppliedDate());
		suppliedStock.setSuppliedDate(date);
		suppliedStock.setSuppliedCost(request.getSuppliedCost());
		suppliedStock.setUnits(request.getUnits());
		suppliedStock = repository.save(suppliedStock);
		SuppliedStockDetails details = suppliedStockutil.toSuppliedStockDetails(suppliedStock);
		return details;
	}

// created for unit testing to add the supplied stock details
	public SuppliedStock newSuppliedStock() {

		return new SuppliedStock();
	}

// find supplied stock details by stockId method and returning in the form of List
	@Override
	public List<SuppliedStockDetails> findSuppliedStockDetailsByStockId(long stockId)
			throws SuppliedStockNotFoundException {
		List<SuppliedStock> list = repository.findByStockId(stockId);
		if (list.isEmpty()) {
			throw new SuppliedStockNotFoundException("Stock Not found");
		}
		List<SuppliedStockDetails> desired = suppliedStockutil.toListSuppliedStockDetails(list);
		return desired;

	}

// find supplied stock details by supplierId in given time frame method and returning in the form of List
	@Override
	public List<SuppliedStockDetails> findSuppliedStockBySupplierId(Long supplierId, String startDateText,
			String endDateText) {
		LocalDate startDate = dateUtil.convertToDate(startDateText);
		LocalDate endDate = dateUtil.convertToDate(endDateText);
		return findSuppliedStockBySupplierId(supplierId, startDate, endDate);
	}

// for converting date text to local date format
	public List<SuppliedStockDetails> findSuppliedStockBySupplierId(Long supplierId, LocalDate startDate,
			LocalDate endDate) {
		List<SuppliedStock> list = repository.findBySupplierIdInPeriod(supplierId, startDate, endDate);
		List<SuppliedStockDetails> desired = suppliedStockutil.toListSuppliedStockDetails(list);
		return desired;
	}

}
