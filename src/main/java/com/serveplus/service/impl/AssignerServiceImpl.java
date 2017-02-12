package com.serveplus.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.AssignerDao;
import com.serveplus.data.dao.CompanyDao;
import com.serveplus.data.dao.CompanyServiceDao;
import com.serveplus.data.dao.CsAssignerDao;
import com.serveplus.data.dao.ServiceDao;
import com.serveplus.data.dao.ServiceRequestDao;
import com.serveplus.data.dao.WorkerDao;
import com.serveplus.data.dao.WorkerServiceDao;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.CsAssigner;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.ServiceRequestStatus;
import com.serveplus.data.entity.SrActionHistory;
import com.serveplus.data.entity.Worker;
import com.serveplus.data.entity.WorkerService;
import com.serveplus.mapper.SrActionHistoryMapper;
import com.serveplus.service.AssignerService;
import com.serveplus.web.request.AssignerWorkAssignRequest;
import com.serveplus.web.request.GetWorksToAssignRequest;
import com.serveplus.web.request.assigner.GetWorkerForServiceRequest;
import com.serveplus.web.response.assigner.AssignerWorkAssignResponse;
import com.serveplus.web.response.assigner.GetWorksToAssignResponse;
import com.serveplus.web.response.assigner.mapper.GetWorkerForServiceResponseMapper;
import com.serveplus.web.response.assigner.mapper.GetWorksToAssignResponseMapper;
import com.serveplus.web.response.auth.GetWorkerForServiceResponse;


@Component
public class AssignerServiceImpl implements AssignerService{

	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	ServiceDao serviceDao;
	
	@Autowired
	CompanyServiceDao companyServiceDao;
	
	@Autowired
	WorkerServiceDao workerServiceDao;
	
	@Autowired
	ServiceRequestDao serviceRequestDao;
	
	@Autowired
	AssignerDao assignerDao;
	
	@Autowired
	CsAssignerDao csAssignerDao;
	
	@Autowired
	WorkerDao workerDao;
	
	
	@Override
	public GetWorkerForServiceResponse getWorkerForService(
			GetWorkerForServiceRequest request) {
		GetWorkerForServiceResponse response = null;
		Company company = companyDao.findById(request.getCompanyId());
		Service service = serviceDao.findById(request.getServiceId());
		if(service!=null && company != null){
			List<WorkerService> workerServices = workerServiceDao.findWorkerService(company, service);
			GetWorkerForServiceResponseMapper mapper = new  GetWorkerForServiceResponseMapper();
			 response = mapper.mapFrom(workerServices);
			
			}
		
		return response;
	}


	@Override
	public GetWorksToAssignResponse getWorksToAssign(
			GetWorksToAssignRequest request) {
		Assigner assigner = assignerDao.findById(request.getAssignerId());
		List<Long> companyServices = new ArrayList<Long>();
		if(assigner.getAdmin()!=null){
			Company company = companyDao.findById(request.getCompanyId());
			List<CompanyService> companyServicesList = companyServiceDao.findBy(company);
			if(companyServicesList!=null){
				for(CompanyService companyService:companyServicesList){
					companyServices.add(companyService.getId());
				}
			}
		}else{
			List<CsAssigner> csAssigners = csAssignerDao.findByAssigner(assigner);
			if(csAssigners!=null){
				for(CsAssigner csAssigner:csAssigners){
					companyServices.add(csAssigner.getCsAssignerId().getCompanyService().getId());
				}
			}
		}
		List<ServiceRequest> serviceRequests = serviceRequestDao.getServiceRequestsForAssigner(companyServices);
		
		GetWorksToAssignResponseMapper responseMapper = new GetWorksToAssignResponseMapper();
		GetWorksToAssignResponse response = responseMapper.mapFrom(serviceRequests);
		return response;
	}


	@Override
	public AssignerWorkAssignResponse assignWork(
			AssignerWorkAssignRequest request) {
		Assigner assigner = assignerDao.findById(request.getAssignerId());
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestById(request.getServiceRequestId());
		Worker worker = workerDao.findById(request.getWorkerId());
		serviceRequest.setAssigner(assigner);
		serviceRequest.setWorker(worker);
		serviceRequest.setStatus(ServiceRequestStatus.ASSIGNED);
		SrActionHistoryMapper srActionHistoryMapper = new SrActionHistoryMapper();
		SrActionHistory srAction = srActionHistoryMapper.mapFrom(serviceRequest);
		serviceRequest.addAction(srAction);
		serviceRequestDao.save(serviceRequest);
		
		AssignerWorkAssignResponse assignWorkresponse = new AssignerWorkAssignResponse();
		assignWorkresponse.setStatus(Boolean.TRUE);
		return assignWorkresponse;
	}

}
