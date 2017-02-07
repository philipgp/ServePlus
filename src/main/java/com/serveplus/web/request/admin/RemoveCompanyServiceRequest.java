package com.serveplus.web.request.admin;

public class RemoveCompanyServiceRequest extends AdminRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7654159481066506925L;
	private Long companyId;
	private Long serviceId;
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	
	
	
	
}
