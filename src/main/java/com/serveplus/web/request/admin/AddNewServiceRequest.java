package com.serveplus.web.request.admin;

public class AddNewServiceRequest extends AdminRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2948135801852573066L;
	private String serviceName,categoryName;
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
