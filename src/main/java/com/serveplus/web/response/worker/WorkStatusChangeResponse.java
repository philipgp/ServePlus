package com.serveplus.web.response.worker;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.serveplus.DateFormats;

public class WorkStatusChangeResponse {
	private Long regnId;
	@JsonFormat(pattern = DateFormats.yyyyMMddHHmmss)
	private Date date;
	public Long getRegnId() {
		return regnId;
	}
	public void setRegnId(Long regnId) {
		this.regnId = regnId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
