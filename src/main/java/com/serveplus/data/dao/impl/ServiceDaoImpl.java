package com.serveplus.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.ServiceDao;
import com.serveplus.data.entity.Service;

@Component
public class ServiceDaoImpl extends BaseDataService<Service> implements ServiceDao{

	@Override
	public List<Service> getActiveServices() {
		String hql = "from Service where id in(select workerServiceId.service.id from WorkerService where active=true )";
		List<Service> results = getResultList(hql);
		return results;
	}
	
}
