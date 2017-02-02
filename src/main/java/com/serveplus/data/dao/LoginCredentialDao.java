package com.serveplus.data.dao;

import com.serveplus.data.entity.LoginCredentials;

public interface LoginCredentialDao {
	public LoginCredentials getLoginCredentials(String userName,String password);
	public LoginCredentials getLoginCredentials(String userName);
	public void save(LoginCredentials loginCredentials);
}
