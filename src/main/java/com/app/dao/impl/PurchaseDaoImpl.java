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
import com.app.dao.IPurchaseDao;
import com.app.model.Part;
import com.app.model.Purchase;
import com.app.model.PurchaseDtl;


@Repository
public class PurchaseDaoImpl implements IPurchaseDao {
	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer savePurchase(Purchase purchase) {

		return (Integer)ht.save(purchase);
	}

	@Override
	public void updatePurchse(Purchase purchase) {
		ht.update(purchase);

	}

	@Override
	public void deletePurchse(Integer id) {
		ht.delete(id);

	}

	@Override
	public Purchase getOnePurchase(Integer id) {
		Purchase p=ht.get(Purchase.class, id);
		return p;
	}

	@Override
	public List<Purchase> getAllPurchases() {


		List<Purchase> list=ht.loadAll(Purchase.class);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getPurchaseQualityCheckAndCount() {
		/*
		 * String hql=" select id, qualityCheck " + " from com.app.model.Purchase ";
		 * return (List<Object[]>) ht.find(hql);
		 * 
		 */
		DetachedCriteria dc=DetachedCriteria.forClass(Purchase.class)
				.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("qualityCheck"))
				.add(Projections.count("qualityCheck"))
						
				);
		return (List<Object[]>)ht.findByCriteria(dc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getPartAndCodes() {
		DetachedCriteria dc=DetachedCriteria.forClass(Part.class)
				.setProjection(Projections.projectionList()
					.add(Projections.property("id"))
					.add(Projections.property("code"))
					);
		 List<Object[]> list= (List<Object[]>) ht.findByCriteria(dc);
		 return list;
	}

	@Override
	public Integer savePurchaseDtl(PurchaseDtl purchaseDtl) {
		
		return (Integer) ht.save(purchaseDtl);
	}

	@Override
	public void deletePurchaseDtl(Integer id) {
		ht.delete(new PurchaseDtl(id));
		
		
	}
	
	
	/***child methods end*/
	@Override
	public List<Object[]> getPurchaseIdAndCode() {
		
		DetachedCriteria dc=DetachedCriteria.forClass(Purchase.class)
				.setProjection(
						Projections.projectionList()
						.add(Projections.property("id"))
						.add(Projections.property("orderCode"))
						);
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(dc);
		
		return list;
	}
	

@Override
public void updateStatusById(Integer id, String defectStatus) {
	
	ht.execute(new HibernateCallback<Integer>() {
		@Override
		public Integer doInHibernate(Session session) throws HibernateException {
			
			String hql= "update com.app.model.Purchase p "
					+ " set p.defectStatus=:a "
					+ "where p.id=:b ";
			return session.createQuery(hql).setParameter("a", defectStatus).setParameter("b", id).executeUpdate();
		}
		
	});
}

}
