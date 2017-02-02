package com.serveplus.web.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serveplus.service.AuthService;
import com.serveplus.service.WorkerService;
import com.serveplus.web.request.auth.ChangePasswordRequest;
import com.serveplus.web.request.auth.ForgetPasswordRequest;
import com.serveplus.web.request.auth.LoginRequest;
import com.serveplus.web.request.auth.LogoutRequest;
import com.serveplus.web.request.worker.GetAssignedWorkRequest;
import com.serveplus.web.request.worker.StartWorkRequest;
import com.serveplus.web.request.worker.WorkClosedRequest;
import com.serveplus.web.request.worker.WorkCompletedRequest;
import com.serveplus.web.request.worker.WorkerServiceRequestDetailRequest;
import com.serveplus.web.response.auth.ChangePasswordResponse;
import com.serveplus.web.response.auth.ForgetPasswordResponse;
import com.serveplus.web.response.auth.LoginResponse;
import com.serveplus.web.response.auth.LogoutResponse;
import com.serveplus.web.response.worker.GetAssignedWorkResponse;
import com.serveplus.web.response.worker.StartWorkResponse;
import com.serveplus.web.response.worker.WorkClosedResponse;
import com.serveplus.web.response.worker.WorkCompletedResponse;
import com.serveplus.web.response.worker.WorkerServiceRequestDetailResponse;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	static Logger log = Logger.getLogger(AuthController.class.getName());
	
	@Autowired
	AuthService authService;

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public LoginResponse login(@RequestBody LoginRequest request){
		return authService.login(request); 
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
	public LogoutResponse logout(@RequestBody LogoutRequest request){
		return authService.logout(request);
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	@ResponseBody
	public ChangePasswordResponse changePassword(@RequestBody ChangePasswordRequest request){
		return authService.changePassword(request);
	}
	
	@RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
	@ResponseBody
	public ForgetPasswordResponse forgetPassword(@RequestBody ForgetPasswordRequest request){
		return authService.forgotPassword(request);
	}
	
	
}
