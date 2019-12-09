package com.app.service;

import java.util.List;

import com.app.model.Sale;
import com.app.model.SaleDtl;

public interface ISaleService {
	public Integer saveSale(Sale sale);
	public void updateSale(Sale id);
	public void deleteSale(Integer id);
	public Sale getOneSale(Integer id);
	public List<Sale> getAllSales();
	public List<Object[]> getStockModeAndCount();
	public List<Object[]> getSaleIdAndOrderCodes();
	
	
	public List<Object[]> getPartIdAndCodes();
	
	public Integer saveSaleDtl(SaleDtl saleDtl);
	public void deleteSaleDtl(Integer id);
	
	public void updateStatusById(Integer id, String saleOrderStatus);

}