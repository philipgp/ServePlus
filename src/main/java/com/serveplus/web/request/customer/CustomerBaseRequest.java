package com.serveplus.web.request.customer;

import com.serveplus.web.request.ServePlusRequest;

public class CustomerBaseRequest extends ServePlusRequest{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8496302997345889906L;
	private Long customerId;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long userId) {
		this.customerId = userId;
	}
}
