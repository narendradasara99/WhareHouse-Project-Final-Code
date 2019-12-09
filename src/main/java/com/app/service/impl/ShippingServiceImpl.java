package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShippingDao;
import com.app.model.Shipping;
import com.app.model.ShippingDtl;
import com.app.service.IShippingService;

@Service
public class ShippingServiceImpl implements IShippingService {
	@Autowired(required = true)
	private IShippingDao dao;

	@Override
	@Transactional
	public Integer saveShipping(Shipping shipping) {

		return dao.saveShipping(shipping);
	}

	@Override
	@Transactional
	public void updateShipping(Shipping shipping) {
		dao.updateShipping(shipping);



	}

	@Override
	@Transactional
	public void deleteShipping(Integer id) {
		dao.deleteShipping(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Shipping getOneShipping(Integer id) {

		return dao.getOneShipping(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Shipping> getAllShippings() {

		return dao.getAllShippings();
	}

	@Override
	@Transactional
	public Integer saveShippingDtl(ShippingDtl dtl) {
		// TODO Auto-generated method stub
		return dao.saveShippingDtl(dtl);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShippingDtl> getShippingDtlByShippingId(Integer id) {
		// TODO Auto-generated method stub
		return dao.getShippingDtlByShippingId(id);
	}

}
