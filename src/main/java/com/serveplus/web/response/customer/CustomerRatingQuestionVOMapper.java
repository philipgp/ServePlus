package com.serveplus.web.response.customer;

import com.serveplus.data.entity.RatingQuestion;
import com.serveplus.web.response.mapper.Mapper;

public class CustomerRatingQuestionVOMapper<U extends RatingQuestion> implements Mapper< U, CustomerRatingQuestionVO>{
	QuestionSource qsource;
	
	public CustomerRatingQuestionVOMapper(QuestionSource source) {
		super();
		this.qsource = source;
	}

	@Override
	public CustomerRatingQuestionVO mapFrom(U source) {
		CustomerRatingQuestionVO ratingQuestion = new CustomerRatingQuestionVO();
		ratingQuestion.setQuestion(source.getQuestion());
		ratingQuestion.setQuestionId(qsource.toString()+"_"+source.getId());
		return ratingQuestion;
	}

}
