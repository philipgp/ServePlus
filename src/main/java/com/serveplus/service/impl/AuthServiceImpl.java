package com.serveplus.service.impl;

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.LoginCredentialDao;
import com.serveplus.data.dao.LoginSessionDao;
import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.data.entity.LoginSession;
import com.serveplus.service.AuthService;
import com.serveplus.web.request.auth.ChangePasswordRequest;
import com.serveplus.web.request.auth.ForgetPasswordRequest;
import com.serveplus.web.request.auth.LoginRequest;
import com.serveplus.web.request.auth.LogoutRequest;
import com.serveplus.web.request.auth.mapper.LoginSessionMapper;
import com.serveplus.web.request.auth.mapper.LoginSessionMapper2;
import com.serveplus.web.response.auth.ChangePasswordResponse;
import com.serveplus.web.response.auth.ForgetPasswordResponse;
import com.serveplus.web.response.auth.LoginResponse;
import com.serveplus.web.response.auth.LogoutResponse;
import com.serveplus.web.response.auth.mapper.ChangePasswordResponseMapper;
import com.serveplus.web.response.auth.mapper.LogoutResponseMapper;
import com.serveplus.web.response.mapper.LoginResponseMapper;
import com.serveplus.web.response.worker.ServePlusUtil;

@Component
public class AuthServiceImpl implements AuthService{

	@Autowired
	LoginCredentialDao loginCredentialDao;
	
	@Autowired
	LoginSessionDao loginSessionDao;
	
	@Override
	public LoginResponse login(LoginRequest request) {
		LoginCredentials credentials = loginCredentialDao.getLoginCredentials(request.getUserName(), request.getPassword());
		LoginSession loginSession = null;
		if(credentials!=null){
			 loginSession = credentials.getLoginSession(request.getChannel());
			if(loginSession == null){
				
				String token = null;
				do{
					token = ServePlusUtil.generateToken();
				}while(loginSessionDao.getLoginSessionByToken(token)!=null);
				loginSession = new LoginSessionMapper(request).mapFrom(credentials);
				loginSession.setToken(token);
			}else
				loginSession = new LoginSessionMapper2().mapFrom(loginSession);
			loginSessionDao.save(loginSession);
			 
		}
		LoginResponseMapper responseMapper = new LoginResponseMapper();
		LoginResponse response = responseMapper.mapFrom(loginSession);
		return response;
	}

	@Override
	public LogoutResponse logout(LogoutRequest request) {
		LoginSession loginSession = loginSessionDao.getLoginSessionByToken(request.getToken());
		if(loginSession !=null){
			loginSessionDao.remove(loginSession);
		}
		LogoutResponseMapper responseMapper = new LogoutResponseMapper();
		LogoutResponse response = responseMapper.mapFrom(loginSession);
		return response;
	}

	@Override
	public ChangePasswordResponse changePassword(ChangePasswordRequest request) {
		LoginCredentials loginCredentials = loginCredentialDao.getLoginCredentials(request.getUserName());
		//LoginSession loginSession = loginSessionDao.getLoginSessionByToken(request.getToken());
		Boolean status = Boolean.FALSE;
		
			/*LoginCredentials loginCredentials = loginSession.getLoginCredentials();*/
			if(loginCredentials!=null && loginCredentials.getWrongPasswordTry()<3){
				if(StringUtils.equalsIgnoreCase(loginCredentials.getPassword(), request.getOldPassword())){
					loginCredentials.setPassword(request.getNewPassword());
					loginCredentials.setWrongPasswordTry(0);
					loginCredentialDao.save(loginCredentials);
					status = Boolean.TRUE;
					Set<LoginSession> loginSessions = loginCredentials.getLoginSessions();
					loginSessionDao.removeAll(loginSessions);
				}else{
					Integer wrongPasswordTry = loginCredentials.getWrongPasswordTry();
					/*if(wrongPasswordTry>=3){
						//loginCredentials.setAccountLocked(Boolean.TRUE);
						//loginCredentialDao.save(loginCredentials);
						Set<LoginSession> loginSessions = loginCredentials.getLoginSessions();
						loginSessionDao.removeAll(loginSessions);
						
					}else{*/
						wrongPasswordTry++;
						loginCredentials.setWrongPasswordTry(wrongPasswordTry);
						loginCredentialDao.save(loginCredentials);
						if(wrongPasswordTry>=3){
							Set<LoginSession> loginSessions = loginCredentials.getLoginSessions();
							loginSessionDao.removeAll(loginSessions);
						}
					/*}*/
					
					status = Boolean.FALSE;
				}
			}
		
		ChangePasswordResponseMapper responseMapper = new ChangePasswordResponseMapper();
		ChangePasswordResponse response = responseMapper.mapFrom(status);
		return response;
	}

	@Override
	public ForgetPasswordResponse forgotPassword(ForgetPasswordRequest request) {
		
		return null;
	}

}
