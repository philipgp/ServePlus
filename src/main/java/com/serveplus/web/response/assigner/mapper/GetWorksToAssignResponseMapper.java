package com.serveplus.web.response.assigner.mapper;

import java.util.List;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.response.assigner.AssignerWork;
import com.serveplus.web.response.assigner.GetWorksToAssignResponse;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.Mapper;

public class GetWorksToAssignResponseMapper implements Mapper<List<ServiceRequest>, GetWorksToAssignResponse>{

	@Override
	public GetWorksToAssignResponse mapFrom(List<ServiceRequest> source) {
		ListToListMapper<ServiceRequest,AssignerWork> lsitMapper = new ListToListMapper<ServiceRequest, AssignerWork>();
		List<AssignerWork> mappedList = lsitMapper.mapFrom(source, new AssignerWorkMapper());
		GetWorksToAssignResponse response = new GetWorksToAssignResponse();
		response.setWorks(mappedList);
		return response;
	}

	//AssignerWorkMapper
}
