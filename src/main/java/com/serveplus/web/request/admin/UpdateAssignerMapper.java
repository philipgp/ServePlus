package com.serveplus.web.request.admin;

import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.User;
import com.serveplus.data.entity.Worker;
import com.serveplus.web.request.customer.UserRegisterRequest;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.customer.UserMapper;

public class UpdateAssignerMapper implements Mapper<UpdateAssignerRequest,Assigner>{
	
	private Assigner assigner;
	
	
	
	public UpdateAssignerMapper(Assigner assigner) {
		super();
		this.assigner = assigner;
	}



	@Override
	public Assigner mapFrom(UpdateAssignerRequest source) {
		
		UserMapper userMapper = new UserMapper();
		User user = userMapper.mapFrom(source);
		assigner.getUser().superImpose(user);
		if(source.getActive()!=null)
			assigner.setActive(source.getActive());
		return assigner;
	}
	
	
}
