package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomDao;
import com.app.model.Uom;
import com.app.service.IUomService;
@Service
public class UomServiceImpl implements IUomService {
	@Autowired
	private  IUomDao dao;

	@Override
	@Transactional
	public Integer saveUom(Uom u) {
		
	return dao.saveUom(u);
	

	}

	@Override
	@Transactional
	public void updateUom(Uom u) {
   dao.updateUom(u);

		
	}

	@Override
	@Transactional
	public void deleteUom(Integer id) {
dao.deleteUom(id);

		
	}

	@Override
	@Transactional(readOnly = true)
	public Uom getOneUom(Integer id) {


		return dao.getOneUom(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Uom> getAllUom() {

  return dao.getAllUom();
	}
	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getUomTypeAndCount() {
		return dao.getUomTypeAndCount();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getUomIdAndModels() {
		
		return dao.getUomIdAndModels();
	}

}
