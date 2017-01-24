package com.serveplus.web.response;

import com.serveplus.ResultMessage;

public class ServePlusResponse {
	private ResultMessage message;
	private Integer resultCode;
	public ResultMessage getMessage() {
		return message;
	}
	public void setMessage(ResultMessage message) {
		this.message = message;
	}
	public Integer getResultCode() {
		return resultCode;
	}
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}
	
}
