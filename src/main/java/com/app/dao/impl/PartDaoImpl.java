package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPartDao;
import com.app.model.Part;

@Repository
public class PartDaoImpl implements IPartDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePart(Part part) {
		
		return (Integer)ht.save(part);
	}

	@Override
	public void updatepart(Part part) {
		ht.update(part);

	}

	@Override
	public void deletePart(Integer id) {
		ht.delete(id);

	}

	@Override
	public Part getOnePart(Integer id) {
		Part p=ht.get(Part.class,id);
		return p;
	}

	@Override
	public List<Part> getAllParts() {
		List<Part> list= ht.loadAll(Part.class);
		return list;
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getPartBaseCurrencyAndCount() {
		//String hql=" select baseCurrency,count(baseCurrency) from com.app.model.Part group by baseCurrency ";	
		DetachedCriteria dc=DetachedCriteria.forClass(Part.class)
				.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("baseCurrency"))
				.add(Projections.count("baseCurrency"))
						
				);
		//return (List<Object[]>)ht.find(hql);
		return (List<Object[]>)ht.findByCriteria(dc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getPartIdAndCodes() {
		DetachedCriteria dc=DetachedCriteria.forClass(Part.class)
				.setProjection(Projections.projectionList()
					.add(Projections.property("id"))
					.add(Projections.property("code"))
					);
		 List<Object[]> list= (List<Object[]>) ht.findByCriteria(dc);
		 return list;
	}

	
}
