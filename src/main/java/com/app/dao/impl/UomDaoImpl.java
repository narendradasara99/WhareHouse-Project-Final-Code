package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {
	@Autowired
	private HibernateTemplate ht;


	@Override
	public Integer saveUom(Uom u) {
		return (Integer)ht.save(u);
	}

	@Override
	public void updateUom(Uom u) {

		ht.update(u);


	}

	@Override
	public void deleteUom(Integer id) {

		Uom u=new Uom(id);

		ht.delete(u);



	}

	@Override
	public Uom getOneUom(Integer id) {

		Uom u=ht.get(Uom.class,id);
		return u;
	}

	@Override
	public List<Uom> getAllUom() {

		List<Uom> list=ht.loadAll(Uom.class);
		return list;
	}
	
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Object[]> getUomTypeAndCount(){
		
		String hql=" select uomType,count(uomType) from com.app.model.Uom group by uomType ";	
		
		/*
		 * DetachedCriteria dc=DetachedCriteria.forClass(Uom.class)
		 * .setProjection(Projections.projectionList()
		 * .add(Projections.groupProperty("uomType"))
		 * .add(Projections.count("uomType"))); return
		 * (List<Object[]>)ht.findByCriteria(dc);
		 */
		return (List<Object[]>)ht.find(hql);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getUomIdAndModels() {
		/*
		 * String hql=" select id, uomModel " + " from com.app.model.Uom "; return
		 * (List<Object[]>) ht.find(hql);
		 * 
		 */
		
		DetachedCriteria dc=DetachedCriteria.forClass(Uom.class)
				.setProjection(Projections.projectionList()
				.add(Projections.property("id"))
				.add(Projections.property("uomModel"))		
				);
		return (List<Object[]>)ht.findByCriteria(dc);
	}

}
