package com.serveplus.web.request.customer;

import com.serveplus.web.request.ServePlusRequest;

public class CustomerRegisterRequest extends UserRegisterRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3130384085355161794L;
	
	private String userName,password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
