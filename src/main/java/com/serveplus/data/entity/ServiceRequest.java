package com.serveplus.data.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE_REQUEST")
public class ServiceRequest extends EntityBase{
	@Id
	@Column(name = "ID")
	private Long id;
	

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "SERVICE_ID")
	private Service service;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "WORKER_ID")
	private Worker worker;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ASSIGNER_ID")
	private Assigner assigner;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;
	
	@OneToMany(mappedBy="serviceRequest",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<SrActionHistory> actionHistories;
	
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private ServiceRequestStatus status;

	public void addAction(SrActionHistory action){
		if(actionHistories == null)
			actionHistories = new ArrayList<SrActionHistory>();
		actionHistories.add(action);
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Assigner getAssigner() {
		return assigner;
	}

	public void setAssigner(Assigner assigner) {
		this.assigner = assigner;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public ServiceRequestStatus getStatus() {
		return status;
	}

	public void setStatus(ServiceRequestStatus status) {
		this.status = status;
	}

	public List<SrActionHistory> getActionHistories() {
		return actionHistories;
	}
	public void setActionHistories(List<SrActionHistory> actionHistories) {
		this.actionHistories = actionHistories;
	}
	@Override
	public String toString() {
		return "ServiceRequest [id=" + id + ", customer=" + customer
				+ ", status=" + status + "]";
	}



	
}
