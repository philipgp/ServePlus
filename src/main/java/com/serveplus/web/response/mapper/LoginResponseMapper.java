package com.serveplus.web.response.mapper;

import com.serveplus.data.entity.LoginSession;
import com.serveplus.web.response.auth.LoginResponse;

public class LoginResponseMapper implements Mapper<LoginSession,LoginResponse>{

	@Override
	public LoginResponse mapFrom(LoginSession source) {
		LoginResponse loginResponse = new LoginResponse();
		if(source!=null){
			loginResponse.setStatus(Boolean.TRUE);
			loginResponse.setToken(source.getToken());
		}else
			loginResponse.setStatus(Boolean.FALSE);
		return loginResponse;
	}

}
