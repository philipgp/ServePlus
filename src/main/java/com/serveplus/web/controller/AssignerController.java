package com.serveplus.web.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serveplus.service.AssignerService;
import com.serveplus.web.request.AssignerWorkAssignRequest;
import com.serveplus.web.request.GetWorksToAssignRequest;
import com.serveplus.web.request.assigner.GetWorkerForServiceRequest;
import com.serveplus.web.request.company.SetCompanyAdminRequest;
import com.serveplus.web.response.assigner.AssignerWorkAssignResponse;
import com.serveplus.web.response.assigner.GetWorksToAssignResponse;
import com.serveplus.web.response.auth.GetWorkerForServiceResponse;
import com.serveplus.web.response.customer.SetCompanyAdminResponse;

@Controller
@RequestMapping("/assigner")
public class AssignerController {
	
	static Logger log = Logger.getLogger(AssignerController.class.getName());
	
	@Autowired
	AssignerService assignerService;
	
	@RequestMapping(value = "/getWorkerForService", method = RequestMethod.POST)
	@ResponseBody
	public GetWorkerForServiceResponse getWorkerForService(@RequestBody GetWorkerForServiceRequest request){
		return assignerService.getWorkerForService(request);
	}
	
	@RequestMapping(value = "/getWorksToAssign", method = RequestMethod.POST)
	@ResponseBody
	public GetWorksToAssignResponse getWorksToAssign(@RequestBody GetWorksToAssignRequest request){
		return assignerService.getWorksToAssign(request);
	}
	
	@RequestMapping(value = "/assignWork", method = RequestMethod.POST)
	@ResponseBody
	public AssignerWorkAssignResponse assignWork(@RequestBody AssignerWorkAssignRequest request){
		return assignerService.assignWork(request);
	}
	
	
}
