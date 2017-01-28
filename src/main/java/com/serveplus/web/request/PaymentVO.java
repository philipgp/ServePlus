package com.serveplus.web.request;

import com.serveplus.data.entity.PaymentStatus;
import com.serveplus.data.entity.PaymentType;

public class PaymentVO {
	private Float amount;
	private String currency;
	private PaymentType paymentType;
	private PaymentStatus paymentStatus;
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
