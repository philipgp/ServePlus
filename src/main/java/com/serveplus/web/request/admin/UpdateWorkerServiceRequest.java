package com.serveplus.web.request.admin;

public class UpdateWorkerServiceRequest extends AdminRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4996419747159682758L;
	
	private Long workerId;
	private Long serviceId;
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
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	
}
