package com.serveplus.data.entity;


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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.serveplus.web.response.customer.QuestionSource;

@Entity
@Table(name = "SR_RATING")
public class ServiceRequestRatingFeedback {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "SERVICE_REQUEST_ID")
	private ServiceRequest serviceRequest;

	

	@Column(name = "QUESTION_ID")
	private Long questionId;
	
	@Column(name = "QUESTION_SOURCE")
	@Enumerated(EnumType.STRING)
	private QuestionSource questionSource;
	
	@Column(name = "ANSWER")
	private String answer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public QuestionSource getQuestionSource() {
		return questionSource;
	}

	public void setQuestionSource(QuestionSource questionSource) {
		this.questionSource = questionSource;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceRatingQuestion [id=").append(id)
				.append(", serviceRequest=").append(serviceRequest)
				.append(", questionId=").append(questionId)
				.append(", questionSource=").append(questionSource)
				.append(", answer=").append(answer).append("]");
		return builder.toString();
	}
	

	
	

	

	
}
