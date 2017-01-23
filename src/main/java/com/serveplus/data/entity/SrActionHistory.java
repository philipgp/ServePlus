package com.serveplus.data.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SR_ACTION_HISTORY ")
public class SrActionHistory {
	@Id
	@Column(name = "ID")
	private Long id;
	

	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "SERVICE_REQUEST_ID")
	private ServiceRequest serviceRequest;
	
	@Column(name = "ACTION")
	private String action;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
}
