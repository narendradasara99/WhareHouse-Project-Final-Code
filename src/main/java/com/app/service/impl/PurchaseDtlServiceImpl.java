package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseDtlDao;
import com.app.model.PurchaseDtl;
import com.app.service.IPurchaseDtlService;
@Service
public class PurchaseDtlServiceImpl implements IPurchaseDtlService {
	@Autowired
	private IPurchaseDtlDao dao;

	@Override
	@Transactional
	public Integer savePurchaseDtl(PurchaseDtl purchaseDtl) {
		// TODO Auto-generated method stub
		return dao.savePurchaseDtl(purchaseDtl);
	}

}
