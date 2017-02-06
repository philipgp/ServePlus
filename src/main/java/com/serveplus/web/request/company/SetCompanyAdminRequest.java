package com.serveplus.web.request.company;

import com.serveplus.web.request.ServePlusRequest;

public class SetCompanyAdminRequest extends CompanyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5508528065880598604L;
	private Long adminId;
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	
}
