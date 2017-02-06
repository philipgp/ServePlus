package com.serveplus.web.response.assigner.mapper;

import java.util.List;

import com.serveplus.data.entity.WorkerService;
import com.serveplus.web.response.assigner.WorkerForServiceVO;
import com.serveplus.web.response.auth.GetWorkerForServiceResponse;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.Mapper;

public class GetWorkerForServiceResponseMapper implements Mapper<List<WorkerService>,GetWorkerForServiceResponse>{

	@Override
	public GetWorkerForServiceResponse mapFrom(List<WorkerService> source) {
		ListToListMapper<WorkerService,WorkerForServiceVO> listMapper = new ListToListMapper<WorkerService, WorkerForServiceVO>();
		List<WorkerForServiceVO> mappedList = listMapper.mapFrom(source, new WorkerForServiceVOMapper());
		GetWorkerForServiceResponse response = new GetWorkerForServiceResponse();
		response.setWorkers(mappedList);
		return response;
	}

}
