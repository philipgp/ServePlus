package com.serveplus.web.response.customer;

import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyAddress;
import com.serveplus.data.entity.User;
import com.serveplus.data.entity.UserAddress;
import com.serveplus.mapper.AddressVOMapper;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.response.mapper.Mapper;

public class CompanyAddressMapper implements Mapper<AddressVO,CompanyAddress>{
	 
	private Company company;
	
	public CompanyAddressMapper(Company company) {
		super();
		this.company = company;
	}

	public CompanyAddress mapFrom(AddressVO companyAddressVO){
		
		AddressVOMapper addressVOMapper = new AddressVOMapper();
		Address address = addressVOMapper.mapFrom(companyAddressVO);
		CompanyAddress companyAddress = new CompanyAddress();
		companyAddress.setCompany(company);
		companyAddress.setAddress(address);
		return companyAddress;
		/*AddressMapper addressMapper = new AddressMapper();
		AddressVO addressVO = addressMapper.mapFrom(userAddress.getUserAddressId().getAddress());
	//	setValues(address, userAddress.getUserAddressId().getAddress());
		addressVO.setPrimary(userAddress.getIsDefault());
		addressVO.setActive(userAddress.getActive());
		return addressVO;*/
	}
}
