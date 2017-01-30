package com.serveplus.data.dao;

import java.util.List;

import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.CompanyServiceRatingQuestion;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceRatingQuestion;
import com.serveplus.data.entity.ServiceRequestRatingFeedback;
import com.serveplus.data.entity.User;

public interface ServiceRatingQuestionDao {

	List<ServiceRatingQuestion> findBy(Service service);
	
	
	

}
