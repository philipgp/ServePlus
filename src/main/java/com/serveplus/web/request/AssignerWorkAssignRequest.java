package com.serveplus.web.request;

import com.serveplus.web.request.assigner.AssignerRequest;

public class AssignerWorkAssignRequest extends AssignerRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2658784420433315208L;
	private Long serviceRequestId;
	private Long workerId;
	public Long getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(Long serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
	public Long getWorkerId() {
		return workerId;
	}
	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}
	
}
