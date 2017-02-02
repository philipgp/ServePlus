package com.serveplus.web.response.auth.mapper;

import com.serveplus.data.entity.LoginSession;
import com.serveplus.web.response.auth.LogoutResponse;
import com.serveplus.web.response.mapper.Mapper;

public class LogoutResponseMapper implements Mapper<LoginSession,LogoutResponse>{

	@Override
	public LogoutResponse mapFrom(LoginSession source) {
		LogoutResponse logoutResponse = new LogoutResponse();
		if(source!=null)
			logoutResponse.setStatus(Boolean.TRUE);
		else
			logoutResponse.setStatus(Boolean.FALSE);
		return logoutResponse;
	}

}
