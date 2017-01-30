package com.serveplus.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.CompanyServiceDao;
import com.serveplus.data.dao.CompanyServiceRatingQuestionDao;
import com.serveplus.data.dao.CsAssignerDao;
import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.dao.ServiceRatingQuestionDao;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.CompanyServiceRatingQuestion;
import com.serveplus.data.entity.CsAssigner;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceRatingQuestion;
import com.serveplus.data.entity.ServiceRequestRatingFeedback;

@Component
public class ServiceRatingQuestionDaoImpl extends BaseDataService<ServiceRatingQuestion> 
implements ServiceRatingQuestionDao{

	@Override
	public List<ServiceRatingQuestion> findBy(Service service) {
		String hql = "from ServiceRatingQuestion where service= :service";
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("service", service);
		//parameterMap.add("service", service);
		List<ServiceRatingQuestion> result = getResultList(hql, parameterMap);
		return result;
	}

}
