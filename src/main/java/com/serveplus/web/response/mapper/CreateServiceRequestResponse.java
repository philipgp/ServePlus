package com.serveplus.web.response.mapper;

import com.serveplus.web.response.customer.CustomerResponseBase;

public class CreateServiceRequestResponse extends CustomerResponseBase{
	private Long serviceReqeustId;

	public Long getServiceReqeustId() {
		return serviceReqeustId;
	}

	public void setServiceReqeustId(Long serviceReqeustId) {
		this.serviceReqeustId = serviceReqeustId;
	}
	
}
