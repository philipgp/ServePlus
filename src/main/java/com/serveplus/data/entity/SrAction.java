package com.serveplus.data.entity;

public enum SrAction {
	REGISTERED,STARTED;
	
	public static SrAction getActionStatus(ServiceRequestStatus from,ServiceRequestStatus to){
		if(to==ServiceRequestStatus.REGISTERED){
			return REGISTERED;
		}else
			return STARTED;
	}
	
}
