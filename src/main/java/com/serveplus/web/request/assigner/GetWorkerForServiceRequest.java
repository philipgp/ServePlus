package com.serveplus.web.request.assigner;

public class GetWorkerForServiceRequest extends AssignerRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1225931607242371426L;
	
	private Long serviceId;
	private Long companyId;

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
