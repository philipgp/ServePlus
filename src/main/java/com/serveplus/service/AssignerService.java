package com.serveplus.service;

import com.serveplus.web.request.AssignerWorkAssignRequest;
import com.serveplus.web.request.GetWorksToAssignRequest;
import com.serveplus.web.request.assigner.GetWorkerForServiceRequest;
import com.serveplus.web.response.assigner.AssignerWorkAssignResponse;
import com.serveplus.web.response.assigner.GetWorksToAssignResponse;
import com.serveplus.web.response.auth.GetWorkerForServiceResponse;

public interface AssignerService {
	public GetWorkerForServiceResponse getWorkerForService(GetWorkerForServiceRequest request);
	public GetWorksToAssignResponse getWorksToAssign(GetWorksToAssignRequest request);
	public AssignerWorkAssignResponse assignWork(AssignerWorkAssignRequest request);
}
