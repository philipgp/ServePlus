package com.serveplus.data.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE_RATING_QUESTIONS")
public class ServiceRatingQuestion extends RatingQuestion{
	
	
	
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "SERVICE_ID")
	private Service service;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceRatingQuestion [service=").append(service)
				.append("]");
		return builder.toString();
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	

	

	
}
