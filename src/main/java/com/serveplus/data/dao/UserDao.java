package com.serveplus.data.dao;

import java.util.List;

import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.User;

public interface UserDao {
	
	List<User> getAllUsers();

	public void save(User user);

}
