package com.serveplus.mapper;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.SrAction;
import com.serveplus.data.entity.SrActionHistory;
import com.serveplus.web.response.mapper.Mapper;

public class SrActionHistoryMapper implements Mapper<ServiceRequest,SrActionHistory>{

	private SrAction newAction;
	
	public SrActionHistoryMapper(SrAction newAction) {
		super();
		this.newAction = newAction;
	}
	public SrActionHistoryMapper(){
		
	}

	@Override
	public SrActionHistory mapFrom(ServiceRequest source) {
		SrActionHistory actionHistory = new SrActionHistory();
		actionHistory.setServiceRequest(source);
		
		SrAction action = null;
		if(newAction== null)
			action = SrAction.getActionStatus(source.getStatus());
		else
			action = newAction;
		actionHistory.setAction(action);
		return actionHistory;
	}
	
}
