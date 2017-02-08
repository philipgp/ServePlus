package com.serveplus.data.dao.impl;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.AdminDao;
import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.entity.Admin;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.User;

@Component
public class AdminDaoImpl extends BaseDataService<Admin> implements AdminDao{

	@Override
	public Admin findByUser(User user) {
		String hql = "from Admin where user=:user ";
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("user", user);
		Admin result = getOneResult(hql, parameterMap);
		return result;
	}

}
