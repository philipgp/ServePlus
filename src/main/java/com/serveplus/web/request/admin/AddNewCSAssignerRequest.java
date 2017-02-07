package com.serveplus.web.request.admin;

public class AddNewCSAssignerRequest extends AdminRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5909232079727214654L;
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
	@Override
	public String toString() {
		return "AddNewCSAssignerRequest [companyId=" + companyId + ", serviceId=" + serviceId + ", assignerId="
				+ assignerId + "]";
	}
}
