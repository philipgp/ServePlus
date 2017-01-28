package com.serveplus.web.response.worker;

import java.util.List;

import com.serveplus.web.response.ServiceRequestVO;
import com.serveplus.web.response.SrActionHistoryVO;

public class WorkerServiceRequestDetailResponse extends WorkerServiceBaseResponse{
	ServiceRequestVO serviceRequest;
	private List<SrActionHistoryVO> history;

	public ServiceRequestVO getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequestVO serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	public List<SrActionHistoryVO> getHistory() {
		return history;
	}

	public void setHistory(List<SrActionHistoryVO> history) {
		this.history = history;
	}
}
