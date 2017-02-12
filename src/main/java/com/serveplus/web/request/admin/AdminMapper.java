package com.serveplus.web.request.admin;

import com.serveplus.data.entity.Admin;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.data.entity.User;
import com.serveplus.web.request.customer.LoginCredentialsMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.customer.UserMapper;

public class AdminMapper implements Mapper<AddNewAdminRequest,Admin>{
	private Company company;
	public AdminMapper(Company company) {
		super();
		this.company = company;
	}
	@Override
	public Admin mapFrom(AddNewAdminRequest source) {
		Admin admin = new Admin();
		
		UserMapper userMapper = new UserMapper();
		User user = userMapper.mapFrom(source);
		admin.setUser(user);
		LoginCredentialsMapper loginCredentialsMapper = new  LoginCredentialsMapper();
		LoginCredentials loginCredentials = loginCredentialsMapper.mapFrom(source); 
		user.setLoginCredentials(loginCredentials);
		admin.setCompany(company);
		Assigner assigner = new Assigner();
		assigner.setUser(user);
		assigner.setAdmin(admin);
		admin.setAssigner(assigner);
		return admin;
	}

}
