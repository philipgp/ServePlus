package com.serveplus.web.response.admin;

import com.serveplus.web.response.ServePlusResponse;

public class AddNewAdminResponse extends ServePlusResponse {
	private Boolean status = Boolean.TRUE;
	private Long adminId;



	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
