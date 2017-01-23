package com.serveplus.data.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CompanyAddresId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5605378140073686012L;
	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	
	private Address address;


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
