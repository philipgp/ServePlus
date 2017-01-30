package com.serveplus.web.response.customer;

import com.serveplus.web.request.customer.RatingFeedbackVO;

public class CustomerFeedbackVO extends RatingFeedbackVO{
	private String question;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
