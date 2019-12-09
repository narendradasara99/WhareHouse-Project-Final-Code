package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.ISaleDtlDao;
import com.app.model.SaleDtl;
import com.app.service.ISaleDtlService;
public class SaleDtlServiceImpl implements ISaleDtlService{
	@Autowired
	private ISaleDtlDao dao;


	@Override
	public Integer saveSaleDtl(SaleDtl saleDtl) {
		// TODO Auto-generated method stub
		return dao.saveSaleDtl(saleDtl);
	}






	
}
