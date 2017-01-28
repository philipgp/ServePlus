package com.serveplus.data.dao;

import java.util.List;

import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.User;

public interface ServiceRequestDao {
	
	public List<ServiceRequest> getServiceRequestsByWorkerId(Long workerId);
	public List<ServiceRequest> getServiceRequestsByCustomerId(Long customerId);
	public ServiceRequest getServiceRequestById(Long id);
	public void save(ServiceRequest serviceRequest);
	
}
