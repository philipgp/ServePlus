package com.serveplus.web.request;

public class StartWorkRequest extends ServePlusRequest{
	private String userName,token;
	private Long regnId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getRegnId() {
		return regnId;
	}

	public void setRegnId(Long regnId) {
		this.regnId = regnId;
	}

	
	
	
}
