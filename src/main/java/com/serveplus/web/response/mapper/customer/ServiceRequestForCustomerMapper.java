package com.serveplus.web.response.mapper.customer;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.response.customer.CustomerServiceRequestVO;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.worker.ServiceReqeuestBaseMapper;
import com.serveplus.web.response.mapper.worker.ServiceRequestToWorkMapper;

public class ServiceRequestForCustomerMapper extends ServiceReqeuestBaseMapper implements Mapper<ServiceRequest,CustomerServiceRequestVO>{

	@Override
	public CustomerServiceRequestVO mapFrom(ServiceRequest source) {
		CustomerServiceRequestVO customerServiceRequestVO = new CustomerServiceRequestVO();
		map(source, customerServiceRequestVO);
		return customerServiceRequestVO;
	}
	 
}
