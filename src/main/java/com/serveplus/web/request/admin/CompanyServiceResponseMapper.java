package com.serveplus.web.request.admin;

import java.util.List;
import java.util.Set;

import com.serveplus.data.entity.CompanyService;
import com.serveplus.web.response.customer.CompanyServiceResponse;
import com.serveplus.web.response.customer.CompanyServiceVO;
import com.serveplus.web.response.mapper.ListToSetMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.SetToSetMapper;

public class CompanyServiceResponseMapper implements Mapper<List<CompanyService>,CompanyServiceResponse>{

	@Override
	public CompanyServiceResponse mapFrom(List<CompanyService> source) {
		CompanyServiceResponse companyService = new CompanyServiceResponse();
		ListToSetMapper<CompanyService,CompanyServiceVO> setMapper = new ListToSetMapper<CompanyService, CompanyServiceVO>();
		Set<CompanyServiceVO> mappedList = setMapper.mapFrom(source, new ServiceCompanyVOMapper());
		companyService.setCompanyServices(mappedList);
		return companyService;
	}

}
