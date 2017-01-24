package com.serveplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.ServiceRequestDao;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.ServiceRequestStatus;
import com.serveplus.data.entity.SrAction;
import com.serveplus.data.entity.SrActionHistory;
import com.serveplus.service.WorkerService;
import com.serveplus.web.request.GetAssignedWorkRequest;
import com.serveplus.web.request.StartWorkRequest;
import com.serveplus.web.response.GetAssignedWorkResponse;
import com.serveplus.web.response.StartWorkResponse;
import com.serveplus.web.response.mapper.GetAssignedWorkResponseMapper;

@Component
public class WorkerServiceImpl implements WorkerService{

	@Autowired
	ServiceRequestDao serviceRequestDao;
	
	
	@Override
	public GetAssignedWorkResponse getAssignedWorks(
			GetAssignedWorkRequest request) {
		List<ServiceRequest> serviceRequests = serviceRequestDao.getServiceRequestsByWorkerId(request.getWorkerId());
		GetAssignedWorkResponseMapper mapper = new GetAssignedWorkResponseMapper();
		GetAssignedWorkResponse mappedResponse = mapper.mapFrom(serviceRequests);
		return mappedResponse;
	}


	private SrActionHistory getActionHistory(ServiceRequest serviceRequest,ServiceRequestStatus newStatus){
		SrActionHistory actionHistory = new SrActionHistory();
		actionHistory.setServiceRequest(serviceRequest);
		SrAction action = SrAction.getActionStatus(serviceRequest.getStatus(), newStatus);
		actionHistory.setAction(action);
		return actionHistory;
	}
	@Override
	public StartWorkResponse startWork(StartWorkRequest request) {
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestById(request.getRegnId());
		SrActionHistory actionHistory = getActionHistory(serviceRequest,ServiceRequestStatus.STARTED);
		serviceRequest.addAction(actionHistory);
		serviceRequest.setStatus(ServiceRequestStatus.STARTED);
		serviceRequestDao.save(serviceRequest);
		return null;
	}
	
}
