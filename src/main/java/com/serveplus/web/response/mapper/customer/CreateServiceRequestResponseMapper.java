package com.serveplus.web.response.mapper.customer;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.response.mapper.CreateServiceRequestResponse;
import com.serveplus.web.response.mapper.Mapper;

public class CreateServiceRequestResponseMapper implements Mapper<ServiceRequest,CreateServiceRequestResponse>{

	@Override
	public CreateServiceRequestResponse mapFrom(ServiceRequest source) {
		CreateServiceRequestResponse serviceResponse = new CreateServiceRequestResponse();
		serviceResponse.setServiceReqeustId(source.getId()); 
		return serviceResponse;
	}
	
}
