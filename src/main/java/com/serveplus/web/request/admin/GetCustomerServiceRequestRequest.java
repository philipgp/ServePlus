package com.serveplus.web.request.admin;

public class GetCustomerServiceRequestRequest extends AdminRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7998501141984686773L;
	private Long customerId;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
