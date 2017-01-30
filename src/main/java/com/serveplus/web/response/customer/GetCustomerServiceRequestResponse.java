package com.serveplus.web.response.customer;

import java.util.List;

import com.serveplus.web.request.customer.CustomerServiceRequestVO;

public class GetCustomerServiceRequestResponse extends CustomerResponseBase{
	private List<CustomerServiceRequestVO> serviceRequests;

	public List<CustomerServiceRequestVO> getServiceRequests() {
		return serviceRequests;
	}

	public void setServiceRequests(List<CustomerServiceRequestVO> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}
}
