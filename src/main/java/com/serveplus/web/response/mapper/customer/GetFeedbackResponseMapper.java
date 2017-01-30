package com.serveplus.web.response.mapper.customer;

import java.util.List;

import com.serveplus.data.entity.ServiceRequestRatingFeedback;
import com.serveplus.web.response.customer.CustomerFeedbackVO;
import com.serveplus.web.response.customer.GetFeedbackResponse;
import com.serveplus.web.response.customer.RatingQuestionResponse;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.Mapper;

public class GetFeedbackResponseMapper implements Mapper<List<ServiceRequestRatingFeedback>,GetFeedbackResponse>{
	RatingQuestionResponse ratingQuestionResponse;
	public GetFeedbackResponseMapper(
			RatingQuestionResponse ratingQuestionResponse) {
		super();
		this.ratingQuestionResponse = ratingQuestionResponse;
	}
	@Override
	public GetFeedbackResponse mapFrom(List<ServiceRequestRatingFeedback> source) {
		GetFeedbackResponse response = new GetFeedbackResponse();
		ListToListMapper<ServiceRequestRatingFeedback, CustomerFeedbackVO> listMapper = new ListToListMapper<>();
		List<CustomerFeedbackVO> list = listMapper.mapFrom(source, new CustomerFeedbackVOMapper(ratingQuestionResponse));
		response.setFeedbacks(list);
		return response;
	}

}
