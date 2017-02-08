package com.serveplus.web.request.admin;

import com.serveplus.web.request.ServePlusRequest;
import com.serveplus.web.response.ServePlusResponse;

public class AdminRequest extends ServePlusRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1369262671730764528L;
	private Long adminId;
	private Long companyId;
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
}
