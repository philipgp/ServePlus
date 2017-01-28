package com.serveplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.CompanyDao;
import com.serveplus.data.dao.CsAssignerDao;
import com.serveplus.data.dao.CustomerDao;
import com.serveplus.data.dao.ServiceDao;
import com.serveplus.data.dao.ServiceRequestDao;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CsAssigner;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.mapper.ServiceRequestMapper;
import com.serveplus.service.CustomerService;
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
import com.serveplus.web.response.mapper.customer.CreateServiceRequestResponseMapper;
import com.serveplus.web.response.mapper.customer.CustomerServiceRequestDetailResponseMapper;
import com.serveplus.web.response.mapper.customer.GetCustomerServiceRequestResponseMapper;
import com.serveplus.web.response.mapper.customer.UserServiceCompanyResponseMapper;
import com.serveplus.web.response.mapper.customer.UserServiceResponseMapper;
import com.serveplus.web.response.mapper.worker.WorkerServiceRequestDetailResponseMapper;
import com.serveplus.web.response.worker.WorkerServiceRequestDetailResponse;

@Component
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	ServiceDao serviceDao;
	

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CsAssignerDao csAssigner;
	
	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	ServiceRequestDao serviceRequestDao;
	
	@Override
	public UserServiceResponse getServices(UserServiceRequest request) {
		List<Service> activeServices = serviceDao.getActiveServices();
		UserServiceResponseMapper mapper = new UserServiceResponseMapper();
		UserServiceResponse response = mapper.mapFrom(activeServices);
		return response;
	}

	@Override
	public UserServiceCompanyResponse getCompanies(
			UserServiceCompanyRequest request) {
		Service service = serviceDao.findById(request.getServiceId());
		UserServiceCompanyResponseMapper mapper = new UserServiceCompanyResponseMapper();
		UserServiceCompanyResponse mappedResponse = mapper.mapFrom(service);
		return mappedResponse;
	}

	@Override
	public CreateServiceRequestResponse createServiceRequest(
			CreateServiceRequest request) {
		
		Customer customer = customerDao.findById(request.getCustomerId());
		Service service = serviceDao.findById(request.getServiceId());
		Company company = companyDao.findById(request.getCompanyId());
		List<CsAssigner> csAssigners = csAssigner.findBy(company, service);
		ServiceRequestMapper mapper = new ServiceRequestMapper(customer,service,null);
		ServiceRequest serviceRequest= mapper.mapFrom(request);
		serviceRequestDao.save(serviceRequest);
		CreateServiceRequestResponseMapper responseMapper = new CreateServiceRequestResponseMapper();
		CreateServiceRequestResponse response = responseMapper.mapFrom(serviceRequest);
		return response;
	}

	@Override
	public GetCustomerServiceRequestResponse getServiceRequests(
			GetCustomerServiceRequest request) {
		List<ServiceRequest> serviceRequests = serviceRequestDao.getServiceRequestsByCustomerId(request.getCustomerId());
		GetCustomerServiceRequestResponseMapper responseMapper = new GetCustomerServiceRequestResponseMapper();
		GetCustomerServiceRequestResponse response = responseMapper.mapFrom(serviceRequests);
		return response;
	}

	@Override
	public CustomerServiceRequestDetailResponse getServiceRequestDetail(
			CustomerServiceRequestDetailRequest request) {
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestById(request.getServiceRequestId());
		CustomerServiceRequestDetailResponseMapper mapper = new CustomerServiceRequestDetailResponseMapper();
		CustomerServiceRequestDetailResponse response = mapper.mapFrom(serviceRequest);
		return response;
	}

}
