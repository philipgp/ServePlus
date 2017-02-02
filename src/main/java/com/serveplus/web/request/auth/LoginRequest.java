package com.serveplus.web.request.auth;

import com.serveplus.web.request.ServePlusRequest;

public class LoginRequest extends ServePlusRequest{
	private String userName,password;
	private String channel;
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

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

	@Override
	public String toString() {
		return "LoginRequest [userName=" + userName + ", password=" + password
				+ ", channel=" + channel + "]";
	}
}
