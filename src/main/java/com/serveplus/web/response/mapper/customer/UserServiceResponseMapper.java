package com.serveplus.web.response.mapper.customer;

import java.util.List;

import com.serveplus.data.entity.Service;
import com.serveplus.web.response.customer.UserServiceResponse;
import com.serveplus.web.response.customer.UserServiceVO;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.Mapper;

public class UserServiceResponseMapper implements Mapper<List<Service>, UserServiceResponse>{

	@Override
	public UserServiceResponse mapFrom(List<Service> source) {
		ListToListMapper<Service, UserServiceVO> mapper = new ListToListMapper<Service, UserServiceVO>();
		List<UserServiceVO> userServiceVOs = mapper.mapFrom(source, new UserServiceVOMapper());
		UserServiceResponse response = new UserServiceResponse();
		response.setServices(userServiceVOs);
		return response;
	}

}
