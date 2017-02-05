package com.serveplus.web.request.company;

import java.util.Set;

import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyAddress;
import com.serveplus.data.entity.CompanyContact;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.request.register.RegisterCompanyRequest;
import com.serveplus.web.response.customer.CompanyAddressMapper;
import com.serveplus.web.response.mapper.ListToSetMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.customer.CompanyContactMapper;

public class CompanyMapper implements Mapper<RegisterCompanyRequest,Company>{

	@Override
	public Company mapFrom(RegisterCompanyRequest source) {
		Company company = new Company();
		company.setName(source.getName());
		
		CompanyAddressMapper companyAddressMapper = new CompanyAddressMapper(company);
		ListToSetMapper<AddressVO,CompanyAddress> companyAddressSetmapper = new ListToSetMapper<AddressVO, CompanyAddress>();
		Set<CompanyAddress> companyAddresses = companyAddressSetmapper.mapFrom(source.getAddresses(), companyAddressMapper);
		company.setCompanyAddresses(companyAddresses);
		
		CompanyContactMapper companyContactMapper = new CompanyContactMapper(company);
		ListToSetMapper<ContactVO,CompanyContact> companyContactSetMapper = new ListToSetMapper<ContactVO,CompanyContact>();
		Set<CompanyContact> companyContacts = companyContactSetMapper.mapFrom(source.getContactInfos(), companyContactMapper);
		company.setCompanyContactDetails(companyContacts);
		
		
		
		return company;
	}

}
