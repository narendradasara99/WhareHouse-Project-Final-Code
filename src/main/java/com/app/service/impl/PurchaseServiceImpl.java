package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseDao;
import com.app.model.Purchase;
import com.app.model.PurchaseDtl;
import com.app.service.IPurchaseService;

@Service
public class PurchaseServiceImpl implements IPurchaseService {
	@Autowired
private  IPurchaseDao dao;
	@Override
	@Transactional
	public Integer savePurchase(Purchase purchase) {
		
		return (Integer)dao.savePurchase(purchase);
	}

	@Override
	@Transactional
	public void updatePurchse(Purchase purchase) {
		dao.updatePurchse(purchase);

	}

	@Override
	@Transactional
	public void deletePurchse(Integer id) {
		dao.deletePurchse(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Purchase getOnePurchase(Integer id) {
		
		return dao.getOnePurchase(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Purchase> getAllPurchases() {
		
		return dao.getAllPurchases();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getPurchaseQualityCheckAndCount() {
		
		return dao. getPurchaseQualityCheckAndCount();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getPartAndCodes() {
		
		return dao.getPartAndCodes();
	}

	@Override
	@Transactional
	public Integer savePurchaseDtl(PurchaseDtl purchaseDtl) {
		// TODO Auto-generated method stub
		return dao.savePurchaseDtl(purchaseDtl);
	}

	@Override
	@Transactional
	public void deletePurchaseDtl(Integer id) {
		dao.deletePurchaseDtl(id);
		
	}
	
	@Transactional(readOnly=true)
	public List<Object[]> getPurchaseIdAndCode() {
		return dao.getPurchaseIdAndCode();
	}
	@Override
	@Transactional
	public void updateStatusById(Integer id, String defectStatus) {
		// TODO Auto-generated method stub
		dao.updateStatusById(id, defectStatus);
		
			
		}
	}


