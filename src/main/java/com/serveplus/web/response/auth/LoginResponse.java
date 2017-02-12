package com.serveplus.web.response.auth;

import java.util.List;

import com.serveplus.data.entity.AccountStatus;
import com.serveplus.vo.UserRoleVO;

public class LoginResponse extends AuthResponse {
	private String token;
	private AccountStatus accountStatus;
	private List<UserRoleVO> userRoles;
	
	public List<UserRoleVO> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<UserRoleVO> userRoles) {
		this.userRoles = userRoles;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginResponse [token=").append(token)
				.append(", accountStatus=").append(accountStatus)
				.append(", userRoles=").append(userRoles).append("]");
		return builder.toString();
	}
}
