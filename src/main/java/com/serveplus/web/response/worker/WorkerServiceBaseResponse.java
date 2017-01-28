package com.serveplus.web.response.worker;

import com.serveplus.web.response.ServePlusResponse;

public class WorkerServiceBaseResponse extends ServePlusResponse{
	private Long workerId;
	private Long serviceRequestId;
	public Long getWorkerId() {
		return workerId;
	}
	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}
	public Long getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(Long serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

}
