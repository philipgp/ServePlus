package com.serveplus.web.response.admin.mapper;

import java.util.List;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.response.admin.AdminGetAllServiceRequestResponse;
import com.serveplus.web.response.admin.AdminServiceRequestVO;
import com.serveplus.web.response.admin.GetForCustomerServiceRequestResponse;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.Mapper;

public class GetCustomerServiceRequestResponseMapper implements Mapper<List<ServiceRequest>,GetForCustomerServiceRequestResponse>{

	@Override
	public GetForCustomerServiceRequestResponse mapFrom(List<ServiceRequest> source) {
		GetForCustomerServiceRequestResponse response = new  GetForCustomerServiceRequestResponse();
		ListToListMapper<ServiceRequest,AdminServiceRequestVO> lsitMapper = new ListToListMapper<ServiceRequest, AdminServiceRequestVO>();;
		List<AdminServiceRequestVO> mappedList = lsitMapper.mapFrom(source, new AdminServiceRequestVOMapper());
		response.setServiceRequests(mappedList);
		return response;
	}

}
