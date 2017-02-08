package com.serveplus.web.request.admin;

import com.serveplus.data.entity.CsAssigner;
import com.serveplus.web.response.mapper.Mapper;

public class UpdateCsAssigneMapper implements Mapper<UpdateCsAssigneRequest,CsAssigner>{
	CsAssigner csAssigner;
	public UpdateCsAssigneMapper(CsAssigner csAssigner) {
		super();
		this.csAssigner = csAssigner;
	}
	@Override
	public CsAssigner mapFrom(UpdateCsAssigneRequest source) {
		if(source.getActive() != null)
			csAssigner.setActive(source.getActive());
		if(source.getIsDefault() != null)
			csAssigner.setIsDefault(source.getIsDefault());
		return csAssigner;
	}

}
