package com.serveplus.web.response.register;

import com.serveplus.web.response.ServePlusResponse;

public class RegisterCompanyResponse extends ServePlusResponse{
	private Long companyId;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
