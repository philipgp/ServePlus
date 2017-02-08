package com.serveplus.web.request.admin;

import com.serveplus.data.entity.CompanyService;
import com.serveplus.web.response.mapper.Mapper;

public class UpdateCompanyServiceMapper implements Mapper<UpdateCompanyServiceRequest,CompanyService>{
	private CompanyService companyService;
	
	public UpdateCompanyServiceMapper(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}

	@Override
	public CompanyService mapFrom(UpdateCompanyServiceRequest source) {
		// TODO Auto-generated method stub
		if(source.getActive()!=null)
			companyService.setActive(source.getActive());
		return companyService;
	}

}
