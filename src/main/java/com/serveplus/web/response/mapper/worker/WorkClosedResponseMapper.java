package com.serveplus.web.response.mapper.worker;

import java.util.Date;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.worker.WorkClosedResponse;

public class WorkClosedResponseMapper implements Mapper<ServiceRequest,WorkClosedResponse>{

	@Override
	public WorkClosedResponse mapFrom(ServiceRequest source) {
		WorkClosedResponse response = new WorkClosedResponse();
		response.setRegnId(source.getId());
		response.setDate(new Date());
		return response;
	}

}
