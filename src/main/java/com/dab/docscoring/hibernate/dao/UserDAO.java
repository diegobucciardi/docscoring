package com.dab.docscoring.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.dab.docscoring.hibernate.model.User;

@Repository
@SuppressWarnings("unchecked")
public class UserDAO extends BasicDAO {

	@Transactional
	public List<User> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.getNamedQuery("User.findAll").list();
		return users;
	}
	
	@Transactional
	public User findByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.getNamedQuery("User.findByName").setParameter("name", name).uniqueResult();
		return user;
	}
}
