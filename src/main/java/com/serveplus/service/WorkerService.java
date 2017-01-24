package com.serveplus.service;

import com.serveplus.web.request.GetAssignedWorkRequest;
import com.serveplus.web.request.StartWorkRequest;
import com.serveplus.web.response.GetAssignedWorkResponse;
import com.serveplus.web.response.StartWorkResponse;

public interface WorkerService {
	public GetAssignedWorkResponse getAssignedWorks(GetAssignedWorkRequest request);

	public StartWorkResponse startWork(StartWorkRequest request);
}
