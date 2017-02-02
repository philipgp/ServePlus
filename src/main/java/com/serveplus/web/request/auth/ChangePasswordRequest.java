package com.serveplus.web.request.auth;

import com.serveplus.web.request.ServePlusRequest;

public class ChangePasswordRequest extends ServePlusRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6055376492368708430L;

	private String newPassword,oldPassword;
	private String userName;

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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
}
