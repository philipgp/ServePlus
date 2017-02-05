package com.serveplus.web.response.customer;

import com.serveplus.data.entity.Company;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.register.RegisterCompanyResponse;

public class RegisterCompanyResponseMapper implements Mapper<Company,RegisterCompanyResponse>{

	@Override
	public RegisterCompanyResponse mapFrom(Company source) {
		RegisterCompanyResponse registerCompanyResponse = new RegisterCompanyResponse();
		registerCompanyResponse.setCompanyId(source.getId());
		return registerCompanyResponse;
	} 
 
}
