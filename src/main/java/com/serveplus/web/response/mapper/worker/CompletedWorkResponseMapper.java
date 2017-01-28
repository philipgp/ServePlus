package com.serveplus.web.response.mapper.worker;

import java.util.Date;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.worker.StartWorkResponse;
import com.serveplus.web.response.worker.WorkCompletedResponse;

public class CompletedWorkResponseMapper implements Mapper<ServiceRequest,WorkCompletedResponse>{

	@Override
	public WorkCompletedResponse mapFrom(ServiceRequest source) {
		WorkCompletedResponse response = new WorkCompletedResponse();
		response.setRegnId(source.getId());
		response.setDate(new Date());
		return response;
	}

}
