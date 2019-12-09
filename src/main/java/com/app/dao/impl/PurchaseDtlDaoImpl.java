package com.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseDtlDao;
import com.app.model.PurchaseDtl;
@Repository
public class PurchaseDtlDaoImpl implements IPurchaseDtlDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePurchaseDtl(PurchaseDtl purchaseDtl) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(purchaseDtl);
	}

}
