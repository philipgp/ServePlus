package com.serveplus.data.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WORKER")
public class Worker {
	@Id
	@Column(name = "ID")
	private Long id;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;
	
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

	@Override
	public String toString() {
		return "Worker [id=" + id + ", user=" + user + ", company=" + company
				+ ", workerServices=" + workerServices + "]";
	}

	
	
	
}
