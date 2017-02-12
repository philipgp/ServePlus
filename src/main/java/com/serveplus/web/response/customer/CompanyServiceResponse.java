package com.serveplus.web.response.customer;

import java.util.Set;

import com.serveplus.web.response.ServePlusResponse;

public class CompanyServiceResponse extends ServePlusResponse{
	private Set<CompanyServiceVO> companyServices;

	public Set<CompanyServiceVO> getCompanyServices() {
		return companyServices;
	}

	public void setCompanyServices(Set<CompanyServiceVO> companyServices) {
		this.companyServices = companyServices;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyServiceResponse [companyServices=")
				.append(companyServices).append("]");
		return builder.toString();
	}
}
