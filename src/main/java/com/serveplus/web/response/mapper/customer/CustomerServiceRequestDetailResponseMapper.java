package com.serveplus.web.response.mapper.customer;

import java.util.List;

import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.SrActionHistory;
import com.serveplus.web.response.ServiceRequestVO;
import com.serveplus.web.response.SrActionHistoryVO;
import com.serveplus.web.response.customer.CustomerServiceRequestDetailResponse;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.worker.ServiceRequestToWorkMapper;
import com.serveplus.web.response.mapper.worker.SrActionHistoryMapper;
import com.serveplus.web.response.worker.WorkerServiceRequestDetailResponse;

public class CustomerServiceRequestDetailResponseMapper implements Mapper<ServiceRequest,CustomerServiceRequestDetailResponse>{

	@Override
	public CustomerServiceRequestDetailResponse mapFrom(ServiceRequest source) {
		CustomerServiceRequestDetailResponse response =  new CustomerServiceRequestDetailResponse();
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
