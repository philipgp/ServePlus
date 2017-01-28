package com.serveplus.web.response.mapper.worker;

import java.util.Date;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.worker.StartWorkResponse;

public class StartWorkResponseMapper implements Mapper<ServiceRequest,StartWorkResponse>{

	@Override
	public StartWorkResponse mapFrom(ServiceRequest source) {
		StartWorkResponse response = new StartWorkResponse();
		response.setRegnId(source.getId());
		response.setDate(new Date());
		return response;
	}

}
