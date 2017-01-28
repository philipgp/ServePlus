package com.serveplus.data.entity;

public enum SrAction {
	REGISTERED,STARTED,COMPLETED,ASSIGNED;
	
	public static SrAction getActionStatus(ServiceRequestStatus to){
		if(to==ServiceRequestStatus.REGISTERED){
			return REGISTERED;
		}else if(to ==ServiceRequestStatus.COMPLETED)
			return COMPLETED;
		else if(to ==ServiceRequestStatus.ASSIGNED)
			return ASSIGNED;
		else
			return STARTED;
	}
	
}
