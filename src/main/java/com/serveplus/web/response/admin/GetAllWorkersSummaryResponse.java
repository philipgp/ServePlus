package com.serveplus.web.response.admin;

import java.util.List;

import com.serveplus.data.entity.Worker;
import com.serveplus.web.response.ServePlusResponse;

public class GetAllWorkersSummaryResponse extends ServePlusResponse{
	private List<WorkerSummaryVO> workers;

	public List<WorkerSummaryVO> getWorkers() {
		return workers;
	}

	public void setWorkers(List<WorkerSummaryVO> workers) {
		this.workers = workers;
	}
}
