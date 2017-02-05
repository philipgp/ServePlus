package com.serveplus.data.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	
	@Column(name = "NAME")
	private String name;
	

	/*@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="workerServiceId.company")
	private Set<WorkerService> workerServices;*/

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="company")
	private Set<CompanyAddress> companyAddresses;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="company")
	private Set<CompanyContact> companyContactDetails = new HashSet<CompanyContact>(0);

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}







	public Set<CompanyAddress> getCompanyAddresses() {
		return companyAddresses;
	}


	public void setCompanyAddresses(Set<CompanyAddress> companyAddresses) {
		this.companyAddresses = companyAddresses;
	}


	public Set<CompanyContact> getCompanyContactDetails() {
		return companyContactDetails;
	}


	public void setCompanyContactDetails(Set<CompanyContact> companyContactDetails) {
		this.companyContactDetails = companyContactDetails;
	}


	

	
	
}
