package com.serveplus.web.request.customer;

public class GetFeedbackRequest extends CustomerBaseRequest{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5379397624259359003L;
	private Long serviceRequestId;
	public Long getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(Long serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
}
