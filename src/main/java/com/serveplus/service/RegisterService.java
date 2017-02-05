package com.serveplus.service;

import com.serveplus.web.request.register.RegisterCompanyRequest;
import com.serveplus.web.response.register.RegisterCompanyResponse;

public interface RegisterService {
	public RegisterCompanyResponse registerCompany(RegisterCompanyRequest request);
}
