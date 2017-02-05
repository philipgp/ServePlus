package com.serveplus.web.response.auth.mapper;

import com.serveplus.web.response.auth.VerifyForgotPasswordOtpResponse;
import com.serveplus.web.response.mapper.Mapper;

public class VerifyForgotPasswordOtpResponseMapper implements Mapper<Boolean,VerifyForgotPasswordOtpResponse>{

	@Override
	public VerifyForgotPasswordOtpResponse mapFrom(Boolean source) {
		VerifyForgotPasswordOtpResponse response = new VerifyForgotPasswordOtpResponse();
		response.setStatus(source);
		return response;
	}

}
