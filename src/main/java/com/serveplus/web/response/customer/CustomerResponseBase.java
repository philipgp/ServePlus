package com.serveplus.web.response.customer;

import com.serveplus.web.response.ServePlusResponse;

public class CustomerResponseBase extends ServePlusResponse{
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
