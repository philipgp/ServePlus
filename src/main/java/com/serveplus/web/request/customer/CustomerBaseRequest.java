package com.serveplus.web.request.customer;

import com.serveplus.web.request.ServePlusRequest;

public class CustomerBaseRequest extends ServePlusRequest{
	private Long customerId;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long userId) {
		this.customerId = userId;
	}
}
