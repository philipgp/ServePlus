package com.serveplus.web.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serveplus.service.CustomerService;
import com.serveplus.service.WorkerService;
import com.serveplus.web.request.customer.CreateServiceRequest;
import com.serveplus.web.request.customer.CustomerServiceRequestDetailRequest;
import com.serveplus.web.request.customer.GetCustomerServiceRequest;
import com.serveplus.web.request.customer.GetFeedbackRequest;
import com.serveplus.web.request.customer.RatingFeedbackRequest;
import com.serveplus.web.request.customer.RatingQuestionRequest;
import com.serveplus.web.request.customer.UpdateServiceRequest;
import com.serveplus.web.request.customer.UserServiceCompanyRequest;
import com.serveplus.web.request.customer.UserServiceRequest;
import com.serveplus.web.request.worker.GetAssignedWorkRequest;
import com.serveplus.web.request.worker.StartWorkRequest;
import com.serveplus.web.request.worker.WorkClosedRequest;
import com.serveplus.web.request.worker.WorkCompletedRequest;
import com.serveplus.web.request.worker.WorkerServiceRequestDetailRequest;
import com.serveplus.web.response.customer.CustomerServiceRequestDetailResponse;
import com.serveplus.web.response.customer.GetCustomerServiceRequestResponse;
import com.serveplus.web.response.customer.GetFeedbackResponse;
import com.serveplus.web.response.customer.RatingFeedbackResponse;
import com.serveplus.web.response.customer.RatingQuestionResponse;
import com.serveplus.web.response.customer.UpdateServiceRequestResponse;
import com.serveplus.web.response.customer.UserServiceCompanyResponse;
import com.serveplus.web.response.customer.UserServiceResponse;
import com.serveplus.web.response.mapper.CreateServiceRequestResponse;
import com.serveplus.web.response.worker.GetAssignedWorkResponse;
import com.serveplus.web.response.worker.StartWorkResponse;
import com.serveplus.web.response.worker.WorkClosedResponse;
import com.serveplus.web.response.worker.WorkCompletedResponse;
import com.serveplus.web.response.worker.WorkerServiceRequestDetailResponse;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	static Logger log = Logger.getLogger(CustomerController.class.getName());
	
	
	@Autowired
	CustomerService userService;
	
	@RequestMapping(value = "/getServices", method = RequestMethod.POST)
	@ResponseBody
	public UserServiceResponse getServices(@RequestBody UserServiceRequest request){
		return userService.getServices(request);
	}
	
	@RequestMapping(value = "/getCompanies", method = RequestMethod.POST)
	@ResponseBody
	public UserServiceCompanyResponse getCompanies(@RequestBody UserServiceCompanyRequest request){
		return userService.getCompanies(request);
	}
	
	@RequestMapping(value = "/createServiceRequest", method = RequestMethod.POST)
	@ResponseBody
	public CreateServiceRequestResponse createServiceRequest(@RequestBody CreateServiceRequest request){
		return userService.createServiceRequest(request);
	}
	
	@RequestMapping(value = "/getServiceRequests", method = RequestMethod.POST)
	@ResponseBody
	public GetCustomerServiceRequestResponse getServiceRequests(@RequestBody GetCustomerServiceRequest request){
		return userService.getServiceRequests(request);
	}
	
	@RequestMapping(value = "/getServiceRequestDetail", method = RequestMethod.POST)
	@ResponseBody
	public CustomerServiceRequestDetailResponse getServiceRequestDetail(@RequestBody CustomerServiceRequestDetailRequest request){
		return userService.getServiceRequestDetail(request);
	}
	
	@RequestMapping(value = "/updateServiceRequest", method = RequestMethod.POST)
	@ResponseBody
	public UpdateServiceRequestResponse updateServiceRequest(@RequestBody UpdateServiceRequest request){
		return userService.updateServiceRequest(request);
	}
	
	@RequestMapping(value = "/getRatingQuestions", method = RequestMethod.POST)
	@ResponseBody
	public RatingQuestionResponse updateServiceRequest(@RequestBody RatingQuestionRequest request){
		return userService.getRatingQuestions(request);
	}
	
	@RequestMapping(value = "/setFeedback", method = RequestMethod.POST)
	@ResponseBody
	public RatingFeedbackResponse setFeedback(@RequestBody RatingFeedbackRequest request){
		return userService.setFeedback(request);
	}
	
	@RequestMapping(value = "/getFeedback", method = RequestMethod.POST)
	@ResponseBody
	public GetFeedbackResponse getFeedback(@RequestBody GetFeedbackRequest request){
		return userService.getFeedbacks(request);
	}
	
	
}
