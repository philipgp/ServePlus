package com.serveplus.web.request.auth;

import com.serveplus.web.request.ServePlusRequest;

public class VerifyForgotPasswordOtpRequest extends ServePlusRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -952673941998915955L;
	private String otp;
	private String userName;
	private String newPassword;
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
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
