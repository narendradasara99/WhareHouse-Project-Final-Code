package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {
	@Autowired
	private IShipmentTypeDao dao;

	@Override
	@Transactional
	public Integer saveShipmentType(ShipmentType s) {

		return dao.saveShipmentType(s);

	}

	@Override
	@Transactional
	public void updateShipmentType(ShipmentType s) {
		dao.updateShipmentType(s);

	}

	@Override
	@Transactional
	public void deleteShipmentType(Integer id) {
		dao.deleteShipmentType(id);

	}

	@Override
	@Transactional(readOnly = true)
	public ShipmentType getOneShipmentType(Integer id) {

		return dao.getOneShipmentType(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShipmentType> getAllShipmentTypes() {

		return dao.getAllShipmentTypes();
	}

	@Transactional(readOnly = true)
	public List<Object[]> getShipmentTypeModeAndCount() {
		return dao.getShipmentTypeModeAndCount();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getShipmentTypeIdAndEnable(String enabled) {
		
		return dao.getShipmentTypeIdAndEnable(enabled);
	}

}
