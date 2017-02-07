package com.serveplus.web.response.admin;

import com.serveplus.web.response.ServePlusResponse;

public class AddNewAssignerResponse extends ServePlusResponse {
	private Boolean status = Boolean.TRUE;
	private Long assignerId;

	public Long getAssignerId() {
		return assignerId;
	}

	public void setAssignerId(Long assignerId) {
		this.assignerId = assignerId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
