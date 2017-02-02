package com.serveplus.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.LoginCredentialDao;
import com.serveplus.data.dao.LoginSessionDao;
import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.data.entity.LoginSession;
import com.serveplus.service.AuthService;
import com.serveplus.web.request.auth.LoginRequest;
import com.serveplus.web.request.auth.mapper.LoginSessionMapper;
import com.serveplus.web.request.auth.mapper.LoginSessionMapper2;
import com.serveplus.web.response.auth.LoginResponse;

@Component
public class AuthServiceImpl implements AuthService{

	@Autowired
	LoginCredentialDao loginCredentialDao;
	
	@Autowired
	LoginSessionDao loginSessionDao;
	
	@Override
	public LoginResponse login(LoginRequest request) {
		LoginCredentials credentials = loginCredentialDao.getLoginCredentials(request.getUserName(), request.getPassword());
		if(credentials!=null){
			LoginSession loginSession = credentials.getLoginSession(request.getChannel());
			if(loginSession == null){
				loginSession = new LoginSessionMapper().mapFrom(credentials);
			}else
				loginSession = new LoginSessionMapper2().mapFrom(loginSession);
			loginSessionDao.save(loginSession);
		}
		return null;
	}

}
