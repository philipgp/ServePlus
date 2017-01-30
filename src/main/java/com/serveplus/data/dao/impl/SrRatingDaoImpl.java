package com.serveplus.data.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.serveplus.data.dao.ParameterMap;
import com.serveplus.data.dao.SrRatingDao;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.ServiceRequestRatingFeedback;

@Component
public class SrRatingDaoImpl extends BaseDataService<ServiceRequestRatingFeedback> implements SrRatingDao{

	@Override
	public List<ServiceRequestRatingFeedback> findByServiceRequest(
			ServiceRequest serviceRequest) {
		String hql = " FROM ServiceRequestRatingFeedback serviceRequestRatingFeedback where serviceRequest=:serviceRequest";
		ParameterMap parameterMap = new ParameterMap();
		parameterMap.add("serviceRequest", serviceRequest);
		
		List<ServiceRequestRatingFeedback> result = getResultList(hql,parameterMap);
		return result;
	}
	
}
