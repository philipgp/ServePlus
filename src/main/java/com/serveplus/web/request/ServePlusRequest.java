package com.serveplus.web.request;

import java.io.Serializable;

public class ServePlusRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -867122910186089602L;
	private String token;
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
