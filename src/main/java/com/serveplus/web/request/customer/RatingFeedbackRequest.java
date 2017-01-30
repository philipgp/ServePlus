package com.serveplus.web.request.customer;

import java.util.List;

public class RatingFeedbackRequest extends CustomerBaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 784941201752457443L;
	private Long serviceRequestId;
	private Integer rating;
	private List<RatingFeedbackVO> feedbacks;
	public Long getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(Long serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public List<RatingFeedbackVO> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<RatingFeedbackVO> feedbacks) {
		this.feedbacks = feedbacks;
	}

}
