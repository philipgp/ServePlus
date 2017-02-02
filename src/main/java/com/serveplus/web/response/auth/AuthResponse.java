package com.serveplus.web.response.auth;

import com.serveplus.web.response.ServePlusResponse;

public class AuthResponse extends ServePlusResponse{
	private Boolean status;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
