package com.serveplus.web.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serveplus.service.AdminService;
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
import com.serveplus.web.request.assigner.GetWorkerForServiceRequest;
import com.serveplus.web.response.admin.AddNewAdminResponse;
import com.serveplus.web.response.admin.AddNewAssignerResponse;
import com.serveplus.web.response.admin.AddNewCompanyServiceResponse;
import com.serveplus.web.response.admin.AddNewCsAssignerResponse;
import com.serveplus.web.response.admin.AddNewServiceResponse;
import com.serveplus.web.response.admin.AdminGetAllServiceRequestResponse;
import com.serveplus.web.response.admin.GetAllCustomerSummaryResponse;
import com.serveplus.web.response.admin.GetAllWorkersSummaryResponse;
import com.serveplus.web.response.admin.GetForCustomerServiceRequestResponse;
import com.serveplus.web.response.admin.GetForWorkerServiceRequestResponse;
import com.serveplus.web.response.auth.GetWorkerForServiceResponse;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	static Logger log = Logger.getLogger(AdminController.class.getName());
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/getAllServiceRequests", method = RequestMethod.POST)
	@ResponseBody
	public AdminGetAllServiceRequestResponse getWorkerForService(@RequestBody AdminGetAllServiceRequestRequest request){
		return adminService.getAllServiceRequests(request);
	}
	
	@RequestMapping(value = "/getCustomerServiceRequests", method = RequestMethod.POST)
	@ResponseBody
	public GetForCustomerServiceRequestResponse getCustomerServiceRequests(@RequestBody GetCustomerServiceRequestRequest request){
		return adminService.getCustomerServiceRequest(request);
	}
	
	@RequestMapping(value = "/getWorkerServiceRequests", method = RequestMethod.POST)
	@ResponseBody
	public GetForWorkerServiceRequestResponse getWorkerServiceRequests(@RequestBody GetWorkerServiceRequestRequest request){
		return adminService.getWorkerServiceRequests(request);
	}
	
	@RequestMapping(value = "/getAllWorkersSummary", method = RequestMethod.POST)
	@ResponseBody
	public GetAllWorkersSummaryResponse getWorkerServiceRequests(@RequestBody GetAllWorkersSummaryRequest request){
		return adminService.getAllWorkersSummary(request);
	}
	
	@RequestMapping(value = "/getAllCustomerSummary", method = RequestMethod.POST)
	@ResponseBody
	public GetAllCustomerSummaryResponse getAllCustomerSummary(@RequestBody GetAllCustomerSummaryRequest request){
		return adminService.getALlCustomerSummary(request);
	}
	
	@RequestMapping(value = "/addNewService", method = RequestMethod.POST)
	@ResponseBody
	public AddNewServiceResponse addNewService(@RequestBody AddNewServiceRequest request){
		return adminService.addNewService(request);
	}
	
	@RequestMapping(value = "/addNewCompanyService", method = RequestMethod.POST)
	@ResponseBody
	public AddNewCompanyServiceResponse addNewCompanyService(@RequestBody AddNewCompanyServiceRequest request){
		return adminService.addNewCompanyService(request);
	}
	
	@RequestMapping(value = "/addNewCsAssigner", method = RequestMethod.POST)
	@ResponseBody
	public AddNewCsAssignerResponse addNewCsAssigner(@RequestBody AddNewCSAssignerRequest request){
		return adminService.addNewCsAssigner(request);
	}
	
	@RequestMapping(value = "/addNewAssigner", method = RequestMethod.POST)
	@ResponseBody
	public AddNewAssignerResponse addNewAssigner(@RequestBody AddNewAssignerRequest request){
		return adminService.addNewAssigner(request);
	}
	
	@RequestMapping(value = "/addNewAdmin", method = RequestMethod.POST)
	@ResponseBody
	public AddNewAdminResponse addNewAdmin(@RequestBody AddNewAdminRequest request){
		return adminService.addNewAdmin(request);
	}
}
