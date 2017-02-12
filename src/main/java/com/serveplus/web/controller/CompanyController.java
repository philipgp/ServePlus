package com.serveplus.web.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serveplus.service.CompanyService;
import com.serveplus.web.request.company.SetCompanyAdminRequest;
import com.serveplus.web.request.customer.UserServiceCompanyRequest;
import com.serveplus.web.request.worker.CompanyServiceRequest;
import com.serveplus.web.response.customer.CompanyServiceResponse;
import com.serveplus.web.response.customer.SetCompanyAdminResponse;
import com.serveplus.web.response.customer.UserServiceCompanyResponse;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	static Logger log = Logger.getLogger(CompanyController.class.getName());
	
	@Autowired
	CompanyService companyService;
	
	@RequestMapping(value = "/setCompanyAdmin", method = RequestMethod.POST)
	@ResponseBody
	public SetCompanyAdminResponse setCompanyAdmin(@RequestBody SetCompanyAdminRequest request){
		return companyService.setCompanyAdmin(request);
	}
	
	@RequestMapping(value = "/getServiceCompanies", method = RequestMethod.POST)
	@ResponseBody
	public CompanyServiceResponse getServiceCompanies(@RequestBody CompanyServiceRequest request){
		return companyService.getAllCompanyService(request);
	} 
	
	
}
