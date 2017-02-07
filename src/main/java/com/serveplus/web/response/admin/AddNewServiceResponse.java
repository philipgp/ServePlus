package com.serveplus.web.response.admin;

import com.serveplus.web.response.ServePlusResponse;

public class AddNewServiceResponse extends ServePlusResponse {
	private Long serviceId;

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
}
