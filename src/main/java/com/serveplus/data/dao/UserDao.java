package com.serveplus.data.dao;

import java.util.List;

import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.data.entity.User;

public interface UserDao {
	
	List<User> getAllUsers();
	
	User getUserByLoginCredential(LoginCredentials loginCredentials);


	public void save(User user);
	
/*	public void saveOrUpdate(User user);
*/
}
