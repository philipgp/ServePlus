package com.serveplus.web.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serveplus.service.WorkerService;
import com.serveplus.web.request.worker.GetAssignedWorkRequest;
import com.serveplus.web.request.worker.StartWorkRequest;
import com.serveplus.web.request.worker.WorkClosedRequest;
import com.serveplus.web.request.worker.WorkCompletedRequest;
import com.serveplus.web.request.worker.WorkerServiceRequestDetailRequest;
import com.serveplus.web.response.worker.GetAssignedWorkResponse;
import com.serveplus.web.response.worker.StartWorkResponse;
import com.serveplus.web.response.worker.WorkClosedResponse;
import com.serveplus.web.response.worker.WorkCompletedResponse;
import com.serveplus.web.response.worker.WorkerServiceRequestDetailResponse;

@Controller
@RequestMapping("/worker")
public class WorkerController {
	
	static Logger log = Logger.getLogger(WorkerController.class.getName());
	
	
	@Autowired
	WorkerService workerService;
	
	@RequestMapping(value = "/getAssignedWorks", method = RequestMethod.POST)
	@ResponseBody
	public GetAssignedWorkResponse getAssignedWorks(@RequestBody GetAssignedWorkRequest request){
		return workerService.getAssignedWorks(request);
	}
	
	@RequestMapping(value = "/startWork", method = RequestMethod.POST)
	@ResponseBody
	public StartWorkResponse startWork(@RequestBody StartWorkRequest request){
		return workerService.startWork(request);
	}
	
	@RequestMapping(value = "/workCompleted", method = RequestMethod.POST)
	@ResponseBody
	public WorkCompletedResponse workCompleted(@RequestBody WorkCompletedRequest request){
		return workerService.completedWork(request);
	}
	
	@RequestMapping(value = "/workClosed", method = RequestMethod.POST)
	@ResponseBody
	public WorkClosedResponse workClosed(@RequestBody WorkClosedRequest request){
		return workerService.closeWork(request);
	}
	
	@RequestMapping(value = "/getServiceRequestDetail", method = RequestMethod.POST)
	@ResponseBody
	public WorkerServiceRequestDetailResponse getServiceRequestDetail(@RequestBody WorkerServiceRequestDetailRequest request){
		return workerService.getServiceRequestDetail(request);
	}
	
	
}
