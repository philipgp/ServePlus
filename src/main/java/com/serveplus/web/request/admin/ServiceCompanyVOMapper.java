package com.serveplus.web.request.admin;

import com.serveplus.data.entity.CompanyService;
import com.serveplus.web.response.customer.CompanyServiceVO;
import com.serveplus.web.response.mapper.Mapper;

public class ServiceCompanyVOMapper implements Mapper<CompanyService,CompanyServiceVO>{

	@Override
	public CompanyServiceVO mapFrom(CompanyService source) {
		CompanyServiceVO serviceCompany = new CompanyServiceVO();
		serviceCompany.setServiceId(source.getService().getId());
		serviceCompany.setServiceName(source.getService().getName());
		return serviceCompany;
	}

}
