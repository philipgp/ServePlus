package com.serveplus.data.dao.impl;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.LoginSessionDao;
import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.entity.LoginSession;

@Component
public class LoginSessionDaoImpl extends BaseDataService<LoginSession> implements LoginSessionDao{

	@Override
	public LoginSession getLoginSessionByToken(String token) {
		String hql = "from LoginSession where token=:token";
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("token", token);
		LoginSession loginSession = getOneResult(hql, parameterMap);
		return loginSession;
	}

}
