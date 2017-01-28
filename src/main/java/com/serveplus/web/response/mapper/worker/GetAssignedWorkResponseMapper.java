package com.serveplus.web.response.mapper.worker;

import java.util.List;

import com.serveplus.ResultCode;
import com.serveplus.ResultMessage;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.response.ServiceRequestVO;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.worker.GetAssignedWorkResponse;

public class GetAssignedWorkResponseMapper implements
		Mapper<List<ServiceRequest>, GetAssignedWorkResponse> {

	@Override
	public GetAssignedWorkResponse mapFrom(List<ServiceRequest> serviceRequests) {
		GetAssignedWorkResponse response = new GetAssignedWorkResponse();
		if (serviceRequests != null) {
			for (ServiceRequest serviceRequest : serviceRequests) {
				ServiceRequestToWorkMapper mapper = new ServiceRequestToWorkMapper();
				ServiceRequestVO work = mapper.mapFrom(serviceRequest);
				response.addWorkVO(work);
				response.setResultCode(ResultCode.SUCCESS.getCode());
				response.setMessage(ResultMessage.Success);
			}
		}
		return response;
	}

}
