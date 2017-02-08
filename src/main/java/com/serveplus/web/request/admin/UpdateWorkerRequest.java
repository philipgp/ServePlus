package com.serveplus.web.request.admin;

import com.serveplus.web.request.customer.UserRegisterRequest;

public class UpdateWorkerRequest extends UserRegisterRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6339830673392769178L;
	private Long workerId;
	private Long adminId;
	private Long companyId;
	private Boolean active;
	
	
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Long getWorkerId() {
		return workerId;
	}
	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
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
