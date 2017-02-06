package com.serveplus.service;

import com.serveplus.web.request.company.SetCompanyAdminRequest;
import com.serveplus.web.response.customer.SetCompanyAdminResponse;

public interface CompanyService {
	public SetCompanyAdminResponse setCompanyAdmin(SetCompanyAdminRequest request);
}
