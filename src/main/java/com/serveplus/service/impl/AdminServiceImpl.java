package com.serveplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.ServiceRequestDao;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.service.AdminService;
import com.serveplus.web.request.admin.AdminGetAllServiceRequestRequest;
import com.serveplus.web.request.admin.GetCustomerServiceRequestRequest;
import com.serveplus.web.request.admin.GetWorkerServiceRequestRequest;
import com.serveplus.web.response.admin.AdminGetAllServiceRequestResponse;
import com.serveplus.web.response.admin.GetForCustomerServiceRequestResponse;
import com.serveplus.web.response.admin.GetForWorkerServiceRequestResponse;
import com.serveplus.web.response.admin.mapper.AdminGetAllServiceRequestResponseMapper;
import com.serveplus.web.response.admin.mapper.GetCustomerServiceRequestResponseMapper;
import com.serveplus.web.response.admin.mapper.GetWorkerServiceRequestResponseMapper;

@Component
public class AdminServiceImpl implements AdminService {

	@Autowired
	ServiceRequestDao serviceRequestDao;
	
	@Override
	public AdminGetAllServiceRequestResponse getAllServiceRequests(
			AdminGetAllServiceRequestRequest request) {
		List<ServiceRequest> serviceRequests = serviceRequestDao.getAll();
		AdminGetAllServiceRequestResponseMapper responseMapper  = new AdminGetAllServiceRequestResponseMapper();
		AdminGetAllServiceRequestResponse response = responseMapper.mapFrom(serviceRequests);
		//AdminServiceRequestVOMapper
		return response;
	}

	@Override
	public GetForCustomerServiceRequestResponse getCustomerServiceRequest(
			GetCustomerServiceRequestRequest request) {
		List<ServiceRequest> serviceRequests = serviceRequestDao.getServiceRequestsByCustomerId(request.getCustomerId());
		GetCustomerServiceRequestResponseMapper responseMapper  = new GetCustomerServiceRequestResponseMapper();
		GetForCustomerServiceRequestResponse response = responseMapper.mapFrom(serviceRequests);
		return response;
	}

	@Override
	public GetForWorkerServiceRequestResponse getWorkerServiceRequests(
			GetWorkerServiceRequestRequest request) {
		List<ServiceRequest> serviceRequests = serviceRequestDao.getServiceRequestsByWorkerId(request.getWorkerId());
		GetWorkerServiceRequestResponseMapper responseMapper  = new GetWorkerServiceRequestResponseMapper();
		GetForWorkerServiceRequestResponse response = responseMapper.mapFrom(serviceRequests);
		return response;
	}

}
