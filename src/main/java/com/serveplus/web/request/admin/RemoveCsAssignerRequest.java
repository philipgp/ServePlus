package com.serveplus.web.request.admin;

public class RemoveCsAssignerRequest extends AdminRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7654159481066506925L;
	private Long companyId;
	private Long serviceId;
	private Long assignerId;
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
	public Long getAssignerId() {
		return assignerId;
	}
	public void setAssignerId(Long assignerId) {
		this.assignerId = assignerId;
	}
	
	
}
