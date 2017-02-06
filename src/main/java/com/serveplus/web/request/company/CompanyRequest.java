package com.serveplus.web.request.company;

import com.serveplus.web.request.ServePlusRequest;

public class CompanyRequest extends ServePlusRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7576768187056653127L;
	private Long companyId;
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
