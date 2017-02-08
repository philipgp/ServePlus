package com.serveplus.data.dao;


import java.util.List;

import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.Worker;
import com.serveplus.data.entity.WorkerService;

public interface WorkerServiceDao {
	public List<WorkerService> findWorkerService(Company company,Service service);

	public WorkerService findBy(Service service, Worker worker);

	public void save(WorkerService workerService);

	public void remove(WorkerService workerService);
}
