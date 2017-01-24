package com.serveplus.web.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serveplus.service.WorkerService;
import com.serveplus.web.request.GetAssignedWorkRequest;
import com.serveplus.web.request.StartWorkRequest;
import com.serveplus.web.response.GetAssignedWorkResponse;
import com.serveplus.web.response.StartWorkResponse;

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
	
	
}
