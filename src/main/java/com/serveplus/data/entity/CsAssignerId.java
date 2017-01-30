package com.serveplus.data.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CsAssignerId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5605378140073686012L;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CompanyService companyService;
	
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Assigner assigner;




	


	public Assigner getAssigner() {
		return assigner;
	}


	public void setAssigner(Assigner assigner) {
		this.assigner = assigner;
	}


	public CompanyService getCompanyService() {
		return companyService;
	}


	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}


	

	
	
	
}
