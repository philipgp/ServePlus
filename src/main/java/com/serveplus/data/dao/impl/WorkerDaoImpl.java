package com.serveplus.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.dao.WorkerDao;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.Worker;

@Component
public class WorkerDaoImpl extends BaseDataService<Worker> implements WorkerDao{

	@Override
	public List<Worker> getAllFromCompany(Company company) {
		String hql = "from Worker where company=:company";
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("company", company);
		List<Worker> result = getResultList(hql, parameterMap);
		return result;
	} 
	
}
