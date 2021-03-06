package com.serveplus.data.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CompanyServiceId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5605378140073686012L;
	@ManyToOne(cascade = CascadeType.ALL)
	private Company company;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	
	private Service service;


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}


	
	
	
}
