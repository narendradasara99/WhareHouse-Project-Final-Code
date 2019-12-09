package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ISaleDao;
import com.app.model.Sale;
import com.app.model.SaleDtl;
import com.app.service.ISaleService;
@Service
public class SaleServiceImpl implements ISaleService {
	@Autowired
	private ISaleDao dao;


	@Override
	@Transactional
	public Integer saveSale(Sale sale) {

		return dao.saveSale(sale);
	}

	@Override
	@Transactional
	public void updateSale(Sale id) {
		dao.updateSale(id);


	}

	@Override
	@Transactional
	public void deleteSale(Integer id) {
		dao.deleteSale(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Sale getOneSale(Integer id) {

		return dao.getOneSale(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sale> getAllSales() {

		return dao.getAllSales();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getStockModeAndCount() {
		
		return dao.getStockModeAndCount();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getSaleIdAndOrderCodes() {
		
		return dao.getSaleIdAndOrderCodes();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getPartIdAndCodes() {
		
		return dao.getPartIdAndCodes();
	}

	@Override
	@Transactional
	public Integer saveSaleDtl(SaleDtl saleDtl) {
		
		return dao.saveSaleDtl(saleDtl);
	}
	@Override
	@Transactional
	public void deleteSaleDtl(Integer id) {
		dao.deleteSaleDtl(id);
		
	}
	@Override
	@Transactional
	public void updateStatusById(Integer id, String saleOrderStatus) {
		// TODO Auto-generated method stub
		dao.updateStatusById(id, saleOrderStatus);
		
	}

}
