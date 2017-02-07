package com.serveplus.web.request.admin;

public class AddNewCompanyServiceRequest extends AdminRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6012410860840000889L;
	private Long serviceId;
	private Long companyId;
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
