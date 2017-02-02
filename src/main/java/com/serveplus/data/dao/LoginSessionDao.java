package com.serveplus.data.dao;

import java.util.Set;

import com.serveplus.data.entity.LoginSession;

public interface LoginSessionDao {
	public void save(LoginSession loginSession);
	public void remove(LoginSession loginSession);
	public void removeAll(Set<LoginSession> loginSession);
	public LoginSession getLoginSessionByToken(String token);
}
