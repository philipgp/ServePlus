package com.serveplus.web.response.customer;

import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.Location;
import com.serveplus.data.entity.User;
import com.serveplus.data.entity.UserAddress;
import com.serveplus.mapper.AddressVOMapper;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.LocationMapper;
import com.serveplus.web.response.AddressMapper;
import com.serveplus.web.response.LocationVO;
import com.serveplus.web.response.mapper.Mapper;

public class UserAddressMapper implements Mapper<AddressVO,UserAddress>{
	 
	private User user;
	
	public UserAddressMapper(User user) {
		super();
		this.user = user;
	}

	public UserAddress mapFrom(AddressVO userAddressVO){
		
		AddressVOMapper addressVOMapper = new AddressVOMapper();
		Address address = addressVOMapper.mapFrom(userAddressVO);
		UserAddress userAddress = new UserAddress();
		userAddress.setUser(user);
		userAddress.setAddress(address);
		return userAddress;
		/*AddressMapper addressMapper = new AddressMapper();
		AddressVO addressVO = addressMapper.mapFrom(userAddress.getUserAddressId().getAddress());
	//	setValues(address, userAddress.getUserAddressId().getAddress());
		addressVO.setPrimary(userAddress.getIsDefault());
		addressVO.setActive(userAddress.getActive());
		return addressVO;*/
	}
}
