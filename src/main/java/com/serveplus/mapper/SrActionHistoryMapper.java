package com.serveplus.mapper;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.SrAction;
import com.serveplus.data.entity.SrActionHistory;
import com.serveplus.web.response.mapper.Mapper;

public class SrActionHistoryMapper implements Mapper<ServiceRequest,SrActionHistory>{

	@Override
	public SrActionHistory mapFrom(ServiceRequest source) {
		SrActionHistory actionHistory = new SrActionHistory();
		actionHistory.setServiceRequest(source);
		SrAction action = SrAction.getActionStatus(source.getStatus());
		actionHistory.setAction(action);
		return actionHistory;
	}
	
}
