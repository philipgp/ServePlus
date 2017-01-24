package com.serveplus;

public enum ResultCode {
	SUCCESS(1),FAILURE(2);
	private Integer code;
	ResultCode(Integer code){
		this.code = code;
	}
	public Integer getCode(){
		return code;
	}
}
