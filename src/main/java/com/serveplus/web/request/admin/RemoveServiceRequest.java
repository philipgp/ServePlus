package com.serveplus.web.request.admin;

public class RemoveServiceRequest extends AdminRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7654159481066506925L;
	
	private Long serviceId;
	
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	
	
}
