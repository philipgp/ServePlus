package com.serveplus.web.response.mapper.customer;

import java.util.List;

import com.serveplus.data.entity.CompanyServiceRatingQuestion;
import com.serveplus.data.entity.ServiceRatingQuestion;
import com.serveplus.data.entity.ServiceRequestRatingFeedback;
import com.serveplus.web.response.customer.CustomerRatingQuestionVO;
import com.serveplus.web.response.customer.CustomerRatingQuestionVOMapper;
import com.serveplus.web.response.customer.QuestionSource;
import com.serveplus.web.response.customer.RatingQuestionResponse;
import com.serveplus.web.response.mapper.ListToListMapper;

public class RatingQuestionResponseMapper {

	private List<ServiceRatingQuestion> serviceRatingQuestions;
	private List<CompanyServiceRatingQuestion> companyServiceRatingQuestions;
	public RatingQuestionResponseMapper(
			List<ServiceRatingQuestion> serviceRatingQuestions,
			List<CompanyServiceRatingQuestion> companyServiceRatingQuestions) {
		super();
		this.serviceRatingQuestions = serviceRatingQuestions;
		this.companyServiceRatingQuestions = companyServiceRatingQuestions;
	}
	public RatingQuestionResponse mapFrom(){
		RatingQuestionResponse response = new RatingQuestionResponse();
		ListToListMapper<ServiceRatingQuestion, CustomerRatingQuestionVO> serviceRatingMapper = new ListToListMapper<>();
		List<CustomerRatingQuestionVO> mappedList1 = serviceRatingMapper.mapFrom(serviceRatingQuestions, new CustomerRatingQuestionVOMapper(QuestionSource.SERVICE));
		
		ListToListMapper<CompanyServiceRatingQuestion, CustomerRatingQuestionVO> companyServiceRatingMapper = new ListToListMapper<>(); 
		List<CustomerRatingQuestionVO> mappedList2 = companyServiceRatingMapper.mapFrom(companyServiceRatingQuestions, new CustomerRatingQuestionVOMapper(QuestionSource.COMPANY_SERVICE));
		if(mappedList1!=null && mappedList2!=null)
			mappedList1.addAll(mappedList2);
		response.setQuestions(mappedList1);
		return response;
	}
}
