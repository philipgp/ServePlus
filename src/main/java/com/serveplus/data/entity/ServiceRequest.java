package com.serveplus.data.entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE_REQUEST")
public class ServiceRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "COMPANY_SERVICE_ID")
	private CompanyService companyService;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "WORKER_ID")
	private Worker worker;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ASSIGNER_ID")
	private Assigner assigner;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "PAYMENT_ID")
	private Payment payment;
	
	
	
	@Column(name = "REQUEST")
	private String request;
	
	@Column(name = "PREFERRED_TIME")
	private String preferredTime;
	
	@Column(name = "PREFERRED_DAYS")
	private String preferredDays;
	
	@Column(name = "RATING")
	private Integer rating;
	
	@OneToMany(mappedBy="serviceRequest",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<SrActionHistory> actionHistories;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="serviceRequest")
	private Set<ServiceContactDetail> serviceContactDetails = new HashSet<ServiceContactDetail>(0);
	
	
	
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




	public CompanyService getCompanyService() {
		return companyService;
	}
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
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
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public void setActionHistories(List<SrActionHistory> actionHistories) {
		this.actionHistories = actionHistories;
	}
	
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	public String getPreferredTime() {
		return preferredTime;
	}
	public void setPreferredTime(String preferredTime) {
		this.preferredTime = preferredTime;
	}
	public String getPreferredDays() {
		return preferredDays;
	}
	public Set<ServiceContactDetail> getServiceContactDetails() {
		return serviceContactDetails;
	}
	public void setServiceContactDetails(
			Set<ServiceContactDetail> serviceContactDetails) {
		this.serviceContactDetails = serviceContactDetails;
	}
	public void setPreferredDays(String preferredDays) {
		this.preferredDays = preferredDays;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceRequest [id=").append(id)
				.append(", companyService=").append(companyService)
				.append(", customer=").append(customer).append(", worker=")
				.append(worker).append(", assigner=").append(assigner)
				.append(", address=").append(address).append(", payment=")
				.append(payment).append(", request=").append(request)
				.append(", actionHistories=").append(actionHistories)
				.append(", status=").append(status).append("]");
		return builder.toString();
	}



	
}
