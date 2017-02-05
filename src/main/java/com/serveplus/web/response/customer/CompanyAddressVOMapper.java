package com.serveplus.web.response.customer;

import com.serveplus.data.entity.CompanyAddress;
import com.serveplus.data.entity.UserAddress;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.response.AddressMapper;
import com.serveplus.web.response.mapper.Mapper;

public class CompanyAddressVOMapper implements Mapper<CompanyAddress,AddressVO>{
	
	public AddressVO mapFrom(CompanyAddress companyAddress){
		AddressMapper addressMapper = new AddressMapper();
		AddressVO addressVO = addressMapper.mapFrom(companyAddress.getAddress());
		addressVO.setPrimary(companyAddress.getIsDefault());
		addressVO.setActive(companyAddress.getActive());
		return addressVO;
	}
}
