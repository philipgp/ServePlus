package com.serveplus.data.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.UserDao;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.User;

@Component
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 
	@Override
	public List<User> getAllUsers() {
		
		String hql = " FROM User ";
		Session session = sessionFactory.openSession();
		List results = session
				.createQuery(hql).list();
		return results;
				
	}

	
	@Override
	public void save(User user) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		 session.save(user);
		 tx.commit();
		
	}

	@Override
	public void saveOrUpdate(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		 session.saveOrUpdate(user);
		 tx.commit();
		
	}


}
