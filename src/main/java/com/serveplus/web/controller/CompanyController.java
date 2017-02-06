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
import com.serveplus.web.response.customer.SetCompanyAdminResponse;

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
	
	
}
