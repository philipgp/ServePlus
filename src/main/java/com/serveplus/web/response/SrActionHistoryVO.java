package com.serveplus.web.response;

import java.util.Date;

import com.serveplus.data.entity.SrAction;

public class SrActionHistoryVO {
	private SrAction action;
	private Date time;
	public SrAction getAction() {
		return action;
	}
	public void setAction(SrAction action) {
		this.action = action;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
