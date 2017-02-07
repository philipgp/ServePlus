package com.serveplus.data.dao;

import com.serveplus.data.entity.Assigner;

public interface AssignerDao {
	public Assigner findById(Long id);
	public void save(Assigner assigner);
	public void remove(Assigner assigner);
}
