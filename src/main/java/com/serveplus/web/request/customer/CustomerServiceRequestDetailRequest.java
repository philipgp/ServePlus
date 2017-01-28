package com.serveplus.web.request.customer;

public class CustomerServiceRequestDetailRequest extends CustomerBaseRequest{
	private Long serviceRequestId;

	public Long getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(Long serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
}
