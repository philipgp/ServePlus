package com.serveplus.web.response.admin.mapper;

import java.util.List;

import com.serveplus.data.entity.Customer;
import com.serveplus.web.response.admin.GetAllCustomerSummaryResponse;
import com.serveplus.web.response.customer.CustomerSummaryVO;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.customer.CustomerSummaryVOMapper;

public class GetAllCustomerSummaryResponseMapper implements Mapper<List<Customer>,GetAllCustomerSummaryResponse>{

	@Override
	public GetAllCustomerSummaryResponse mapFrom(List<Customer> source) {
		GetAllCustomerSummaryResponse response = new GetAllCustomerSummaryResponse();
		ListToListMapper<Customer,CustomerSummaryVO> listMapper= new ListToListMapper<>();
		List<CustomerSummaryVO> mappedList = listMapper.mapFrom(source, new CustomerSummaryVOMapper());
		response.setSummaries(mappedList);
		return response;
	}

}
