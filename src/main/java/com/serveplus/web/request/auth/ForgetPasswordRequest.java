package com.serveplus.web.request.auth;

import com.serveplus.web.request.ServePlusRequest;

public class ForgetPasswordRequest extends ServePlusRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8833439110313443149L;
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
