package com.dab.docscoring.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dab.docscoring.hibernate.model.Company;

@Repository
@SuppressWarnings("unchecked")
public class CompanyDAO{
	
	@Autowired 
	protected SessionFactory sessionFactory;
	
	@Transactional
	public List<Company> findAll() {
	Session session = sessionFactory.getCurrentSession();
	List<Company> companies = session.getNamedQuery("Company.findAll").list();
    return companies;
  }
}