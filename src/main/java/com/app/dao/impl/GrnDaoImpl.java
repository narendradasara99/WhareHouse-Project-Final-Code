package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IGrnDao;
import com.app.model.Grn;
import com.app.model.GrnDtl;

@Repository
public class GrnDaoImpl implements IGrnDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveGrn(Grn grn) {
		return (Integer)ht.save(grn);
	}

	@Override
	public void updateGrn(Grn grn) {
		ht.update(grn);
	}

	@Override
	public void deleteGrn(Integer id) {
		ht.delete(new Grn(id));
	}

	@Override
	public Grn getOneGrn(Integer id) {
		return ht.get(Grn.class,id);
	}

	@Override
	public List<Grn> getAllGrns() {
		return ht.loadAll(Grn.class);
	}
	
	@Override
	public List<Object[]> getGrnTypeAndCount() {
		/*String  hql=" select id, grnType "
				+ " from com.app.model.Grn ";
				
			return (List<Object[]>)ht.find(hql);
		*/
		
		DetachedCriteria dc=DetachedCriteria.forClass(Grn.class)
				.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("grnType"))	
				.add(Projections.count("grnType")));
			return (List<Object[]>)ht.findByCriteria(dc);
			
	}
	@Override
	public List<GrnDtl> getGrnDtlByGrnId(Integer id) {
		
		//select * from grndtl where grnIdFk=?
		DetachedCriteria dc= DetachedCriteria.forClass(GrnDtl.class)
				.add(Restrictions.eq("parent.id",id));
		
		return (List<GrnDtl>) ht.findByCriteria(dc);
	}
	
	
	@Override
	public Integer saveGrnDtl(GrnDtl dtl) {
		return (Integer) ht.save(dtl);
	}

}
