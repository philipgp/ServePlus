package com.serveplus.service;

import com.serveplus.web.request.admin.AdminGetAllServiceRequestRequest;
import com.serveplus.web.request.admin.GetCustomerServiceRequestRequest;
import com.serveplus.web.request.admin.GetWorkerServiceRequestRequest;
import com.serveplus.web.response.admin.AdminGetAllServiceRequestResponse;
import com.serveplus.web.response.admin.GetForCustomerServiceRequestResponse;
import com.serveplus.web.response.admin.GetForWorkerServiceRequestResponse;

public interface AdminService {
	public AdminGetAllServiceRequestResponse getAllServiceRequests(AdminGetAllServiceRequestRequest request);
	public GetForCustomerServiceRequestResponse getCustomerServiceRequest(GetCustomerServiceRequestRequest request);
	public GetForWorkerServiceRequestResponse getWorkerServiceRequests(GetWorkerServiceRequestRequest request);
}
