package com.serveplus.web.request.admin;

public class RemoveAssignerRequest extends AdminRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7654159481066506925L;
	private Long assignerId;
	public Long getAssignerId() {
		return assignerId;
	}
	public void setAssignerId(Long assignerId) {
		this.assignerId = assignerId;
	}
	
}
