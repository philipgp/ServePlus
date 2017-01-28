package com.serveplus.data.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class WorkerServiceId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5605378140073686012L;
	@ManyToOne(cascade = CascadeType.ALL)
	private Worker worker;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	
	private Service service;


	


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}


	public Worker getWorker() {
		return worker;
	}


	public void setWorker(Worker worker) {
		this.worker = worker;
	}


	
	
	
}
