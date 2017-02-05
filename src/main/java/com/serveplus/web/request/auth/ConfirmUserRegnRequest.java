package com.serveplus.web.request.auth;

import com.serveplus.web.request.ServePlusRequest;

public class ConfirmUserRegnRequest extends ServePlusRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2703979373452989462L;
	
	private String otp;
	private String userName;

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
