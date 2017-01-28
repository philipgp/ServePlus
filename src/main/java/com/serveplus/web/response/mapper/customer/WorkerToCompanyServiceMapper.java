package com.serveplus.web.response.mapper.customer;

import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.Worker;
import com.serveplus.data.entity.WorkerService;
import com.serveplus.web.response.customer.ServiceCompanyVO;
import com.serveplus.web.response.mapper.Mapper;

public class WorkerToCompanyServiceMapper implements Mapper<WorkerService,ServiceCompanyVO>{

	@Override
	public ServiceCompanyVO mapFrom(WorkerService source) {
		ServiceCompanyVO serviceCompany = new ServiceCompanyVO();
		Company company = source.getWorkerServiceId().getWorker().getCompany();
		if(company!=null){
			serviceCompany.setCompanyId(company.getId());
			serviceCompany.setCompanyName(company.getName());
		}
		return serviceCompany;
	}

}
