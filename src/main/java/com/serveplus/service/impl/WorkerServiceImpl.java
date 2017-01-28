package com.serveplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.ServiceRequestDao;
import com.serveplus.data.dao.WorkerDao;
import com.serveplus.data.entity.Payment;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.ServiceRequestStatus;
import com.serveplus.data.entity.SrAction;
import com.serveplus.data.entity.SrActionHistory;
import com.serveplus.data.entity.Worker;
import com.serveplus.mapper.SrActionHistoryMapper;
import com.serveplus.service.WorkerService;
import com.serveplus.web.request.PaymentVO;
import com.serveplus.web.request.worker.GetAssignedWorkRequest;
import com.serveplus.web.request.worker.StartWorkRequest;
import com.serveplus.web.request.worker.WorkClosedRequest;
import com.serveplus.web.request.worker.WorkCompletedRequest;
import com.serveplus.web.request.worker.WorkerServiceRequestDetailRequest;
import com.serveplus.web.response.mapper.worker.CompletedWorkResponseMapper;
import com.serveplus.web.response.mapper.worker.GetAssignedWorkResponseMapper;
import com.serveplus.web.response.mapper.worker.StartWorkResponseMapper;
import com.serveplus.web.response.mapper.worker.WorkClosedResponseMapper;
import com.serveplus.web.response.mapper.worker.WorkerServiceRequestDetailResponseMapper;
import com.serveplus.web.response.worker.GetAssignedWorkResponse;
import com.serveplus.web.response.worker.StartWorkResponse;
import com.serveplus.web.response.worker.WorkClosedResponse;
import com.serveplus.web.response.worker.WorkCompletedResponse;
import com.serveplus.web.response.worker.WorkerServiceRequestDetailResponse;

@Component
public class WorkerServiceImpl implements WorkerService{

	@Autowired
	ServiceRequestDao serviceRequestDao;
	
	@Autowired
	WorkerDao workerDao;
	
	@Override
	public GetAssignedWorkResponse getAssignedWorks(
			GetAssignedWorkRequest request) {
		List<ServiceRequest> serviceRequests = serviceRequestDao.getServiceRequestsByWorkerId(request.getWorkerId());
		GetAssignedWorkResponseMapper mapper = new GetAssignedWorkResponseMapper();
		GetAssignedWorkResponse mappedResponse = mapper.mapFrom(serviceRequests);
		return mappedResponse;
	}


	
	@Override
	public StartWorkResponse startWork(StartWorkRequest request) {
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestById(request.getServiceRequestId());
		Worker worker = workerDao.findById(request.getWorkerId());
		serviceRequest.setWorker(worker);
		serviceRequest.setStatus(ServiceRequestStatus.STARTED);
		SrActionHistoryMapper sractionMapper = new SrActionHistoryMapper();
		SrActionHistory actionHistory = sractionMapper.mapFrom(serviceRequest);
		
		serviceRequest.addAction(actionHistory);
		serviceRequestDao.save(serviceRequest);
		StartWorkResponseMapper responseMapper = new StartWorkResponseMapper();
		StartWorkResponse response = responseMapper.mapFrom(serviceRequest);
		return response;
	}


	@Override
	public WorkCompletedResponse completedWork(WorkCompletedRequest request) {
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestById(request.getServiceRequestId());
		Worker worker = workerDao.findById(request.getWorkerId());
		serviceRequest.setWorker(worker);
		serviceRequest.setStatus(ServiceRequestStatus.COMPLETED);
		SrActionHistoryMapper sractionMapper = new SrActionHistoryMapper();
		SrActionHistory actionHistory = sractionMapper.mapFrom(serviceRequest);
		serviceRequest.addAction(actionHistory);
		serviceRequestDao.save(serviceRequest);
		CompletedWorkResponseMapper responseMapper = new CompletedWorkResponseMapper();
		WorkCompletedResponse response = responseMapper.mapFrom(serviceRequest); 
		return response;
	}


	@Override
	public WorkClosedResponse closeWork(WorkClosedRequest request) {
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestById(request.getServiceRequestId());
		Worker worker = workerDao.findById(request.getWorkerId());
		serviceRequest.setWorker(worker);
		serviceRequest.setStatus(ServiceRequestStatus.CLOSED);
		SrActionHistoryMapper sractionMapper = new SrActionHistoryMapper();
		SrActionHistory actionHistory = sractionMapper.mapFrom(serviceRequest);
		serviceRequest.addAction(actionHistory);
		PaymentVO paymentVO = request.getPayment();
		if(paymentVO!=null){
			Payment payment = new Payment();
			payment.setAmount(paymentVO.getAmount());
			payment.setStatus(paymentVO.getPaymentStatus());
			payment.setType(paymentVO.getPaymentType());
			payment.setCurrency(paymentVO.getCurrency());
			serviceRequest.setPayment(payment);
		}
		serviceRequestDao.save(serviceRequest);
		WorkClosedResponseMapper responseMapper = new WorkClosedResponseMapper();
		WorkClosedResponse response = responseMapper.mapFrom(serviceRequest); 
		return response;
	}


	@Override
	public WorkerServiceRequestDetailResponse getServiceRequestDetail(
			WorkerServiceRequestDetailRequest request) {
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestById(request.getServiceRequestId());
		WorkerServiceRequestDetailResponseMapper mapper = new WorkerServiceRequestDetailResponseMapper();
		WorkerServiceRequestDetailResponse response = mapper.mapFrom(serviceRequest);
		return response;
	}
	
}
