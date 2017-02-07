package com.serveplus.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.CsAssignerDao;
import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.CsAssigner;
import com.serveplus.data.entity.Service;

@Component
public class CsAssignerDaoImpl extends BaseDataService<CsAssigner> implements CsAssignerDao{

	@Override
	public List<CsAssigner> findBy(CompanyService companyService) {
		String hql = "from CsAssigner where csAssignerId.companyService=:companyService ";
			
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("companyService", companyService);
		//parameterMap.add("service", service);
		List<CsAssigner> result = getResultList(hql, parameterMap);
		return result;
	}

	@Override
	public List<CsAssigner> findByAssigner(Assigner assigner) {
		String hql = "from CsAssigner where csAssignerId.assigner=:assigner ";
		
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("assigner", assigner);
		//parameterMap.add("service", service);
		List<CsAssigner> result = getResultList(hql, parameterMap);
		return result;
	}

	@Override
	public CsAssigner findBy(CompanyService companyService, Assigner assigner) {
		String hql = "from CsAssigner where csAssignerId.companyService=:companyService and csAssignerId.assigner=:assigner";
		
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("companyService", companyService);
		parameterMap.add("assigner", assigner);
		//parameterMap.add("service", service);
		CsAssigner result = getOneResult(hql, parameterMap);
		return result;
	}

}
