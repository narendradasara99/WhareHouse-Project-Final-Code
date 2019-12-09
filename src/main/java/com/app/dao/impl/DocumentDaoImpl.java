package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;

@Repository
public   class DocumentDaoImpl implements IDocumentDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveDocument(Document document) {

 return (Integer)ht.save(document);
		
	}
	public Document getOneDocument(Integer id) {
		
		return ht.get(Document.class, id);
		
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getDocumentIdAndName() {
		/*
		 * String hql="select fileId,fileName from com.app.model.Document";
		 * List<Object[]> list=(List<Object[]>)ht.find(hql);
		 * 
		 */
		DetachedCriteria dc=DetachedCriteria.forClass(Document.class)
				.setProjection(
				Projections.projectionList()
				.add(Projections.property("fileId"))
				.add(Projections.property("fileName"))
				);
		return  (List<Object[]>) ht.findByCriteria(dc);
	}

}
