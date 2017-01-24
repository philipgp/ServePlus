package com.serveplus.web.response.mapper;

import java.util.List;

import com.serveplus.ResultCode;
import com.serveplus.ResultMessage;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.response.GetAssignedWorkResponse;
import com.serveplus.web.response.WorkVO;

public class GetAssignedWorkResponseMapper implements
		Mapper<List<ServiceRequest>, GetAssignedWorkResponse> {

	@Override
	public GetAssignedWorkResponse mapFrom(List<ServiceRequest> serviceRequests) {
		GetAssignedWorkResponse response = new GetAssignedWorkResponse();
		if (serviceRequests != null) {
			for (ServiceRequest serviceRequest : serviceRequests) {
				ServiceRequestToWorkMapper mapper = new ServiceRequestToWorkMapper();
				WorkVO work = mapper.mapFrom(serviceRequest);
				response.addWorkVO(work);
				response.setResultCode(ResultCode.SUCCESS.getCode());
				response.setMessage(ResultMessage.Success);
			}
		}
		return response;
	}

}
