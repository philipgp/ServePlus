package com.serveplus.web.response.admin;

import com.serveplus.web.response.ServePlusResponse;

public class AddNewCsAssignerResponse extends ServePlusResponse {
	private Boolean status = Boolean.TRUE;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
