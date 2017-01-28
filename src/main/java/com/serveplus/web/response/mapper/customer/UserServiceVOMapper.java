package com.serveplus.web.response.mapper.customer;

import com.serveplus.data.entity.Service;
import com.serveplus.web.response.customer.UserServiceVO;
import com.serveplus.web.response.mapper.Mapper;

public class UserServiceVOMapper implements Mapper<Service,UserServiceVO>{

	@Override
	public UserServiceVO mapFrom(Service source) {
		UserServiceVO userService = new  UserServiceVO();
		userService.setId(source.getId());
		userService.setName(source.getName());
		return userService;
	}

}
