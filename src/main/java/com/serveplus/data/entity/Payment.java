package com.serveplus.data.entity;


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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	private PaymentType type;
	
	@Column(name = "AMOUNT")
	private Float amount;
	
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	
	@Column(name = "HANDLER_TYPE")
	@Enumerated(EnumType.STRING)
	private HandlerType handlerType;
	
	
	@Column(name = "HANDLER_ID")
	private Long handlerId;

	@Column(name = "CURRENCY")
	private String currency;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public HandlerType getHandlerType() {
		return handlerType;
	}

	public void setHandlerType(HandlerType handlerType) {
		this.handlerType = handlerType;
	}

	public Long getHandlerId() {
		return handlerId;
	}

	public void setHandlerId(Long handlerId) {
		this.handlerId = handlerId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", type=" + type + ", amount=" + amount
				+ ", status=" + status + ", handlerType=" + handlerType
				+ ", handlerId=" + handlerId + ", currency=" + currency + "]";
	}
	
	
	

	
	
}
