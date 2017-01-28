package com.serveplus.web.response.mapper;

import com.serveplus.web.response.customer.UserBaseResponse;

public class CreateServiceRequestResponse extends UserBaseResponse{
	private Long serviceReqeustId;

	public Long getServiceReqeustId() {
		return serviceReqeustId;
	}

	public void setServiceReqeustId(Long serviceReqeustId) {
		this.serviceReqeustId = serviceReqeustId;
	}
	
}
