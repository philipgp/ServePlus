package com.serveplus.web.request.admin;

import com.serveplus.web.request.customer.UserRegisterRequest;

public class AddNewAdminRequest extends UserRegisterRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3241853877030703259L;
	private Long adminId;
	private Long companyId;
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}
