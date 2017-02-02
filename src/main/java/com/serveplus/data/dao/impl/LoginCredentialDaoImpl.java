package com.serveplus.data.dao.impl;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.LoginCredentialDao;
import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.entity.LoginCredentials;

@Component
public class LoginCredentialDaoImpl extends BaseDataService<LoginCredentials> implements LoginCredentialDao{

	@Override
	public LoginCredentials getLoginCredentials(String userName, String password) {
		String hql = "from LoginCredentials loginCredentials where userName=:userName and password =:password";
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("userName", userName);
		parameterMap.add("password", password);
		LoginCredentials result = getOneResult(hql, parameterMap);
		return result;
	}

}
