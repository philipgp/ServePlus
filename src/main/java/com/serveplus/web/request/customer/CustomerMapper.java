package com.serveplus.web.request.customer;

import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.data.entity.User;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.customer.UserMapper;

public class CustomerMapper implements Mapper<CustomerRegisterRequest,Customer>{

	@Override
	public Customer mapFrom(CustomerRegisterRequest source) {
		Customer customer = new Customer();
		UserMapper userMapper = new UserMapper();
		User user = userMapper.mapFrom(source);
		LoginCredentialsMapper loginCredentialsMapper = new  LoginCredentialsMapper();
		LoginCredentials loginCredentials = loginCredentialsMapper.mapFrom(source); 
		user.setLoginCredentials(loginCredentials);
		customer.setUser(user);
		return customer;
	}

}
