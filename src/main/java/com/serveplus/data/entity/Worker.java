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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WORKER")
public class Worker {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@Column(name = "ACTIVE")
	private Boolean active;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "COMPANY_ID")
	private Company company;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="workerServiceId.worker")
	private Set<WorkerService> workerServices;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<WorkerService> getWorkerServices() {
		return workerServices;
	}

	public void setWorkerServices(Set<WorkerService> workerServices) {
		this.workerServices = workerServices;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Worker [id=").append(id).append(", user=").append(user)
				.append(", active=").append(active).append(", company=")
				.append(company).append(", workerServices=")
				.append(workerServices).append("]");
		return builder.toString();
	}

	
	
	
}
