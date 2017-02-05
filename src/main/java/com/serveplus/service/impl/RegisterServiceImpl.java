package com.serveplus.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.CompanyDao;
import com.serveplus.data.entity.Company;
import com.serveplus.service.RegisterService;
import com.serveplus.vo.MailVO;
import com.serveplus.web.request.company.CompanyMapper;
import com.serveplus.web.request.register.RegisterCompanyRequest;
import com.serveplus.web.response.customer.RegisterCompanyResponseMapper;
import com.serveplus.web.response.register.RegisterCompanyResponse;

@Component
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	CompanyDao companyDao;
	
	
	@Override
	public RegisterCompanyResponse registerCompany(
			RegisterCompanyRequest request) {
		CompanyMapper companyMapper = new CompanyMapper();
		Company company = companyMapper.mapFrom(request);
		companyDao.save(company);
		
		/*MailVO mailVO = new MailVO();
		mailVO.setFrom("vineeth5march1990@gmail.com");
		mailVO.setTemplateFile("registration_code.vm"); 
		mailVO.setSubject("ServePlus Registration");
		mailVO.setTo("ppanickar@qatarairways.com.qa");
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("otp",loginCredentials.getRegnOtpId().getCode());
		mailVO.setMap(map);
		servePlusMailService.sendMail(mailVO);*/
		
		RegisterCompanyResponseMapper responseMapper = new RegisterCompanyResponseMapper();
		RegisterCompanyResponse response = responseMapper.mapFrom(company);
		return response;
	}

}
