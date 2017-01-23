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
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {
	@Id
	@Column(name = "ID")
	private Long id;
	
	
	@Column(name = "NAME")
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "COMPANY_SERVICE",  joinColumns = {
			@JoinColumn(name = "COMPANY_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "SERVICE_ID",
					nullable = false, updatable = false) })
	private Set<Service> services;


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


	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}


	public Set<Service> getServices() {
		return services;
	}


	public void setServices(Set<Service> services) {
		this.services = services;
	}

	
	
}
