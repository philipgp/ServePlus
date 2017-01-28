package com.serveplus.web.response.customer;

import java.util.Set;

public class UserServiceCompanyResponse extends UserBaseResponse{
	private Set<ServiceCompanyVO> companies;

	public Set<ServiceCompanyVO> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<ServiceCompanyVO> companies) {
		this.companies = companies;
	}
}
