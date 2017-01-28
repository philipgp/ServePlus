package com.serveplus.service;

import com.serveplus.web.request.customer.CreateServiceRequest;
import com.serveplus.web.request.customer.CustomerServiceRequestDetailRequest;
import com.serveplus.web.request.customer.GetCustomerServiceRequest;
import com.serveplus.web.request.customer.UserServiceCompanyRequest;
import com.serveplus.web.request.customer.UserServiceRequest;
import com.serveplus.web.response.customer.CustomerServiceRequestDetailResponse;
import com.serveplus.web.response.customer.GetCustomerServiceRequestResponse;
import com.serveplus.web.response.customer.UserServiceCompanyResponse;
import com.serveplus.web.response.customer.UserServiceResponse;
import com.serveplus.web.response.mapper.CreateServiceRequestResponse;

public interface CustomerService {
	public UserServiceResponse getServices(UserServiceRequest request);
	public UserServiceCompanyResponse getCompanies(UserServiceCompanyRequest request);
	public CreateServiceRequestResponse createServiceRequest(CreateServiceRequest request);
	public GetCustomerServiceRequestResponse getServiceRequests(GetCustomerServiceRequest request);
	public CustomerServiceRequestDetailResponse getServiceRequestDetail(CustomerServiceRequestDetailRequest request);
}
