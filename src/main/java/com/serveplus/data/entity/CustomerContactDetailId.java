package com.serveplus.data.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CustomerContactDetailId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5552343783759459808L;


	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	
	private ContactDetail contactDetail;




	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public ContactDetail getContactDetail() {
		return contactDetail;
	}


	public void setContactDetail(ContactDetail contactDetail) {
		this.contactDetail = contactDetail;
	}


	
}
