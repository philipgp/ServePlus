package com.serveplus.web.response.customer;

import java.util.List;

public class GetFeedbackResponse extends CustomerResponseBase{
	private List<CustomerFeedbackVO> feedbacks;

	public List<CustomerFeedbackVO> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<CustomerFeedbackVO> feedbacks) {
		this.feedbacks = feedbacks;
	} 
}
