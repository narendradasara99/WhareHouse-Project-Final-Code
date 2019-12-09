package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPartDao;
import com.app.model.Part;
import com.app.service.IPartService;

@Service
public class PartServiceImpl implements IPartService {
	@Autowired
	private IPartDao dao;

	@Override
	@Transactional
	public Integer savePart(Part part) {
		return  dao.savePart(part);
	}

	@Override
	@Transactional
	public void updatepart(Part part) {
		dao.updatepart(part);

	}

	@Override
	@Transactional
	public void deletePart(Integer id) {
		dao.deletePart(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Part getOnePart(Integer id) {
		return dao.getOnePart(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Part> getAllParts() {	
		return dao.getAllParts();
	}

	@Transactional(readOnly = true)
	public List<Object[]> getPartBaseCurrencyAndCount() {
		return dao.getPartBaseCurrencyAndCount();
	}
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getPartIdAndCodes() {
	
		return dao.getPartIdAndCodes();
	}

	
	}

