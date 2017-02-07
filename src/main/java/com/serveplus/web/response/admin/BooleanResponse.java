package com.serveplus.web.response.admin;

import com.serveplus.web.response.ServePlusResponse;

public class BooleanResponse extends ServePlusResponse{
private Boolean status;

public BooleanResponse(Boolean status) {
	super();
	this.status = status;
}
public BooleanResponse(){
	
}

public Boolean getStatus() {
	return status;
}

public void setStatus(Boolean status) {
	this.status = status;
}
}
