package com.serveplus.web.response.admin;

import com.serveplus.data.entity.Admin;
import com.serveplus.web.response.mapper.Mapper;

public class AddNewAdminResponseMapper implements Mapper<Admin,AddNewAdminResponse>{

	@Override
	public AddNewAdminResponse mapFrom(Admin source) {
		AddNewAdminResponse response = new AddNewAdminResponse();
		response.setStatus(Boolean.TRUE);
		response.setAdminId(source.getId());
		return response;
	}

}
