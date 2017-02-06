package com.serveplus.web.response.admin.mapper;

import java.util.List;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.response.admin.AdminGetAllServiceRequestResponse;
import com.serveplus.web.response.admin.AdminServiceRequestVO;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.Mapper;

public class AdminGetAllServiceRequestResponseMapper implements Mapper<List<ServiceRequest>,AdminGetAllServiceRequestResponse>{

	@Override
	public AdminGetAllServiceRequestResponse mapFrom(List<ServiceRequest> source) {
		AdminGetAllServiceRequestResponse response = new  AdminGetAllServiceRequestResponse();
		ListToListMapper<ServiceRequest,AdminServiceRequestVO> lsitMapper = new ListToListMapper<ServiceRequest, AdminServiceRequestVO>();;
		List<AdminServiceRequestVO> mappedList = lsitMapper.mapFrom(source, new AdminServiceRequestVOMapper());
		response.setServiceRequests(mappedList);
		return response;
	}

}
