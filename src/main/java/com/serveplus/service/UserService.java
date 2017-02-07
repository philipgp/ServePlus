package com.serveplus.service;

import com.serveplus.web.request.register.UserProfileRequest;
import com.serveplus.web.response.user.UserProfileResponse;

public interface UserService {
	public UserProfileResponse getProfile(UserProfileRequest request);
}
