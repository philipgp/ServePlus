package com.serveplus.data.dao;


import java.util.List;

import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.WorkerService;

public interface WorkerServiceDao {
	public List<WorkerService> findWorkerService(Company company,Service service);
}
