package com.serveplus.web.response.customer;

import java.util.List;

public class UserServiceResponse extends CustomerResponseBase{
	private List<UserServiceVO> services;

	public List<UserServiceVO> getServices() {
		return services;
	}

	public void setServices(List<UserServiceVO> services) {
		this.services = services;
	}
}
