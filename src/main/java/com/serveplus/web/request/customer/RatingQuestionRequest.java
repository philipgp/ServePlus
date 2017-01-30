package com.serveplus.web.request.customer;


public class RatingQuestionRequest extends CustomerBaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5684701942235478795L;
	private Long serviceRequestId;
	public Long getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(Long serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
	

}
