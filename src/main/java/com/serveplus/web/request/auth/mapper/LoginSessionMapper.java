package com.serveplus.web.request.auth.mapper;

import java.util.Date;

import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.data.entity.LoginSession;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.worker.ServePlusUtil;

public class LoginSessionMapper implements Mapper<LoginCredentials,LoginSession>{

	@Override
	public LoginSession mapFrom(LoginCredentials source) {
		LoginSession loginSession = new LoginSession();
		loginSession.setLoginCredentials(source);
		String token = ServePlusUtil.generateToken();
		loginSession.setToken(token);
		Date date = new Date();
		loginSession.setLastActiveTime(date);
		loginSession.setLastLoginTime(date);
		return loginSession;
	}

}
