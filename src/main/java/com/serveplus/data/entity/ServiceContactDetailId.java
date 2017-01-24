package com.serveplus.data.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ServiceContactDetailId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7874623500729222772L;


	@ManyToOne(cascade = CascadeType.ALL)
	private ServiceRequest serviceRequest;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	
	private ContactDetail contactDetail;


	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}


	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}


	public ContactDetail getContactDetail() {
		return contactDetail;
	}


	public void setContactDetail(ContactDetail contactDetail) {
		this.contactDetail = contactDetail;
	}


	
}
