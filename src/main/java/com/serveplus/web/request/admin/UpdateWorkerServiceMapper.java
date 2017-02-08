package com.serveplus.web.request.admin;

import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.Worker;
import com.serveplus.data.entity.WorkerService;
import com.serveplus.data.entity.WorkerServiceId;
import com.serveplus.web.response.mapper.Mapper;

public class UpdateWorkerServiceMapper implements Mapper<UpdateWorkerServiceRequest,WorkerService>{

	private WorkerService workerService;
	
	public UpdateWorkerServiceMapper(WorkerService workerService) {
		super();
		this.workerService = workerService;
	}

	@Override
	public WorkerService mapFrom(UpdateWorkerServiceRequest source) {
		
		if(source.getActive() != null)
			workerService.setActive(source.getActive());
		return workerService;
	}
 
}
