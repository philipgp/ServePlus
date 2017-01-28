package com.serveplus.mapper;

import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.ServiceRequestStatus;
import com.serveplus.data.entity.SrActionHistory;
import com.serveplus.web.request.customer.CreateServiceRequest;
import com.serveplus.web.response.mapper.Mapper;


public class ServiceRequestMapper implements Mapper<CreateServiceRequest,ServiceRequest>{

	private Customer customer;
	private Service service;
	private Assigner assigner;
	public ServiceRequestMapper(Customer customer, Service service,
			Assigner assigner) {
		super();
		this.customer = customer;
		this.service = service;
		this.assigner = assigner;
	}
	
	@Override
	public ServiceRequest mapFrom(CreateServiceRequest source) {
		ServiceRequest serviceRequest = new ServiceRequest();
		AddressVOMapper addressMapper = new AddressVOMapper(source.getLatitude(), source.getLongitude());
		Address address = addressMapper.mapFrom(source.getLocalAddress());
		serviceRequest.setAddress(address);
		serviceRequest.setCustomer(customer);
		serviceRequest.setService(service);
		serviceRequest.setStatus(ServiceRequestStatus.REGISTERED);
		serviceRequest.setAssigner(assigner);
		SrActionHistoryMapper actionHistoryMapper = new SrActionHistoryMapper();
		SrActionHistory actionHistory = actionHistoryMapper.mapFrom(serviceRequest);
		serviceRequest.addAction(actionHistory);
		return serviceRequest;
	}
	 
}
