package com.serveplus.data.dao.impl;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.AssignerDao;
import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.User;

@Component
public class AssignerDaoImpl extends BaseDataService<Assigner> implements
		AssignerDao {

	@Override
	public Assigner findByUser(User user) {
		String hql = "from Assigner where user=:user ";
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("user", user);
		Assigner result = getOneResult(hql, parameterMap);
		return result;
	}

}
