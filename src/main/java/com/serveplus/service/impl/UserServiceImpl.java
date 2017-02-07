package com.serveplus.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.serveplus.service.UserService;
import com.serveplus.web.request.register.UserProfileRequest;
import com.serveplus.web.response.user.UserProfileResponse;

@Component
public class UserServiceImpl implements UserService{

	@Override
	public UserProfileResponse getProfile(UserProfileRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
