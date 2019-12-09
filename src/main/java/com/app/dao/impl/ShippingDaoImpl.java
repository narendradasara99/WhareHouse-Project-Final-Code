package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShippingDao;
import com.app.model.Shipping;
import com.app.model.ShippingDtl;
@Repository
public class ShippingDaoImpl implements IShippingDao {
	@Autowired(required = true)
	private HibernateTemplate ht;


	@Override
	public Integer saveShipping(Shipping shipping) {
		return (Integer)ht.save(shipping);
	}

	@Override
	public void updateShipping(Shipping shipping) {
		ht.update(shipping);

	}

	@Override
	public void deleteShipping(Integer id) {
		Shipping s=new Shipping(id);
		ht.delete(s);
	}

	@Override
	public Shipping getOneShipping(Integer id) {
	Shipping s=ht.get(Shipping.class, id);
		return s;
	}

	@Override
	public List<Shipping> getAllShippings() {
		List<Shipping> list=ht.loadAll(Shipping.class);
		return list;
		
	}

	@Override
	public Integer saveShippingDtl(ShippingDtl dtl) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(dtl);
	}

	@Override
	public List<ShippingDtl> getShippingDtlByShippingId(Integer id) {
		// TODO Auto-generated method stub
		//select * from shippingdtl where shippingIdFk=?
				DetachedCriteria dc= DetachedCriteria.forClass(ShippingDtl.class)
						.add(Restrictions.eq("parent.id",id));
				
				return (List<ShippingDtl>) ht.findByCriteria(dc);
	}

}
