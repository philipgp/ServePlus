package com.serveplus.web.request.customer;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.ServiceRequestRatingFeedback;
import com.serveplus.web.response.customer.QuestionSource;
import com.serveplus.web.response.mapper.Mapper;

public class ServiceRequestFeedbackMapper implements Mapper<RatingFeedbackVO,ServiceRequestRatingFeedback>{

	private ServiceRequest serviceRequest;
	
	public ServiceRequestFeedbackMapper(ServiceRequest serviceRequest) {
		super();
		this.serviceRequest = serviceRequest;
	}

	@Override
	public ServiceRequestRatingFeedback mapFrom(RatingFeedbackVO source) {
		ServiceRequestRatingFeedback feedback = new ServiceRequestRatingFeedback();
		String questionId = source.getQuestionId();
		int lastIndex = questionId.lastIndexOf("_");
		String id = questionId.substring(lastIndex+1);
		String questionS = questionId.substring(0, lastIndex);
		QuestionSource questionSource = QuestionSource.valueOf(questionS);
		feedback.setQuestionSource(questionSource);
		feedback.setQuestionId(Long.valueOf(id));
		feedback.setServiceRequest(serviceRequest);
		feedback.setAnswer(source.getFeedback());
		return feedback;
	}

}
