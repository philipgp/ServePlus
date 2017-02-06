package com.serveplus.data.dao;

import java.util.List;

import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.User;

public interface ServiceRequestDao {
	
	public List<ServiceRequest> getServiceRequestsByWorkerId(Long workerId);
	public List<ServiceRequest> getServiceRequestsByCustomerId(Long customerId);
	public ServiceRequest getServiceRequestById(Long id);
	public void save(ServiceRequest serviceRequest);
	public List<ServiceRequest> getServiceRequestsForAssigner(List<Long> companyServices);
	public List<ServiceRequest> getAll();
}
