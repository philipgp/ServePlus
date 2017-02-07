package com.serveplus.web.response.admin.mapper;

import java.util.List;

import com.serveplus.data.entity.Worker;
import com.serveplus.web.response.admin.GetAllWorkersSummaryResponse;
import com.serveplus.web.response.admin.WorkerSummaryVO;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.Mapper;

public class GetAllWorkersSummaryResponseMapper implements Mapper<List<Worker>,GetAllWorkersSummaryResponse>{

	@Override
	public GetAllWorkersSummaryResponse mapFrom(List<Worker> source) {
		GetAllWorkersSummaryResponse response = new GetAllWorkersSummaryResponse();
		ListToListMapper<Worker,WorkerSummaryVO> listMapper = new ListToListMapper<>();
		List<WorkerSummaryVO> mappedList = listMapper.mapFrom(source, new WorkerSummaryVOMapper());
		response.setWorkers(mappedList);
		return response;
	}

}
