package com.serveplus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.AdminDao;
import com.serveplus.data.dao.CompanyDao;
import com.serveplus.data.entity.Admin;
import com.serveplus.data.entity.Company;
import com.serveplus.service.CompanyService;
import com.serveplus.web.request.company.SetCompanyAdminRequest;
import com.serveplus.web.response.customer.SetCompanyAdminResponse;

@Component
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	AdminDao adminDao;
	
	@Override
	public SetCompanyAdminResponse setCompanyAdmin(
			SetCompanyAdminRequest request) {
		Company company = companyDao.findById(request.getCompanyId());
		Admin admin = adminDao.findById(request.getAdminId());
		company.setAdmin(admin);
		companyDao.save(company);
		SetCompanyAdminResponse setCompanyAdminResponse = new SetCompanyAdminResponse();
		setCompanyAdminResponse.setStatus(Boolean.TRUE);
		return setCompanyAdminResponse;
	}  

}
