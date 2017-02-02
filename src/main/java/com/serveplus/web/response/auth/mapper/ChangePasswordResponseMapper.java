package com.serveplus.web.response.auth.mapper;

import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.web.response.auth.ChangePasswordResponse;
import com.serveplus.web.response.mapper.Mapper;

public class ChangePasswordResponseMapper implements Mapper<Boolean,ChangePasswordResponse>{

	@Override
	public ChangePasswordResponse mapFrom(Boolean status) {
		ChangePasswordResponse response = new ChangePasswordResponse();
		response.setStatus(status);
		return response;
	}

}
