package com.serveplus.web.request.worker;

import com.serveplus.web.request.PaymentVO;

public class WorkClosedRequest extends WorkChangeRequest{

	private PaymentVO payment;

	public PaymentVO getPayment() {
		return payment;
	}

	public void setPayment(PaymentVO payment) {
		this.payment = payment;
	}
	
}
