package com.serveplus.web.response.mapper.customer;

import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.User;
import com.serveplus.web.response.customer.CustomerSummaryVO;
import com.serveplus.web.response.mapper.Mapper;

public class CustomerSummaryVOMapper implements Mapper<Customer,CustomerSummaryVO>{

	@Override
	public CustomerSummaryVO mapFrom(Customer source) {
		CustomerSummaryVO customerSummary = new CustomerSummaryVO();
		User user = source.getUser();
		customerSummary.setFirstName(user.getFirstName());
		customerSummary.setMiddleName(user.getMiddleName());
		customerSummary.setLastName(user.getLastName());
		return customerSummary;
	}

}
