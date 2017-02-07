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
import com.serveplus.service.RegisterService;
import com.serveplus.web.request.auth.ConfirmUserRegnRequest;
import com.serveplus.web.request.customer.CustomerRegisterRequest;
import com.serveplus.web.request.register.RegisterCompanyRequest;
import com.serveplus.web.response.auth.ConfirmUserRegnResponse;
import com.serveplus.web.response.customer.CustomerRegisterResponse;
import com.serveplus.web.response.register.RegisterCompanyResponse;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	static Logger log = Logger.getLogger(RegistrationController.class.getName());
	
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AuthService authService;
	
	@Autowired
	RegisterService registerService;
	
	@RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
	@ResponseBody
	public CustomerRegisterResponse registerCustomer(@RequestBody CustomerRegisterRequest request){
		return customerService.registerCustomer(request);
	}
	
	@RequestMapping(value = "/registerCompany", method = RequestMethod.POST)
	@ResponseBody
	public RegisterCompanyResponse registerCompany(@RequestBody RegisterCompanyRequest request){
		return registerService.registerCompany(request);
	}
	
	@RequestMapping(value = "/confirmUserRegistration", method = RequestMethod.POST)
	@ResponseBody
	public ConfirmUserRegnResponse verifyForgotPasswordOtp(@RequestBody ConfirmUserRegnRequest request){
		return authService.confirmUserRegistration(request);
	}
	
	
}
