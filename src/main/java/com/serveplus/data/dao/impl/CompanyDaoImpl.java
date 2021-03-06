package com.serveplus.data.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.CompanyDao;
import com.serveplus.data.dao.UserDao;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.User;

@Component
public class CompanyDaoImpl extends BaseDataService<Company> implements CompanyDao {
	
	

	

	@Override
	public List<Company> getAllCompanies() {
		String hql = " FROM Company ";
		Session session = getSession();
		List results = session
				.createQuery(hql).list();
		return results;
	}
 
	

	
	


}
