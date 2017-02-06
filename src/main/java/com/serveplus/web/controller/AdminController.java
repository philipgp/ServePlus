package com.serveplus.web.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serveplus.service.AdminService;
import com.serveplus.web.request.admin.AdminGetAllServiceRequestRequest;
import com.serveplus.web.request.admin.GetCustomerServiceRequestRequest;
import com.serveplus.web.request.admin.GetWorkerServiceRequestRequest;
import com.serveplus.web.request.assigner.GetWorkerForServiceRequest;
import com.serveplus.web.response.admin.AdminGetAllServiceRequestResponse;
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
	
}
