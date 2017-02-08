package com.serveplus.web.request.admin;

import org.apache.commons.lang3.StringUtils;

import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.data.entity.User;
import com.serveplus.data.entity.Worker;
import com.serveplus.web.request.customer.LoginCredentialsMapper;
import com.serveplus.web.request.customer.UserRegisterRequest;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.customer.UserMapper;

public class UpdateWorkerMapper implements Mapper<UpdateWorkerRequest,Worker>{
	
	private Worker worker;
	
	public UpdateWorkerMapper(Worker worker) {
		super();
		this.worker = worker;
	}

	
	@Override
	public Worker mapFrom(UpdateWorkerRequest source) {
		
		UserMapper userMapper = new UserMapper();
		User user = userMapper.mapFrom(source);
		worker.getUser().superImpose(user);
		if(source.getActive()!=null)
			worker.setActive(source.getActive());
		return worker;
	}
	
	
}
