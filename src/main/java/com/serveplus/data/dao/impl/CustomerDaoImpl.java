package com.serveplus.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.CustomerDao;
import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.entity.CsAssigner;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.User;

@Component
public class CustomerDaoImpl extends BaseDataService<Customer> implements CustomerDao{

	@Override
	public Customer findByUser(User user) {
		String hql = "from Customer where user=:user ";
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("user", user);
		Customer result = getOneResult(hql, parameterMap);
		return result;
		
	}
 
}
