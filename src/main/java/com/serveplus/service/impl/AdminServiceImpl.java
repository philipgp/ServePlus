package com.serveplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.AdminDao;
import com.serveplus.data.dao.AssignerDao;
import com.serveplus.data.dao.CompanyDao;
import com.serveplus.data.dao.CompanyServiceDao;
import com.serveplus.data.dao.CsAssignerDao;
import com.serveplus.data.dao.CustomerDao;
import com.serveplus.data.dao.ServiceDao;
import com.serveplus.data.dao.ServiceRequestDao;
import com.serveplus.data.dao.WorkerDao;
import com.serveplus.data.dao.WorkerServiceDao;
import com.serveplus.data.entity.Admin;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.CsAssigner;
import com.serveplus.data.entity.CsAssignerId;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.Worker;
import com.serveplus.data.entity.WorkerService;
import com.serveplus.service.AdminService;
import com.serveplus.web.request.admin.AddNewAdminRequest;
import com.serveplus.web.request.admin.AddNewAssignerRequest;
import com.serveplus.web.request.admin.AddNewCSAssignerRequest;
import com.serveplus.web.request.admin.AddNewCompanyServiceRequest;
import com.serveplus.web.request.admin.AddNewServiceRequest;
import com.serveplus.web.request.admin.AddNewWorkerRequest;
import com.serveplus.web.request.admin.AddNewWorkerServiceRequest;
import com.serveplus.web.request.admin.AddWorkerServiceMapper;
import com.serveplus.web.request.admin.AdminGetAllServiceRequestRequest;
import com.serveplus.web.request.admin.AdminMapper;
import com.serveplus.web.request.admin.AssignerMapper;
import com.serveplus.web.request.admin.GetAllCustomerSummaryRequest;
import com.serveplus.web.request.admin.GetAllWorkersSummaryRequest;
import com.serveplus.web.request.admin.GetCustomerServiceRequestRequest;
import com.serveplus.web.request.admin.GetWorkerServiceRequestRequest;
import com.serveplus.web.request.admin.RemoveAssignerRequest;
import com.serveplus.web.request.admin.RemoveCompanyServiceRequest;
import com.serveplus.web.request.admin.RemoveCsAssignerRequest;
import com.serveplus.web.request.admin.RemoveServiceRequest;
import com.serveplus.web.request.admin.RemoveWorkerRequest;
import com.serveplus.web.request.admin.RemoveWorkerServiceRequest;
import com.serveplus.web.request.admin.UpdateAssignerMapper;
import com.serveplus.web.request.admin.UpdateAssignerRequest;
import com.serveplus.web.request.admin.UpdateCompanyServiceMapper;
import com.serveplus.web.request.admin.UpdateCompanyServiceRequest;
import com.serveplus.web.request.admin.UpdateCsAssigneMapper;
import com.serveplus.web.request.admin.UpdateCsAssigneRequest;
import com.serveplus.web.request.admin.UpdateWorkerMapper;
import com.serveplus.web.request.admin.UpdateWorkerRequest;
import com.serveplus.web.request.admin.UpdateWorkerServiceMapper;
import com.serveplus.web.request.admin.UpdateWorkerServiceRequest;
import com.serveplus.web.request.admin.WorkerMapper;
import com.serveplus.web.response.admin.AddNewAdminResponse;
import com.serveplus.web.response.admin.AddNewAdminResponseMapper;
import com.serveplus.web.response.admin.AddNewAssignerResponse;
import com.serveplus.web.response.admin.AddNewAssignerResponseMapper;
import com.serveplus.web.response.admin.AddNewCompanyServiceResponse;
import com.serveplus.web.response.admin.AddNewCsAssignerResponse;
import com.serveplus.web.response.admin.AddNewServiceResponse;
import com.serveplus.web.response.admin.AddNewWorkerResponse;
import com.serveplus.web.response.admin.AddNewWorkerResponseMapper;
import com.serveplus.web.response.admin.AdminGetAllServiceRequestResponse;
import com.serveplus.web.response.admin.BooleanResponse;
import com.serveplus.web.response.admin.GetAllCustomerSummaryResponse;
import com.serveplus.web.response.admin.GetAllWorkersSummaryResponse;
import com.serveplus.web.response.admin.GetForCustomerServiceRequestResponse;
import com.serveplus.web.response.admin.GetForWorkerServiceRequestResponse;
import com.serveplus.web.response.admin.mapper.AdminGetAllServiceRequestResponseMapper;
import com.serveplus.web.response.admin.mapper.GetAllCustomerSummaryResponseMapper;
import com.serveplus.web.response.admin.mapper.GetAllWorkersSummaryResponseMapper;
import com.serveplus.web.response.admin.mapper.GetCustomerServiceRequestResponseMapper;
import com.serveplus.web.response.admin.mapper.GetWorkerServiceRequestResponseMapper;

@Component
public class AdminServiceImpl implements AdminService {

	@Autowired
	ServiceRequestDao serviceRequestDao;
	
	@Autowired
	WorkerDao workerDao;
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ServiceDao serviceDao;
	
	@Autowired
	CompanyServiceDao companyServiceDao;
	
	@Autowired
	WorkerServiceDao workerServiceDao;
	
	@Autowired
	AssignerDao assignerDao;
	
	@Autowired
	CsAssignerDao csAssignerDao;
	
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

	@Override
	public GetAllWorkersSummaryResponse getAllWorkersSummary(GetAllWorkersSummaryRequest request) {
		List<Worker> workers = null;
		if(request.getCompanyId()==null)
			workers = workerDao.getAll();
		else{
			Company company = companyDao.findById(request.getCompanyId());
			workers=workerDao.getAllFromCompany(company);
		}
		GetAllWorkersSummaryResponseMapper responseMapper = new GetAllWorkersSummaryResponseMapper();
		GetAllWorkersSummaryResponse response = responseMapper.mapFrom(workers);
		//WorkerSummaryVOMapper
		return response;
	}

	@Override
	public GetAllCustomerSummaryResponse getALlCustomerSummary(GetAllCustomerSummaryRequest request) {
		List<Customer> customers = customerDao.getAll(); 
		GetAllCustomerSummaryResponseMapper mapper = new GetAllCustomerSummaryResponseMapper();
		GetAllCustomerSummaryResponse response = mapper.mapFrom(customers);
		return response;
	}

	@Override
	public AddNewServiceResponse addNewService(AddNewServiceRequest request) {
		Service service = new Service();
		service.setName(request.getServiceName());
		serviceDao.save(service);
		AddNewServiceResponse response = new AddNewServiceResponse();
		response.setServiceId(service.getId());
		return response;
	}

	@Override
	public AddNewCompanyServiceResponse addNewCompanyService(AddNewCompanyServiceRequest request) {
		Company company = companyDao.findById(request.getCompanyId());
		Service service = serviceDao.findById(request.getServiceId());
		CompanyService companyService = new CompanyService();
		companyService.setCompany(company);
		companyService.setService(service);
		companyService.setActive(Boolean.TRUE);
		companyServiceDao.save(companyService);
		AddNewCompanyServiceResponse response = new AddNewCompanyServiceResponse();
		return response;
	}

	@Override
	public AddNewCsAssignerResponse addNewCsAssigner(AddNewCSAssignerRequest request) {
		Company company = companyDao.findById(request.getCompanyId());
		Service service = serviceDao.findById(request.getServiceId());
		 Assigner assigner = assignerDao.findById(request.getAssignerId());
		CompanyService companyService = companyServiceDao.findBy(company, service);
		CsAssigner csAssigner = new CsAssigner();
		CsAssignerId csAssignerId = new CsAssignerId();
		csAssignerId.setAssigner(assigner);
		csAssignerId.setCompanyService(companyService);
		csAssigner.setCsAssignerId(csAssignerId);
		csAssignerDao.save(csAssigner);
		AddNewCsAssignerResponse response = new AddNewCsAssignerResponse();
		return response;
	}

	@Override
	public AddNewAssignerResponse addNewAssigner(AddNewAssignerRequest request) {
		Company company = companyDao.findById(request.getCompanyId());
		AssignerMapper assignerMapper = new AssignerMapper(company);
		Assigner assigner = assignerMapper.mapFrom(request);
		assignerDao.save(assigner);
		AddNewAssignerResponseMapper responseMapper = new AddNewAssignerResponseMapper();
		AddNewAssignerResponse response = responseMapper.mapFrom(assigner);
		return response;
	}

	@Override
	public AddNewAdminResponse addNewAdmin(AddNewAdminRequest request) {
		Company company = companyDao.findById(request.getCompanyId());
		AdminMapper assignerMapper = new AdminMapper(company);
		Admin admin = assignerMapper.mapFrom(request);
		adminDao.save(admin);
		company.setAdmin(admin);
		companyDao.save(company);
		AddNewAdminResponseMapper responseMapper = new AddNewAdminResponseMapper();
		AddNewAdminResponse response = responseMapper.mapFrom(admin);
		return response;
	}

	@Override
	public BooleanResponse removeAssigner(RemoveAssignerRequest request) {
		Assigner assigner = assignerDao.findById(request.getAssignerId());
		assignerDao.remove(assigner);
		BooleanResponse response = new BooleanResponse(true);
		return response;
	}

	@Override
	public BooleanResponse removeCompanyService(RemoveCompanyServiceRequest request) {
		Company company = companyDao.findById(request.getCompanyId());
		Service service = serviceDao.findById(request.getServiceId());
		CompanyService companyService = companyServiceDao.findBy(company, service);
		companyServiceDao.remove(companyService);
		BooleanResponse response = new BooleanResponse(true);
		return response;
	}

	@Override
	public BooleanResponse removeCsAssigner(RemoveCsAssignerRequest request) {
		Company company = companyDao.findById(request.getCompanyId());
		Service service = serviceDao.findById(request.getServiceId());
		Assigner assigner = assignerDao.findById(request.getAssignerId());
		CompanyService companyService = companyServiceDao.findBy(company, service);
		CsAssigner csAssigner = csAssignerDao.findBy(companyService,assigner);
		csAssignerDao.remove(csAssigner);
		BooleanResponse response = new BooleanResponse(true);
		return response;
	}

	@Override
	public BooleanResponse removeService(RemoveServiceRequest request) {
		Service service = serviceDao.findById(request.getServiceId());
		serviceDao.remove(service);
		BooleanResponse response = new BooleanResponse(true);
		return response;
	}

	@Override
	public BooleanResponse removeWorker(RemoveWorkerRequest request) {
		Worker worker = workerDao.findById(request.getWorkerId());
		workerDao.remove(worker);
		BooleanResponse response = new BooleanResponse(true);
		return response;
	}

	@Override
	public BooleanResponse updateWorker(UpdateWorkerRequest request) {
		Worker worker = workerDao.findById(request.getWorkerId());
		UpdateWorkerMapper updateWorkerMapper = new UpdateWorkerMapper(worker);
		worker = updateWorkerMapper.mapFrom(request);
		workerDao.save(worker);
		BooleanResponse response = new BooleanResponse(true);
		return response;
	}

	@Override
	public AddNewWorkerResponse addNewWorker(AddNewWorkerRequest request) {
		Company company = companyDao.findById(request.getCompanyId());
		WorkerMapper assignerMapper = new WorkerMapper(company);
		Worker worker = assignerMapper.mapFrom(request);
		workerDao.save(worker); 
		AddNewWorkerResponseMapper responseMapper = new AddNewWorkerResponseMapper();
		AddNewWorkerResponse response = responseMapper.mapFrom(worker);
		return response;
	}

	@Override
	public BooleanResponse updateAssigner(UpdateAssignerRequest request) {
		Assigner worker = assignerDao.findById(request.getAssignerId());
		UpdateAssignerMapper updateWorkerMapper = new UpdateAssignerMapper(worker);
		worker = updateWorkerMapper.mapFrom(request);
		BooleanResponse response = new BooleanResponse(true);
		return response;
	}

	@Override
	public BooleanResponse updateCompanyService(
			UpdateCompanyServiceRequest request) {
		Company company = companyDao.findById(request.getCompanyId());
		Service service = serviceDao.findById(request.getServiceId());
		CompanyService companyService = companyServiceDao.findBy(company, service);
		UpdateCompanyServiceMapper mapper = new UpdateCompanyServiceMapper(companyService);
		companyService = mapper.mapFrom(request);
		companyServiceDao.save(companyService);
		BooleanResponse response = new BooleanResponse(true);
		return response;
	}

	@Override
	public BooleanResponse updateCsAssigner(UpdateCsAssigneRequest request) {
		Company company = companyDao.findById(request.getCompanyId());
		Service service = serviceDao.findById(request.getServiceId());
		CompanyService companyService = companyServiceDao.findBy(company, service);
		Assigner assigner = assignerDao.findById(request.getAssignerId());
		CsAssigner csAssigner = csAssignerDao.findBy(companyService, assigner);
		UpdateCsAssigneMapper mapper = new UpdateCsAssigneMapper(csAssigner);
		csAssigner = mapper.mapFrom(request);
		csAssignerDao.save(csAssigner);
		BooleanResponse response = new BooleanResponse(true);
		return response;
	}

	@Override
	public BooleanResponse addNewWorkerService(
			AddNewWorkerServiceRequest request) {
		Company company = companyDao.findById(request.getCompanyId());
		Service service = serviceDao.findById(request.getServiceId());
		CompanyService companyService = companyServiceDao.findBy(company, service);
		Worker worker = workerDao.findById(request.getWorkerId());
		AddWorkerServiceMapper addWorkerServiceMapper = new AddWorkerServiceMapper(worker, service);
		WorkerService workerService = addWorkerServiceMapper.mapFrom(request);
		workerServiceDao.save(workerService);
		BooleanResponse response = new BooleanResponse(true);
		return response;
	}

	@Override
	public BooleanResponse updateWorkerService(
			UpdateWorkerServiceRequest request) {
		Company company = companyDao.findById(request.getCompanyId());
		Service service = serviceDao.findById(request.getServiceId());
		CompanyService companyService = companyServiceDao.findBy(company, service);
		Worker worker = workerDao.findById(request.getWorkerId());
		WorkerService workerService = workerServiceDao.findBy(service, worker);
		UpdateWorkerServiceMapper addWorkerServiceMapper = new UpdateWorkerServiceMapper(workerService);
		workerService = addWorkerServiceMapper.mapFrom(request);
		workerServiceDao.save(workerService);
		BooleanResponse response = new BooleanResponse(true);
		return response;
	}

	@Override
	public BooleanResponse removeWorkerService(
			RemoveWorkerServiceRequest removeWorkerServiceRequest) {
		Company company = companyDao.findById(removeWorkerServiceRequest.getCompanyId());
		Service service = serviceDao.findById(removeWorkerServiceRequest.getServiceId());
		Worker worker = workerDao.findById(removeWorkerServiceRequest.getWorkerId());
		WorkerService workerService = workerServiceDao.findBy(service, worker);
		workerServiceDao.remove(workerService);
		BooleanResponse response = new BooleanResponse(true);
		return response;
		
	}

}

