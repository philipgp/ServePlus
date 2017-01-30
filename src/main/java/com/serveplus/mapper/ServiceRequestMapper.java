package com.serveplus.mapper;

import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.ServiceRequestStatus;
import com.serveplus.data.entity.SrActionHistory;
import com.serveplus.web.request.customer.CreateServiceRequest;
import com.serveplus.web.request.customer.CreateServiceRequestBase;
import com.serveplus.web.response.mapper.Mapper;


public class ServiceRequestMapper implements Mapper<CreateServiceRequest,ServiceRequest>{

	private Customer customer;
	private CompanyService companyService;
	private Assigner assigner;
	public ServiceRequestMapper(Customer customer, CompanyService companyService,
			Assigner assigner) {
		super();
		this.customer = customer;
		this.companyService = companyService;
		this.assigner = assigner;
	}
	
	@Override
	public ServiceRequest mapFrom(CreateServiceRequest source) {
		ServiceRequest serviceRequest = new ServiceRequest();
		AddressVOMapper addressMapper = new AddressVOMapper(source.getLatitude(), source.getLongitude());
		Address address = addressMapper.mapFrom(source.getLocalAddress());
		serviceRequest.setAddress(address);
		serviceRequest.setCustomer(customer);
		serviceRequest.setCompanyService(companyService);
		serviceRequest.setStatus(ServiceRequestStatus.REGISTERED);
		serviceRequest.setAssigner(assigner);
		serviceRequest.setRequest(source.getRequest());
		SrActionHistoryMapper actionHistoryMapper = new SrActionHistoryMapper();
		SrActionHistory actionHistory = actionHistoryMapper.mapFrom(serviceRequest);
		serviceRequest.addAction(actionHistory);
		return serviceRequest;
	}
	 
}
