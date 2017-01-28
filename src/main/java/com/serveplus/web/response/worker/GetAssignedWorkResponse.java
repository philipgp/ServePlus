package com.serveplus.web.response.worker;

import java.util.ArrayList;
import java.util.List;

import com.serveplus.web.request.worker.GetAssignedWorkRequest;
import com.serveplus.web.response.ServePlusResponse;
import com.serveplus.web.response.ServiceRequestVO;

public class GetAssignedWorkResponse extends ServePlusResponse{
	private List<ServiceRequestVO> result;

	public List<ServiceRequestVO> getResult() {
		return result;
	}

	public void setResult(List<ServiceRequestVO> result) {
		this.result = result;
	} 
	public void addWorkVO(ServiceRequestVO workVO){
		if(result == null)
			result = new ArrayList<ServiceRequestVO>();
		result.add(workVO);
	}
}
