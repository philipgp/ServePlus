package com.serveplus.data.dao;

import com.serveplus.data.entity.Admin;
import com.serveplus.data.entity.User;

public interface AdminDao {
	public Admin findById(Long id);
	public void save(Admin admin);
	public Admin findByUser(User user);
}
