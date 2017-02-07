package com.serveplus.data.dao;

import java.util.List;

import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.User;

public interface ServiceDao {
	
	List<Service> getActiveServices();
	Service findById(Long id);
	public void save(Service service);
	void remove(Service service);

}
