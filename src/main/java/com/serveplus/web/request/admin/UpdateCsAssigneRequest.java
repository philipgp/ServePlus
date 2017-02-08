package com.serveplus.web.request.admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.serveplus.web.request.customer.UserRegisterRequest;

public class UpdateCsAssigneRequest extends AdminRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6339830673392769178L;
	private Long assignerId;
	private Long serviceId;
	private Boolean active,isDefault;
	public Long getAssignerId() {
		return assignerId;
	}
	@JsonProperty("default")
	public Boolean getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
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
