package com.serveplus.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.dao.WorkerServiceDao;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.WorkerService;

@Component
public class WorkerServiceDaoImpl extends BaseDataService<WorkerService> implements
		WorkerServiceDao {

	@Override
	public List<WorkerService> findWorkerService(Company company,
			Service service) {
		String hql = "from WorkerService where workerServiceId.worker.company=:company and workerServiceId.service=:service ";
		ParameterMap parameterMap  = new  ParameterMap();
		parameterMap.add("company", company);
		parameterMap.add("service", service);
		List<WorkerService> results = getResultList(hql, parameterMap);
		return results;
	}
	
}
