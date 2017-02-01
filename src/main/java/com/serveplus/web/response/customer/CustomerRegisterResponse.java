package com.serveplus.web.response.customer;

import com.serveplus.web.response.ServePlusResponse;

public class CustomerRegisterResponse extends ServePlusResponse{
	private Long customerId;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
