package com.serveplus.web.request.admin;

import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.data.entity.User;
import com.serveplus.web.request.customer.LoginCredentialsMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.customer.UserMapper;

public class AssignerMapper implements Mapper<AddNewAssignerRequest,Assigner>{
	private Company company;
	public AssignerMapper(Company company) {
		super();
		this.company = company;
	}
	@Override
	public Assigner mapFrom(AddNewAssignerRequest source) {
		Assigner assigner = new Assigner();
		
		UserMapper userMapper = new UserMapper();
		User user = userMapper.mapFrom(source);
		LoginCredentialsMapper loginCredentialsMapper = new  LoginCredentialsMapper();
		LoginCredentials loginCredentials = loginCredentialsMapper.mapFrom(source); 
		user.setLoginCredentials(loginCredentials);
		assigner.setCompany(company);
		return assigner;
	}

}
