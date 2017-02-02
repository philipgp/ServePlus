package com.serveplus.service;

import com.serveplus.web.request.auth.LoginRequest;
import com.serveplus.web.response.auth.LoginResponse;

public interface AuthService {
	public LoginResponse login(LoginRequest request);
}
