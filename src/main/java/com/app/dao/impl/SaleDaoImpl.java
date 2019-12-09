package com.app.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ISaleDao;
import com.app.model.Part;
import com.app.model.Sale;
import com.app.model.SaleDtl;
@Repository
public class SaleDaoImpl implements ISaleDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveSale(Sale sale) {

		return (Integer)ht.save(sale);
	}

	@Override
	public void updateSale(Sale id) {
		ht.saveOrUpdate(id);
	}

	@Override
	public void deleteSale(Integer id) {
		Sale s=new Sale(id);
		ht.delete(s);


	}

	@Override
	public Sale getOneSale(Integer id) {
		Sale s=ht.get(Sale.class, id);

		return s;
	}

	@Override
	public List<Sale> getAllSales() {
		List<Sale> list=ht.loadAll(Sale.class);

		return list;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getStockModeAndCount() {
		/*
		 * String hql=" select id, stockMode " + " from com.app.model.Sale "; return
		 * (List<Object[]>) ht.find(hql);
		 */
		
		DetachedCriteria dc=DetachedCriteria.forClass(Sale.class)
				.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("stockMode"))	
				.add(Projections.count("stockMode")));
			return (List<Object[]>)ht.findByCriteria(dc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getSaleIdAndOrderCodes() {
		
		DetachedCriteria dc=DetachedCriteria.forClass(Sale.class)
				.setProjection(Projections.projectionList()
				.add(Projections.property("id"))
				.add(Projections.property("orderCode"))		
				);
		return (List<Object[]>)ht.findByCriteria(dc);
	}

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

	@Override
	public Integer saveSaleDtl(SaleDtl saleDtl) {
		// TODO Auto-generated method stub
		return (Integer) ht.save((saleDtl));
	}

	@Override
	public void deleteSaleDtl(Integer id) {
		ht.delete(new SaleDtl(id));
		
	}
	@Override
	public void updateStatusById(Integer id, String saleOrderStatus) {
		// TODO Auto-generated method stub
		
		ht.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				
				String hql= "update com.app.model.Sale p "
						+ " set p.saleOrderStatus=:a "
						+ "where p.id=:b ";
				return session.createQuery(hql).setParameter("a", saleOrderStatus).setParameter("b", id).executeUpdate();
			}
			
		});
	}


}
