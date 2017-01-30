package com.serveplus.web.request.customer;


public class CreateServiceRequest extends CreateServiceRequestBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2723237675699607016L;
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
	@Override
	public String toString() {
		return "CreateServiceRequest [serviceId=" + serviceId + ", companyId="
				+ companyId + ", latitude=" + latitude + ", longitude="
				+ longitude + ", localAddress=" + localAddress + ", comment="
				+ request + "]";
	}
}
