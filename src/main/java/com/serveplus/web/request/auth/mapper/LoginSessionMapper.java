package com.serveplus.web.request.auth.mapper;

import java.util.Date;

import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.data.entity.LoginSession;
import com.serveplus.web.request.auth.LoginRequest;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.worker.ServePlusUtil;

public class LoginSessionMapper implements Mapper<LoginCredentials,LoginSession>{
 private LoginRequest loginRequest;
	public LoginSessionMapper(LoginRequest loginRequest) {
	super();
	this.loginRequest = loginRequest;
}
	@Override
	public LoginSession mapFrom(LoginCredentials source) {
		LoginSession loginSession = new LoginSession();
		loginSession.setLoginCredentials(source);
		
		//loginSession.setToken(token);
		Date date = new Date();
		loginSession.setLastActiveTime(date);
		loginSession.setLastLoginTime(date);
		loginSession.setChannel(loginRequest.getChannel());
		return loginSession;
	}

}
