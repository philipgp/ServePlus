package com.serveplus.web.response;

import java.util.ArrayList;
import java.util.List;

import com.serveplus.web.request.GetWorksToAssignRequest;

public class GetAssignedWorkResponse extends ServePlusResponse{
	private List<WorkVO> result;

	public List<WorkVO> getResult() {
		return result;
	}

	public void setResult(List<WorkVO> result) {
		this.result = result;
	} 
	public void addWorkVO(WorkVO workVO){
		if(result == null)
			result = new ArrayList<WorkVO>();
		result.add(workVO);
	}
}
