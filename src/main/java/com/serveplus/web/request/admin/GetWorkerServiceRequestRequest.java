package com.serveplus.web.request.admin;

public class GetWorkerServiceRequestRequest extends AdminRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7998501141984686773L;
	private Long workerId;
	public Long getWorkerId() {
		return workerId;
	}
	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}
	
}
