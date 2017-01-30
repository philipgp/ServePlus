package com.serveplus.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.CompanyServiceDao;
import com.serveplus.data.dao.CompanyServiceRatingQuestionDao;
import com.serveplus.data.dao.CsAssignerDao;
import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.CompanyServiceRatingQuestion;
import com.serveplus.data.entity.CsAssigner;
import com.serveplus.data.entity.Service;

@Component
public class CompanyServiceRatingQuestionDaoImpl extends BaseDataService<CompanyServiceRatingQuestion> 
implements CompanyServiceRatingQuestionDao{

	@Override
	public List<CompanyServiceRatingQuestion> findBy(CompanyService companyService) {
		String hql = "from CompanyServiceRatingQuestion where companyService= :companyService";
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("companyService", companyService);
		//parameterMap.add("service", service);
		List<CompanyServiceRatingQuestion> result = getResultList(hql, parameterMap);
		return result;
	}

}
