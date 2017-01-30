package com.serveplus.web.response.mapper.customer;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.serveplus.data.entity.ServiceRequestRatingFeedback;
import com.serveplus.web.response.customer.CustomerFeedbackVO;
import com.serveplus.web.response.customer.CustomerRatingQuestionVO;
import com.serveplus.web.response.customer.RatingQuestionResponse;
import com.serveplus.web.response.mapper.Mapper;

public class CustomerFeedbackVOMapper implements Mapper<ServiceRequestRatingFeedback,CustomerFeedbackVO>{
	RatingQuestionResponse ratingQuestionRespons;
	public CustomerFeedbackVOMapper(RatingQuestionResponse ratingQuestionRespons) {
		super();
		this.ratingQuestionRespons = ratingQuestionRespons;
	}
	@Override
	public CustomerFeedbackVO mapFrom(ServiceRequestRatingFeedback source) {
		CustomerFeedbackVO feedbackVO = new CustomerFeedbackVO();
		feedbackVO.setFeedback(source.getAnswer());
		List<CustomerRatingQuestionVO> questions = ratingQuestionRespons.getQuestions();
		String questionId =source.getQuestionSource()+"_"+ source.getQuestionId();
		feedbackVO.setQuestionId(questionId);
		if(questions!=null){
			for(CustomerRatingQuestionVO question:questions){
				if(StringUtils.equalsIgnoreCase(questionId, question.getQuestionId())){
					feedbackVO.setQuestion(question.getQuestion());
				}
			}
		}
		
		return feedbackVO;
	}

}
