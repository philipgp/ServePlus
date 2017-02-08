package com.serveplus.web.request.admin;

import com.serveplus.web.request.customer.UserRegisterRequest;

public class UpdateAssignerRequest extends UserRegisterRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6339830673392769178L;
	private Long assignerId;
	private Long adminId;
	private Long companyId;

	private Boolean active;
	
	
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Long getAssignerId() {
		return assignerId;
	}
	public void setAssignerId(Long assignerId) {
		this.assignerId = assignerId;
	}
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
