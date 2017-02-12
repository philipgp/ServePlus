package com.serveplus.web.request.worker;

import com.serveplus.web.request.ServePlusRequest;

public class CompanyServiceRequest extends ServePlusRequest {
	private Long companyId;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
