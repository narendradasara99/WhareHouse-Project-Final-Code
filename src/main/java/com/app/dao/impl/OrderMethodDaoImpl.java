package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
	@Autowired
	private HibernateTemplate ht;


	@Override
	public Integer saveOrderMethod(OrderMethod o) {
		return (Integer)ht.save(o);
	}

	@Override
	public void updateOrderMethod(OrderMethod o) {

		ht.update(o);


	}

	@Override
	public void deleteOrderMethod(Integer id) {

		OrderMethod o =new OrderMethod(id);

		ht.delete(o);



	}

	@Override
	public OrderMethod getOneOrderMethod(Integer id) {

		OrderMethod o=ht.get(OrderMethod.class,id);
		return o;
	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {

		List<OrderMethod> list=ht.loadAll(OrderMethod.class);
		return list;
	}
	
	 @SuppressWarnings({ "unchecked", "deprecation" })
	public List<Object[]> getOrderModeTypeAndCount(){
		// String hql=" select orderMode,count(orderMode) from com.app.model.OrderMethod group by orderMode ";
		DetachedCriteria dc=DetachedCriteria.forClass(OrderMethod.class)
				.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("orderMode"))
				.add(Projections.count("orderMode"))
				);
			
			
			//return (List<Object[]>)ht.find(hql);
		return (List<Object[]>) ht.findByCriteria(dc);
			
		
		 
	 }

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getOrderMethodIdAndOrderCodes(String mode) {
		/*
		 * String hql=" select id, orderCode " + " from com.app.model.OrderMethod " +
		 * " where orderMode=?0 "; return (List<Object[]>) ht.find(hql,mode);
		 */
		
		DetachedCriteria dc=DetachedCriteria.forClass(OrderMethod.class)
				.setProjection(Projections.projectionList()
				.add(Projections.property("id"))	
				.add(Projections.property("orderCode"))
				)
				
				.add(Restrictions.eq("orderMode",mode));
			
			return (List<Object[]>)ht.findByCriteria(dc);
	}

	
	/*@Override
	public List<Object[]> getOrderMethodIdAndOrderCode() {
		
		  String hql=" select id, orderCode " + " from com.app.model.OrderMethod ";
		  return (List<Object[]>) ht.find(hql);*/
		 
		/*DetachedCriteria dc=DetachedCriteria.forClass(OrderMethod.class)
				.setProjection(Projections.projectionList()
				.add(Projections.property("id"))	
				.add(Projections.property("orderCode")));
			return (List<Object[]>)ht.findByCriteria(dc);
	}*/

}

