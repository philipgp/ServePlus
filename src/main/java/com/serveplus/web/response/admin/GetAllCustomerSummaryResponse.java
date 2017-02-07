package com.serveplus.web.response.admin;

import java.util.List;

import com.serveplus.web.response.ServePlusResponse;
import com.serveplus.web.response.customer.CustomerSummaryVO;

public class GetAllCustomerSummaryResponse extends ServePlusResponse{
	private List<CustomerSummaryVO> summaries;

	public List<CustomerSummaryVO> getSummaries() {
		return summaries;
	}

	public void setSummaries(List<CustomerSummaryVO> summaries) {
		this.summaries = summaries;
	}
}
