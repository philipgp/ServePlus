package com.serveplus.web.response.mapper.customer;

import com.serveplus.data.entity.Customer;
import com.serveplus.web.response.customer.CustomerRegisterResponse;
import com.serveplus.web.response.mapper.Mapper;

public class CustomerResponseMapper implements Mapper<Customer,CustomerRegisterResponse>{

	@Override
	public CustomerRegisterResponse mapFrom(Customer source) {
		CustomerRegisterResponse response = new CustomerRegisterResponse();
		response.setCustomerId(source.getId());
		return response;
	}

}
