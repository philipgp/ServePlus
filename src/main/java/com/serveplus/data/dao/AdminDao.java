package com.serveplus.data.dao;

import com.serveplus.data.entity.Admin;

public interface AdminDao {
	public Admin findById(Long id);
	public void save(Admin admin);
}
