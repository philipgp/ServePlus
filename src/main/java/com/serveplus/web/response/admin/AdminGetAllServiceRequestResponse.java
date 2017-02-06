package com.serveplus.web.response.admin;

import java.util.List;

import com.serveplus.web.response.ServePlusResponse;

public class AdminGetAllServiceRequestResponse extends ServePlusResponse{
	private List<AdminServiceRequestVO> serviceRequests;

	public List<AdminServiceRequestVO> getServiceRequests() {
		return serviceRequests;
	}

	public void setServiceRequests(List<AdminServiceRequestVO> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}
}
