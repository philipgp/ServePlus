package com.serveplus.web.request.worker;

public class WorkerServiceRequestBase extends WorkerBaseRequest{
	private Long serviceRequestId;

	public Long getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(Long serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
	
}
