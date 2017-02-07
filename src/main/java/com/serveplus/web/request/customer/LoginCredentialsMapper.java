package com.serveplus.web.request.customer;

import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.data.entity.Otp;
import com.serveplus.request.mapper.OtpMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.worker.ServePlusUtil;

public class LoginCredentialsMapper implements Mapper<UserRegisterRequest,LoginCredentials>{

	@Override
	public LoginCredentials mapFrom(UserRegisterRequest source) {
		LoginCredentials loginCredentials = new  LoginCredentials();
		loginCredentials.setUserName(source.getUserName());
		loginCredentials.setPassword(source.getPassword());
		String otp = ServePlusUtil.generateOtp();
		OtpMapper otpMapper = new OtpMapper();
		Otp otpD = otpMapper.mapFrom(otp);
		loginCredentials.setRegnOtpId(otpD);
		return loginCredentials;
	}

}
