package com.serveplus.web.response.auth;

import java.util.List;

import com.serveplus.web.response.ServePlusResponse;
import com.serveplus.web.response.assigner.WorkerForServiceVO;

public class GetWorkerForServiceResponse extends ServePlusResponse{
	private List<WorkerForServiceVO> workers;

	public List<WorkerForServiceVO> getWorkers() {
		return workers;
	}

	public void setWorkers(List<WorkerForServiceVO> workers) {
		this.workers = workers;
	}
}
