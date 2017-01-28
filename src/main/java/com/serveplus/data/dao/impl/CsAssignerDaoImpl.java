package com.serveplus.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.CsAssignerDao;
import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CsAssigner;
import com.serveplus.data.entity.Service;

@Component
public class CsAssignerDaoImpl extends BaseDataService<CsAssigner> implements CsAssignerDao{

	@Override
	public List<CsAssigner> findBy(Company company, Service service) {
		String hql = "from CsAssigner where csAssignerId.company=:company and csAssignerId.service = :service";
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("company", company);
		parameterMap.add("service", service);
		List<CsAssigner> result = getResultList(hql, parameterMap);
		return result;
	}

}
