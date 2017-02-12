package com.serveplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.AdminDao;
import com.serveplus.data.dao.CompanyDao;
import com.serveplus.data.dao.CompanyServiceDao;
import com.serveplus.data.entity.Admin;
import com.serveplus.data.entity.Company;
import com.serveplus.service.CompanyService;
import com.serveplus.web.request.admin.CompanyServiceResponseMapper;
import com.serveplus.web.request.company.SetCompanyAdminRequest;
import com.serveplus.web.request.worker.CompanyServiceRequest;
import com.serveplus.web.response.customer.CompanyServiceResponse;
import com.serveplus.web.response.customer.SetCompanyAdminResponse;

@Component
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	CompanyServiceDao companyServiceDao;
	
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

	@Override
	public CompanyServiceResponse getAllCompanyService(
			CompanyServiceRequest companyServiceRequest) {
		Company company = companyDao.findById(companyServiceRequest.getCompanyId());
		List<com.serveplus.data.entity.CompanyService> companyServices = companyServiceDao.findBy(company);
		CompanyServiceResponseMapper mapper = new CompanyServiceResponseMapper();
		CompanyServiceResponse resposne = mapper.mapFrom(companyServices);
		return resposne;
	}  

}
