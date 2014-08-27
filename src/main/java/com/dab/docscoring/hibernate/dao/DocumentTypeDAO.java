package com.dab.docscoring.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dab.docscoring.hibernate.model.DocumentType;

@Repository
@SuppressWarnings("unchecked")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class DocumentTypeDAO{
	
	@Autowired 
	protected SessionFactory sessionFactory;
	
	@Transactional
	public List<DocumentType> findAll() {
	Session session = sessionFactory.getCurrentSession();
	List<DocumentType> docs = session.getNamedQuery("findAll").list();
    return docs;
  }
}