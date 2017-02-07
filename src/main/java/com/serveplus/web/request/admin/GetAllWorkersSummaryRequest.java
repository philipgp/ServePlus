package com.serveplus.web.request.admin;

import com.serveplus.web.request.ServePlusRequest;

public class GetAllWorkersSummaryRequest extends AdminRequest{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6657873259741209548L;
	private Long companyId;
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
