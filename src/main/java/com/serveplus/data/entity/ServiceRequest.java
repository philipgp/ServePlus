package com.serveplus.data.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE_REQUEST")
public class ServiceRequest {
	@Id
	@Column(name = "ID")
	private Long id;
	

	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
	
	@Column(name = "STATUS")
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ServiceRequest [id=" + id + ", customer=" + customer
				+ ", status=" + status + "]";
	}

	
}
