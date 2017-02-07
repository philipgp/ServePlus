package com.serveplus.data.entity;


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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE")
public class Service {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;
	

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="workerServiceId.service")
	private Set<WorkerService> workerServices;
	
	
/*	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="serviceRequest")
	private Set<ServiceContactDetail> serviceContactDetails;*/

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	/*public Set<ServiceContactDetail> getServiceContactDetails() {
		return serviceContactDetails;
	}

	public void setServiceContactDetails(
			Set<ServiceContactDetail> serviceContactDetails) {
		this.serviceContactDetails = serviceContactDetails;
	}*/

	public Set<WorkerService> getWorkerServices() {
		return workerServices;
	}

	public void setWorkerServices(Set<WorkerService> workerServices) {
		this.workerServices = workerServices;
	}

	
	
	
}
