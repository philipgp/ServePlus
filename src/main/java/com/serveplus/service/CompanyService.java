package com.serveplus.service;

import com.serveplus.web.request.company.SetCompanyAdminRequest;
import com.serveplus.web.request.worker.CompanyServiceRequest;
import com.serveplus.web.response.customer.CompanyServiceResponse;
import com.serveplus.web.response.customer.SetCompanyAdminResponse;

public interface CompanyService {
	public SetCompanyAdminResponse setCompanyAdmin(SetCompanyAdminRequest request);
	public CompanyServiceResponse getAllCompanyService(CompanyServiceRequest companyServiceRequest);
}
