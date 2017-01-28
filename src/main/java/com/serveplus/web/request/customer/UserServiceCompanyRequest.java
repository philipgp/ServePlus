package com.serveplus.web.request.customer;

public class UserServiceCompanyRequest extends CustomerBaseRequest{
	private Long serviceId;

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
}
