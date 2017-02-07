package com.serveplus.web.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serveplus.service.UserService;
import com.serveplus.web.request.customer.CreateServiceRequest;
import com.serveplus.web.request.customer.CustomerServiceRequestDetailRequest;
import com.serveplus.web.request.customer.GetCustomerServiceRequest;
import com.serveplus.web.request.customer.GetFeedbackRequest;
import com.serveplus.web.request.customer.RatingFeedbackRequest;
import com.serveplus.web.request.customer.RatingQuestionRequest;
import com.serveplus.web.request.customer.UpdateServiceRequest;
import com.serveplus.web.request.customer.UserServiceCompanyRequest;
import com.serveplus.web.request.customer.UserServiceRequest;
import com.serveplus.web.request.register.UserProfileRequest;
import com.serveplus.web.response.customer.CustomerServiceRequestDetailResponse;
import com.serveplus.web.response.customer.GetCustomerServiceRequestResponse;
import com.serveplus.web.response.customer.GetFeedbackResponse;
import com.serveplus.web.response.customer.RatingFeedbackResponse;
import com.serveplus.web.response.customer.RatingQuestionResponse;
import com.serveplus.web.response.customer.UpdateServiceRequestResponse;
import com.serveplus.web.response.customer.UserServiceCompanyResponse;
import com.serveplus.web.response.customer.UserServiceResponse;
import com.serveplus.web.response.mapper.CreateServiceRequestResponse;
import com.serveplus.web.response.user.UserProfileResponse;

@Controller
@RequestMapping("/user")
public class UserController {
	
	static Logger log = Logger.getLogger(UserController.class.getName());
	
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/getProfile", method = RequestMethod.POST)
	@ResponseBody
	public UserProfileResponse getProfile(@RequestBody UserProfileRequest request){
		return userService.getProfile(request);
	}
	
	
	
	
}
