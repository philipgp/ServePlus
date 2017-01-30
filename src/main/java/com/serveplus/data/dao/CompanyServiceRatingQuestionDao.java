package com.serveplus.data.dao;

import java.util.List;

import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.CompanyServiceRatingQuestion;
import com.serveplus.data.entity.User;

public interface CompanyServiceRatingQuestionDao {

	List<CompanyServiceRatingQuestion> findBy(CompanyService companyService);
	
	
	

}
