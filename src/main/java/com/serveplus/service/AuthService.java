package com.serveplus.service;

import com.serveplus.web.request.auth.ChangePasswordRequest;
import com.serveplus.web.request.auth.ForgetPasswordRequest;
import com.serveplus.web.request.auth.LoginRequest;
import com.serveplus.web.request.auth.LogoutRequest;
import com.serveplus.web.response.auth.ChangePasswordResponse;
import com.serveplus.web.response.auth.ForgetPasswordResponse;
import com.serveplus.web.response.auth.LoginResponse;
import com.serveplus.web.response.auth.LogoutResponse;

public interface AuthService {
	public LoginResponse login(LoginRequest request);
	public LogoutResponse logout(LogoutRequest request);
	public ChangePasswordResponse changePassword(ChangePasswordRequest request);
	public ForgetPasswordResponse forgotPassword(ForgetPasswordRequest request);
}
