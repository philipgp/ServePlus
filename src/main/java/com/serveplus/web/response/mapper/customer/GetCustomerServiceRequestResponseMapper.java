package com.serveplus.web.response.mapper.customer;

import java.util.List;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.request.customer.CustomerServiceRequestVO;
import com.serveplus.web.response.customer.GetCustomerServiceRequestResponse;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.worker.ServiceRequestToWorkMapper;

public class GetCustomerServiceRequestResponseMapper implements Mapper<List<ServiceRequest>,GetCustomerServiceRequestResponse>{

	@Override
	public GetCustomerServiceRequestResponse mapFrom(List<ServiceRequest> source) {
		ServiceRequestForCustomerMapper serviceRequestMapper = new ServiceRequestForCustomerMapper();
		ListToListMapper<ServiceRequest, CustomerServiceRequestVO> listMapper = new ListToListMapper<ServiceRequest, CustomerServiceRequestVO>();
		List<CustomerServiceRequestVO> mappedList = listMapper.mapFrom(source, serviceRequestMapper);
		GetCustomerServiceRequestResponse response = new GetCustomerServiceRequestResponse();
		response.setServiceRequests(mappedList);
		return response;
	}

}
