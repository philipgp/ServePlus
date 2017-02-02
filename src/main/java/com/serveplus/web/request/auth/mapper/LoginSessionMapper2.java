package com.serveplus.web.request.auth.mapper;

import java.util.Date;

import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.data.entity.LoginSession;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.worker.ServePlusUtil;

public class LoginSessionMapper2 implements Mapper<LoginSession,LoginSession>{

	
	@Override
	public LoginSession mapFrom(LoginSession original) {
		original.setLastLoginTime(new Date());
		original.setLastActiveTime(new Date());
		return original;
	}

}
