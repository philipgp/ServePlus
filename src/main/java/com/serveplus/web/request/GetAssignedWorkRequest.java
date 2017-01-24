package com.serveplus.web.request;

public class GetAssignedWorkRequest extends ServePlusRequest{
	private Long workerId;

	public Long getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}
	
}
