package com.serveplus.web.response.mapper.worker;

import java.util.List;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.SrActionHistory;
import com.serveplus.web.response.ServiceRequestVO;
import com.serveplus.web.response.SrActionHistoryVO;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.worker.WorkerServiceRequestDetailResponse;

public class WorkerServiceRequestDetailResponseMapper implements Mapper<ServiceRequest,WorkerServiceRequestDetailResponse>{

	@Override
	public WorkerServiceRequestDetailResponse mapFrom(ServiceRequest source) {
		WorkerServiceRequestDetailResponse response =  new WorkerServiceRequestDetailResponse();
		ServiceRequestToWorkMapper mapper = new ServiceRequestToWorkMapper();
		ServiceRequestVO serviceRequestVO = mapper.mapFrom(source);
		response.setServiceRequest(serviceRequestVO);
		SrActionHistoryMapper actionHistoryMapper = new SrActionHistoryMapper();
		List<SrActionHistory> actionHistories = source.getActionHistories();
		ListToListMapper<SrActionHistory, SrActionHistoryVO> actionHistoryListMapper = new ListToListMapper<SrActionHistory, SrActionHistoryVO>();
		List<SrActionHistoryVO> mappedActionHistories = actionHistoryListMapper.mapFrom(actionHistories, actionHistoryMapper);
		response.setHistory(mappedActionHistories);
		return response;
	}

}
