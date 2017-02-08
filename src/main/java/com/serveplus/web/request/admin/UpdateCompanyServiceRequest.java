package com.serveplus.web.request.admin;

import com.serveplus.web.request.customer.UserRegisterRequest;

public class UpdateCompanyServiceRequest extends AdminRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6339830673392769178L;
	private Long assignerId;
	private Long serviceId;
	private Boolean active;
	public Long getAssignerId() {
		return assignerId;
	}
	public void setAssignerId(Long assignerId) {
		this.assignerId = assignerId;
	}
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
	
	
}
