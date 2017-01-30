package com.serveplus.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.CompanyServiceDao;
import com.serveplus.data.dao.CsAssignerDao;
import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.CsAssigner;
import com.serveplus.data.entity.Service;

@Component
public class CompanyServiceDaoImpl extends BaseDataService<CompanyService> implements CompanyServiceDao{

	@Override
	public CompanyService findBy(Company company, Service service) {
		String hql = "from CompanyService where company=:company and service = :service";
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("company", company);
		parameterMap.add("service", service);
		CompanyService result = getOneResult(hql,parameterMap);
		return result;
	}

}
