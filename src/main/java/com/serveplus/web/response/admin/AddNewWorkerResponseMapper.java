package com.serveplus.web.response.admin;

import com.serveplus.data.entity.Admin;
import com.serveplus.data.entity.Worker;
import com.serveplus.web.response.mapper.Mapper;

public class AddNewWorkerResponseMapper implements Mapper<Worker,AddNewWorkerResponse>{

	@Override
	public AddNewWorkerResponse mapFrom(Worker source) {
		AddNewWorkerResponse response = new AddNewWorkerResponse();
		response.setStatus(Boolean.TRUE);
		response.setWorkerId(source.getId());
		return response;
	}

}
