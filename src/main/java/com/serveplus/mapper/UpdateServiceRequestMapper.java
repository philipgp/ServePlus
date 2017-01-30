package com.serveplus.mapper;

import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.ServiceRequestStatus;
import com.serveplus.data.entity.SrAction;
import com.serveplus.data.entity.SrActionHistory;
import com.serveplus.web.request.customer.CreateServiceRequest;
import com.serveplus.web.request.customer.CreateServiceRequestBase;
import com.serveplus.web.request.customer.UpdateServiceRequest;
import com.serveplus.web.response.mapper.Mapper;


public class UpdateServiceRequestMapper implements Mapper<UpdateServiceRequest,ServiceRequest>{

	private ServiceRequest serviceRequest;
	
	public UpdateServiceRequestMapper(ServiceRequest serviceRequest) {
		super();
		this.serviceRequest = serviceRequest;
	}

	@Override
	public ServiceRequest mapFrom(UpdateServiceRequest source) {
		
		AddressVOMapperWithId addressMapper = new AddressVOMapperWithId(source.getLatitude(), source.getLongitude(),serviceRequest.getAddress());
		Address address = addressMapper.mapFrom(source.getLocalAddress());
		serviceRequest.setAddress(address);
		serviceRequest.setRequest(source.getRequest());
		SrActionHistoryMapper actionHistoryMapper = new SrActionHistoryMapper(SrAction.UPDATED);
		SrActionHistory actionHistory = actionHistoryMapper.mapFrom(serviceRequest);
		serviceRequest.addAction(actionHistory);
		
		return serviceRequest;
	}
	 
}
