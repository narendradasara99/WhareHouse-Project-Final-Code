package com.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ISaleDtlDao;
import com.app.model.SaleDtl;
@Repository
public class SaleDtlDaoImpl implements ISaleDtlDao {
	@Autowired
	private HibernateTemplate ht;

	
	@Override
	public Integer saveSaleDtl(SaleDtl saleDtl) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(saleDtl);
	}

}
