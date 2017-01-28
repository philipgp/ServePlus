package com.serveplus.data.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name = "ID")
	private Long id;
	
	
	@Column(name = "NAME")
	private String name;
	

	/*@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="workerServiceId.company")
	private Set<WorkerService> workerServices;*/

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="companyAddressId.company")
	private Set<CompanyAddress> companyAddresses;

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


	

	
	
}
