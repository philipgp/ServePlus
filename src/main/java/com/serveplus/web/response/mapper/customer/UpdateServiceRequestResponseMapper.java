package com.serveplus.web.response.mapper.customer;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.response.customer.UpdateServiceRequestResponse;
import com.serveplus.web.response.mapper.CreateServiceRequestResponse;
import com.serveplus.web.response.mapper.Mapper;

public class UpdateServiceRequestResponseMapper implements Mapper<ServiceRequest,UpdateServiceRequestResponse>{

	@Override
	public UpdateServiceRequestResponse mapFrom(ServiceRequest source) {
		UpdateServiceRequestResponse serviceResponse = new UpdateServiceRequestResponse();
		serviceResponse.setStatus(Boolean.TRUE); 
		return serviceResponse;
	}
	
}
