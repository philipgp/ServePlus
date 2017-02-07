package com.serveplus.web.response.admin;

import com.serveplus.data.entity.Assigner;
import com.serveplus.web.response.mapper.Mapper;

public class AddNewAssignerResponseMapper implements Mapper<Assigner,AddNewAssignerResponse>{

	@Override
	public AddNewAssignerResponse mapFrom(Assigner source) {
		AddNewAssignerResponse response = new AddNewAssignerResponse();
		response.setStatus(Boolean.TRUE);
		response.setAssignerId(source.getId());
		return response;
	}

}
