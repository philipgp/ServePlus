package com.serveplus.web.response.auth;

import com.serveplus.web.response.ServePlusResponse;

public class LoginResponse extends AuthResponse {
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
