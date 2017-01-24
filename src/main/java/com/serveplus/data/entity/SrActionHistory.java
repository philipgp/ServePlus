package com.serveplus.data.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SR_ACTION_HISTORY ")
public class SrActionHistory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	

	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "SERVICE_REQUEST_ID")
	private ServiceRequest serviceRequest;
	
	@Column(name = "ACTION")
	@Enumerated(EnumType.STRING)
	private SrAction action;

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

	public SrAction getAction() {
		return action;
	}

	public void setAction(SrAction action) {
		this.action = action;
	}

	

	
}
