package com.serveplus.web.response.assigner;

import java.util.List;

import com.serveplus.web.response.ServePlusResponse;

public class GetWorksToAssignResponse extends ServePlusResponse{
	private List<AssignerWork> works;

	public List<AssignerWork> getWorks() {
		return works;
	}

	public void setWorks(List<AssignerWork> works) {
		this.works = works;
	}
}
