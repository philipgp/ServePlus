package com.serveplus.web.request.admin;

public class RemoveWorkerRequest extends AdminRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7654159481066506925L;
	private Long workerId;
	public Long getWorkerId() {
		return workerId;
	}
	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}
}
