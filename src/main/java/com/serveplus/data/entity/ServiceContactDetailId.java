package com.serveplus.data.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
public class ServiceContactDetailId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7874623500729222772L;


	@ManyToOne
	private ServiceRequest serviceRequest;
	
	
	@ManyToOne
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contactDetail == null) ? 0 : contactDetail.hashCode());
		result = prime * result
				+ ((serviceRequest == null) ? 0 : serviceRequest.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceContactDetailId other = (ServiceContactDetailId) obj;
		if (contactDetail == null) {
			if (other.contactDetail != null)
				return false;
		} else if (!contactDetail.equals(other.contactDetail))
			return false;
		if (serviceRequest == null) {
			if (other.serviceRequest != null)
				return false;
		} else if (!serviceRequest.equals(other.serviceRequest))
			return false;
		return true;
	}


	
}
