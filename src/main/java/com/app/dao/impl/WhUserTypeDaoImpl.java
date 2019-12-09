package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {
	@Autowired
	private HibernateTemplate ht;


	@Override
	public Integer saveWhUserType(WhUserType u) {
		return (Integer)ht.save(u);
	}

	@Override
	public void updateWhUserType(WhUserType u) {

		ht.update(u);


	}

	@Override
	public void deleteWhUserType(Integer id) {

		WhUserType u= new WhUserType(id);

		ht.delete(u);



	}

	@Override
	public WhUserType getOneWhUserType(Integer id) {

		WhUserType u=ht.get(WhUserType.class,id);
		return u;
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {

		List<WhUserType> list=ht.loadAll(WhUserType.class);
		return list;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getWhuserTypeAndCount() {
		//String hql=" select whuserType,count(whuserType) from com.app.model.WhUserType group by whuserType ";	
		
		DetachedCriteria dc=DetachedCriteria.forClass(WhUserType.class)
				.setProjection(Projections.projectionList()
				 .add(Projections.groupProperty("whuserType"))
				 .add(Projections.count("whuserType"))
				 );
		return (List<Object[]>)ht.findByCriteria(dc);
		//return (List<Object[]>)ht.find(hql);
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getWhUserTypeIdAndCode(String userType) {
	
		  String hql= " select id, whuserCode " + " from com.app.model.WhUserType " +
		  " where userType=?0 ";
		 
		return  (List<Object[]>) ht.find(hql, userType);
		
		/*
		 * DetachedCriteria dc=DetachedCriteria.forClass(WhUserType.class)
		 * .setProjection(Projections.projectionList() .add(Projections.property("id"))
		 * .add(Projections.property("whuserCode")) )
		 * 
		 * .add(Restrictions.eq("userType",userType));
		 * 
		 * return (List<Object[]>)ht.findByCriteria(dc);
		 */
				
	}
	}


