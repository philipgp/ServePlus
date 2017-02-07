package com.serveplus.service;

import com.serveplus.web.request.admin.AddNewAdminRequest;
import com.serveplus.web.request.admin.AddNewAssignerRequest;
import com.serveplus.web.request.admin.AddNewCSAssignerRequest;
import com.serveplus.web.request.admin.AddNewCompanyServiceRequest;
import com.serveplus.web.request.admin.AddNewServiceRequest;
import com.serveplus.web.request.admin.AdminGetAllServiceRequestRequest;
import com.serveplus.web.request.admin.GetAllCustomerSummaryRequest;
import com.serveplus.web.request.admin.GetAllWorkersSummaryRequest;
import com.serveplus.web.request.admin.GetCustomerServiceRequestRequest;
import com.serveplus.web.request.admin.GetWorkerServiceRequestRequest;
import com.serveplus.web.request.admin.RemoveAssignerRequest;
import com.serveplus.web.request.admin.RemoveCompanyServiceRequest;
import com.serveplus.web.request.admin.RemoveCsAssignerRequest;
import com.serveplus.web.request.admin.RemoveServiceRequest;
import com.serveplus.web.response.admin.AddNewAdminResponse;
import com.serveplus.web.response.admin.AddNewAssignerResponse;
import com.serveplus.web.response.admin.AddNewCompanyServiceResponse;
import com.serveplus.web.response.admin.AddNewCsAssignerResponse;
import com.serveplus.web.response.admin.AddNewServiceResponse;
import com.serveplus.web.response.admin.AdminGetAllServiceRequestResponse;
import com.serveplus.web.response.admin.BooleanResponse;
import com.serveplus.web.response.admin.GetAllCustomerSummaryResponse;
import com.serveplus.web.response.admin.GetAllWorkersSummaryResponse;
import com.serveplus.web.response.admin.GetForCustomerServiceRequestResponse;
import com.serveplus.web.response.admin.GetForWorkerServiceRequestResponse;

public interface AdminService {
	public AdminGetAllServiceRequestResponse getAllServiceRequests(AdminGetAllServiceRequestRequest request);
	public GetForCustomerServiceRequestResponse getCustomerServiceRequest(GetCustomerServiceRequestRequest request);
	public GetForWorkerServiceRequestResponse getWorkerServiceRequests(GetWorkerServiceRequestRequest request);
	public GetAllWorkersSummaryResponse getAllWorkersSummary(GetAllWorkersSummaryRequest request);
	public GetAllCustomerSummaryResponse getALlCustomerSummary(GetAllCustomerSummaryRequest request);
	public AddNewServiceResponse addNewService(AddNewServiceRequest request);
	public AddNewCompanyServiceResponse addNewCompanyService(AddNewCompanyServiceRequest request);
	public AddNewCsAssignerResponse addNewCsAssigner(AddNewCSAssignerRequest request);
	public AddNewAssignerResponse addNewAssigner(AddNewAssignerRequest request);
	public AddNewAdminResponse addNewAdmin(AddNewAdminRequest request);
	public BooleanResponse removeAssigner(RemoveAssignerRequest request);
	public BooleanResponse removeCompanyService(RemoveCompanyServiceRequest request);
	public BooleanResponse removeCsAssigner(RemoveCsAssignerRequest request);
	public BooleanResponse removeService(RemoveServiceRequest request);
}
