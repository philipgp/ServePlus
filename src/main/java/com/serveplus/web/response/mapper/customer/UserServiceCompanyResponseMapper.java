package com.serveplus.web.response.mapper.customer;

import java.util.Set;

import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.WorkerService;
import com.serveplus.web.response.customer.ServiceCompanyVO;
import com.serveplus.web.response.customer.UserServiceCompanyResponse;
import com.serveplus.web.response.mapper.ListToSetMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.SetToSetMapper;

public class UserServiceCompanyResponseMapper implements Mapper<Service,UserServiceCompanyResponse>{

	@Override
	public UserServiceCompanyResponse mapFrom(Service source) {
		UserServiceCompanyResponse response = new UserServiceCompanyResponse();
		Set<WorkerService> workerServices = source.getWorkerServices();
		SetToSetMapper<WorkerService, ServiceCompanyVO> mapper = new SetToSetMapper<WorkerService, ServiceCompanyVO>();
		Set<ServiceCompanyVO> mappedList = mapper.mapFrom(workerServices, new WorkerToCompanyServiceMapper());
		response.setCompanies(mappedList);
		return response;
	}
 
}
