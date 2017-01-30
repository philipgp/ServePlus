package com.serveplus.web.response.customer;

import java.util.List;

public class RatingQuestionResponse extends CustomerResponseBase{
	private List<CustomerRatingQuestionVO> questions;

	public List<CustomerRatingQuestionVO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<CustomerRatingQuestionVO> questions) {
		this.questions = questions;
	}
}
