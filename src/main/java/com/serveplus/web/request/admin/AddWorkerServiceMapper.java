package com.serveplus.web.request.admin;

import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.Worker;
import com.serveplus.data.entity.WorkerService;
import com.serveplus.data.entity.WorkerServiceId;
import com.serveplus.web.response.mapper.Mapper;

public class AddWorkerServiceMapper implements Mapper<AddNewWorkerServiceRequest,WorkerService>{

	private Worker worker;
	private Service service;
	public AddWorkerServiceMapper(Worker worker, Service service) {
		super();
		this.worker = worker;
		this.service = service;
	}
	@Override
	public WorkerService mapFrom(AddNewWorkerServiceRequest source) {
		WorkerService workerService = new  WorkerService();
		workerService.setActive(Boolean.TRUE);
		WorkerServiceId workerServiceId = new WorkerServiceId();
		workerServiceId.setService(service);
		workerServiceId.setWorker(worker);
		workerService.setWorkerServiceId(workerServiceId);
		return workerService;
	}
 
}
