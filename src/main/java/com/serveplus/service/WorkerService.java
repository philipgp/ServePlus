package com.serveplus.service;

import com.serveplus.web.request.worker.GetAssignedWorkRequest;
import com.serveplus.web.request.worker.StartWorkRequest;
import com.serveplus.web.request.worker.WorkClosedRequest;
import com.serveplus.web.request.worker.WorkCompletedRequest;
import com.serveplus.web.request.worker.WorkerServiceRequestDetailRequest;
import com.serveplus.web.response.worker.GetAssignedWorkResponse;
import com.serveplus.web.response.worker.StartWorkResponse;
import com.serveplus.web.response.worker.WorkClosedResponse;
import com.serveplus.web.response.worker.WorkCompletedResponse;
import com.serveplus.web.response.worker.WorkerServiceRequestDetailResponse;

public interface WorkerService {
	public GetAssignedWorkResponse getAssignedWorks(GetAssignedWorkRequest request);

	public StartWorkResponse startWork(StartWorkRequest request);
	public WorkCompletedResponse completedWork(WorkCompletedRequest request);
	public WorkClosedResponse closeWork(WorkClosedRequest request);
	public WorkerServiceRequestDetailResponse getServiceRequestDetail(WorkerServiceRequestDetailRequest request);
}
