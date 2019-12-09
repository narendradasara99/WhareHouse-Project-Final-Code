package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;


@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;


	@Override
	public Integer saveShipmentType(ShipmentType s) {
		return (Integer)ht.save(s);
	}

	@Override
	public void updateShipmentType(ShipmentType s) {

		ht.update(s);


	}

	@Override
	public void deleteShipmentType(Integer id) {

		ShipmentType s=new ShipmentType(id);

		ht.delete(s);



	}

	@Override
	public ShipmentType getOneShipmentType(Integer id) {

		ShipmentType s=ht.get(ShipmentType.class,id);
		return s;
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {

		List<ShipmentType> list=ht.loadAll(ShipmentType.class);
		return list;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Object[]> getShipmentTypeModeAndCount(){
			//String hql=" select shipmentTypeMode,count(shipmentTypeMode) from com.app.model.ShipmentType group by shipmentTypeMode ";
			DetachedCriteria dc=DetachedCriteria.forClass(ShipmentType.class)
					.setProjection(Projections.projectionList()
					.add(Projections.groupProperty("shipmentTypeMode"))
					.add(Projections.count("shipmentTypeMode"))
					);		
			return (List<Object[]>)ht.findByCriteria(dc);
			//return (List<Object[]>)ht.find(hql);
			
		}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getShipmentTypeIdAndEnable(String enabled) {
		
		  String hql= " select id, shipmentTypeMode " +
		  " from com.app.model.ShipmentType " + " where enableShipmentType=?0 "; 
		  return (List<Object[]>) ht.find(hql, enabled);
		 
		
		/*
		 * DetachedCriteria dc=DetachedCriteria.forClass(ShipmentType.class)
		 * .setProjection(Projections.projectionList() .add(Projections.property("id"))
		 * .add(Projections.property("shipmentTypeMode")) )
		 * 
		 * .add(Restrictions.eq("orderMode",enabled));
		 * 
		 * return (List<Object[]>)ht.findByCriteria(dc);
		 */
	}


	}


