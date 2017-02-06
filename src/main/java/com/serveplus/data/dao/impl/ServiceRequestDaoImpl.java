package com.serveplus.data.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.dao.ServiceRequestDao;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.ServiceRequest;

@Component
public class ServiceRequestDaoImpl extends BaseDataService<ServiceRequest> implements ServiceRequestDao{

	
	@Override
	public List<ServiceRequest> getServiceRequestsByWorkerId(Long workerId) {
		String hql = " FROM ServiceRequest serviceRequest where serviceRequest.worker.id=:workerId";
		ParameterMap parameterMap  = new ParameterMap();
		parameterMap.add("workerId", workerId);
		List<ServiceRequest> results = getResultList(hql, parameterMap);
		return results;
	}

	@Override
	public ServiceRequest getServiceRequestById(Long id) {
		String hql = " FROM ServiceRequest serviceRequest where serviceRequest.id=:id";
		ParameterMap parameterMap  = new ParameterMap();
		parameterMap.add("id", id);
		ServiceRequest result = getOneResult(hql, parameterMap);
		return result;
	}

	@Override
	public List<ServiceRequest> getServiceRequestsByCustomerId(Long customerId) {
		String hql = " FROM ServiceRequest serviceRequest where serviceRequest.customer.id=:customerId";
		ParameterMap parameterMap  = new ParameterMap();
		parameterMap.add("customerId", customerId);
		List<ServiceRequest> result = getResultList(hql, parameterMap);
		return result;
	}

	@Override
	public List<ServiceRequest> getServiceRequestsForAssigner(List<Long> companyServices) {
		String hql = " FROM ServiceRequest serviceRequest where serviceRequest.companyService.id in (:companyServices)";
		ParameterMap parameterMap  = new ParameterMap();
		parameterMap.addList("companyServices", companyServices);
		List<ServiceRequest> result = getResultList(hql, parameterMap);
		return result;
	}

}
