package com.serveplus.web.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serveplus.service.AuthService;
import com.serveplus.service.CustomerService;
import com.serveplus.service.WorkerService;
import com.serveplus.web.request.auth.ConfirmUserRegnRequest;
import com.serveplus.web.request.customer.CustomerRegisterRequest;
import com.serveplus.web.request.worker.GetAssignedWorkRequest;
import com.serveplus.web.request.worker.StartWorkRequest;
import com.serveplus.web.request.worker.WorkClosedRequest;
import com.serveplus.web.request.worker.WorkCompletedRequest;
import com.serveplus.web.request.worker.WorkerServiceRequestDetailRequest;
import com.serveplus.web.response.auth.ConfirmUserRegnResponse;
import com.serveplus.web.response.customer.CustomerRegisterResponse;
import com.serveplus.web.response.worker.GetAssignedWorkResponse;
import com.serveplus.web.response.worker.StartWorkResponse;
import com.serveplus.web.response.worker.WorkClosedResponse;
import com.serveplus.web.response.worker.WorkCompletedResponse;
import com.serveplus.web.response.worker.WorkerServiceRequestDetailResponse;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	static Logger log = Logger.getLogger(CompanyController.class.getName());
	
	
	
	
	
}
