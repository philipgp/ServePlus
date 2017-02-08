package com.serveplus.data.dao;

import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.User;

public interface AssignerDao {
	public Assigner findById(Long id);
	public void save(Assigner assigner);
	public void remove(Assigner assigner);
	public Assigner findByUser(User user);
}
