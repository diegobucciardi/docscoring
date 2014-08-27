package com.dab.docscoring.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BasicDAO {
	
	@Autowired protected SessionFactory sessionFactory;
	
	private Session session;

	public Session getSession() {
		if(session == null){
			sessionFactory.getCurrentSession();
		}
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
}