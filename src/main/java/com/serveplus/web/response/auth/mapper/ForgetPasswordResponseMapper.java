package com.serveplus.web.response.auth.mapper;

import com.serveplus.web.response.auth.ForgetPasswordResponse;
import com.serveplus.web.response.mapper.Mapper;

public class ForgetPasswordResponseMapper implements Mapper<Boolean,ForgetPasswordResponse>{

	@Override
	public ForgetPasswordResponse mapFrom(Boolean source) {
		ForgetPasswordResponse response = new ForgetPasswordResponse();
		response.setStatus(source);
		return response;
	}

}
