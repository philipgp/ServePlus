package com.serveplus.web.request.admin;

import com.serveplus.data.entity.Admin;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.data.entity.User;
import com.serveplus.data.entity.Worker;
import com.serveplus.web.request.customer.LoginCredentialsMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.customer.UserMapper;

public class WorkerMapper implements Mapper<AddNewWorkerRequest,Worker>{
	private Company company;
	public WorkerMapper(Company company) {
		super();
		this.company = company;
	}
	@Override
	public Worker mapFrom(AddNewWorkerRequest source) {
		Worker worker = new Worker();
		
		UserMapper userMapper = new UserMapper();
		User user = userMapper.mapFrom(source);
		LoginCredentialsMapper loginCredentialsMapper = new  LoginCredentialsMapper();
		LoginCredentials loginCredentials = loginCredentialsMapper.mapFrom(source); 
		user.setLoginCredentials(loginCredentials);
		worker.setCompany(company);
		return worker;
	}

}
