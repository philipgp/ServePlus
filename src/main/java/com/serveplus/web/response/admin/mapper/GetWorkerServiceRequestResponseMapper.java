package com.serveplus.web.response.admin.mapper;

import java.util.List;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.response.admin.AdminGetAllServiceRequestResponse;
import com.serveplus.web.response.admin.AdminServiceRequestVO;
import com.serveplus.web.response.admin.GetForCustomerServiceRequestResponse;
import com.serveplus.web.response.admin.GetForWorkerServiceRequestResponse;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.Mapper;

public class GetWorkerServiceRequestResponseMapper implements Mapper<List<ServiceRequest>,GetForWorkerServiceRequestResponse>{

	@Override
	public GetForWorkerServiceRequestResponse mapFrom(List<ServiceRequest> source) {
		GetForWorkerServiceRequestResponse response = new  GetForWorkerServiceRequestResponse();
		ListToListMapper<ServiceRequest,AdminServiceRequestVO> lsitMapper = new ListToListMapper<ServiceRequest, AdminServiceRequestVO>();;
		List<AdminServiceRequestVO> mappedList = lsitMapper.mapFrom(source, new AdminServiceRequestVOMapper());
		response.setServiceRequests(mappedList);
		return response;
	}

}
