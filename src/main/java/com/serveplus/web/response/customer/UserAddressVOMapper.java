package com.serveplus.web.response.customer;

import com.serveplus.data.entity.UserAddress;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.response.AddressMapper;
import com.serveplus.web.response.mapper.Mapper;

public class UserAddressVOMapper implements Mapper<UserAddress,AddressVO>{
	
	public AddressVO mapFrom(UserAddress userAddress){
		AddressMapper addressMapper = new AddressMapper();
		AddressVO addressVO = addressMapper.mapFrom(userAddress.getAddress());
	//	setValues(address, userAddress.getUserAddressId().getAddress());
		addressVO.setPrimary(userAddress.getIsDefault());
		addressVO.setActive(userAddress.getActive());
		return addressVO;
	}
}
