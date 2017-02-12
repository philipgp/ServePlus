package com.serveplus.web.request;

import com.serveplus.web.request.assigner.AssignerRequest;

public class GetWorksToAssignRequest extends AssignerRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3008252821931722821L;
	private Long companyId;
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
