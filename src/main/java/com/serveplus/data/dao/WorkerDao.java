package com.serveplus.data.dao;

import java.util.List;

import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.Worker;

public interface WorkerDao {
	public Worker findById(Long id);
	public List<Worker> getAll();
	public List<Worker> getAllFromCompany(Company company);
}
