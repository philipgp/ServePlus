package com.serveplus.web.response;

import com.serveplus.web.response.auth.ConfirmUserRegnResponse;
import com.serveplus.web.response.mapper.Mapper;

public class ConfirmUserRegnResponseMapper implements Mapper<Boolean,ConfirmUserRegnResponse>{

	@Override
	public ConfirmUserRegnResponse mapFrom(Boolean source) {
		ConfirmUserRegnResponse response = new  ConfirmUserRegnResponse();
		response.setStatus(source);
		return response;
	}

}
