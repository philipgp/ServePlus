package com.serveplus.web.response.admin;

import com.serveplus.web.response.ServePlusResponse;

public class AddNewWorkerResponse extends ServePlusResponse {
	private Boolean status = Boolean.TRUE;
	private Long workerId;





	public Long getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
