package com.serveplus.web.response.customer;

import java.util.List;

public class GetCustomerServiceRequestResponse extends UserBaseResponse{
	private List<CustomerServiceRequestVO> serviceRequests;

	public List<CustomerServiceRequestVO> getServiceRequests() {
		return serviceRequests;
	}

	public void setServiceRequests(List<CustomerServiceRequestVO> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}
}
