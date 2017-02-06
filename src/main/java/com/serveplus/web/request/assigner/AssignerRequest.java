package com.serveplus.web.request.assigner;

import com.serveplus.web.request.ServePlusRequest;

public class AssignerRequest extends ServePlusRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8628121613885179296L;
	 private Long assignerId;
	public Long getAssignerId() {
		return assignerId;
	}
	public void setAssignerId(Long assignerId) {
		this.assignerId = assignerId;
	}
}
