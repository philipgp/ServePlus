package com.serveplus.web.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serveplus.service.AdminService;
import com.serveplus.service.CompanyService;
import com.serveplus.service.CustomerService;
import com.serveplus.web.request.admin.AddNewAdminRequest;
import com.serveplus.web.request.admin.AddNewAssignerRequest;
import com.serveplus.web.request.admin.AddNewCSAssignerRequest;
import com.serveplus.web.request.admin.AddNewCompanyServiceRequest;
import com.serveplus.web.request.admin.AddNewServiceRequest;
import com.serveplus.web.request.admin.AddNewWorkerRequest;
import com.serveplus.web.request.admin.AddNewWorkerServiceRequest;
import com.serveplus.web.request.admin.AdminGetAllServiceRequestRequest;
import com.serveplus.web.request.admin.GetAllCustomerSummaryRequest;
import com.serveplus.web.request.admin.GetAllWorkersSummaryRequest;
import com.serveplus.web.request.admin.GetCustomerServiceRequestRequest;
import com.serveplus.web.request.admin.GetWorkerServiceRequestRequest;
import com.serveplus.web.request.admin.RemoveAssignerRequest;
import com.serveplus.web.request.admin.RemoveCompanyServiceRequest;
import com.serveplus.web.request.admin.RemoveCsAssignerRequest;
import com.serveplus.web.request.admin.RemoveServiceRequest;
import com.serveplus.web.request.admin.RemoveWorkerRequest;
import com.serveplus.web.request.admin.RemoveWorkerServiceRequest;
import com.serveplus.web.request.admin.UpdateAssignerRequest;
import com.serveplus.web.request.admin.UpdateCompanyServiceRequest;
import com.serveplus.web.request.admin.UpdateCsAssigneRequest;
import com.serveplus.web.request.admin.UpdateWorkerRequest;
import com.serveplus.web.request.admin.UpdateWorkerServiceRequest;
import com.serveplus.web.request.customer.UserServiceCompanyRequest;
import com.serveplus.web.request.customer.UserServiceRequest;
import com.serveplus.web.request.worker.CompanyServiceRequest;
import com.serveplus.web.response.admin.AddNewAdminResponse;
import com.serveplus.web.response.admin.AddNewAssignerResponse;
import com.serveplus.web.response.admin.AddNewCompanyServiceResponse;
import com.serveplus.web.response.admin.AddNewCsAssignerResponse;
import com.serveplus.web.response.admin.AddNewServiceResponse;
import com.serveplus.web.response.admin.AddNewWorkerResponse;
import com.serveplus.web.response.admin.AdminGetAllServiceRequestResponse;
import com.serveplus.web.response.admin.BooleanResponse;
import com.serveplus.web.response.admin.GetAllCustomerSummaryResponse;
import com.serveplus.web.response.admin.GetAllWorkersSummaryResponse;
import com.serveplus.web.response.admin.GetForCustomerServiceRequestResponse;
import com.serveplus.web.response.admin.GetForWorkerServiceRequestResponse;
import com.serveplus.web.response.customer.CompanyServiceResponse;
import com.serveplus.web.response.customer.UserServiceCompanyResponse;
import com.serveplus.web.response.customer.UserServiceResponse;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	static Logger log = Logger.getLogger(AdminController.class.getName());
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CompanyService companyService;
	
	@RequestMapping(value = "/getServices", method = RequestMethod.POST)
	@ResponseBody
	public UserServiceResponse getServices(@RequestBody UserServiceRequest request){
		return customerService.getServices(request);
	}
	
	@RequestMapping(value = "/getAllServiceRequests", method = RequestMethod.POST)
	@ResponseBody
	public AdminGetAllServiceRequestResponse getWorkerForService(@RequestBody AdminGetAllServiceRequestRequest request){
		return adminService.getAllServiceRequests(request);
	}
	
	@RequestMapping(value = "/getServiceCompanies", method = RequestMethod.POST)
	@ResponseBody
	public UserServiceCompanyResponse getServiceCompanies(@RequestBody UserServiceCompanyRequest request){
		return customerService.getServiceCompanies(request);
	} 
	 
	@RequestMapping(value = "/getCustomerServiceRequests", method = RequestMethod.POST)
	@ResponseBody
	public GetForCustomerServiceRequestResponse getCustomerServiceRequests(@RequestBody GetCustomerServiceRequestRequest request){
		return adminService.getCustomerServiceRequest(request);
	}
	
	@RequestMapping(value = "/getWorkerServiceRequests", method = RequestMethod.POST)
	@ResponseBody
	public GetForWorkerServiceRequestResponse getWorkerServiceRequests(@RequestBody GetWorkerServiceRequestRequest request){
		return adminService.getWorkerServiceRequests(request);
	}
	
	@RequestMapping(value = "/getAllWorkersSummary", method = RequestMethod.POST)
	@ResponseBody
	public GetAllWorkersSummaryResponse getWorkerServiceRequests(@RequestBody GetAllWorkersSummaryRequest request){
		return adminService.getAllWorkersSummary(request);
	}
	
	@RequestMapping(value = "/getAllCustomerSummary", method = RequestMethod.POST)
	@ResponseBody
	public GetAllCustomerSummaryResponse getAllCustomerSummary(@RequestBody GetAllCustomerSummaryRequest request){
		return adminService.getALlCustomerSummary(request);
	}
	
	@RequestMapping(value = "/addNewService", method = RequestMethod.POST)
	@ResponseBody
	public AddNewServiceResponse addNewService(@RequestBody AddNewServiceRequest request){
		return adminService.addNewService(request);
	}
	@RequestMapping(value = "/getCompanyServices", method = RequestMethod.POST)
	@ResponseBody
	public CompanyServiceResponse getCompanyServices(@RequestBody CompanyServiceRequest request){
		return companyService.getAllCompanyService(request);
	} 
	@RequestMapping(value = "/addNewWorkerService", method = RequestMethod.POST)
	@ResponseBody
	public BooleanResponse addNewWorkerService(@RequestBody AddNewWorkerServiceRequest request){
		return adminService.addNewWorkerService(request);
	}
	
	@RequestMapping(value = "/addNewCompanyService", method = RequestMethod.POST)
	@ResponseBody
	public AddNewCompanyServiceResponse addNewCompanyService(@RequestBody AddNewCompanyServiceRequest request){
		return adminService.addNewCompanyService(request);
	}
	
	@RequestMapping(value = "/addNewCsAssigner", method = RequestMethod.POST)
	@ResponseBody
	public AddNewCsAssignerResponse addNewCsAssigner(@RequestBody AddNewCSAssignerRequest request){
		return adminService.addNewCsAssigner(request);
	}
	
	@RequestMapping(value = "/addNewWorker", method = RequestMethod.POST)
	@ResponseBody
	public AddNewWorkerResponse addNewWorker(@RequestBody AddNewWorkerRequest request){
		return adminService.addNewWorker(request);
	}
	
	@RequestMapping(value = "/addNewAssigner", method = RequestMethod.POST)
	@ResponseBody
	public AddNewAssignerResponse addNewAssigner(@RequestBody AddNewAssignerRequest request){
		return adminService.addNewAssigner(request);
	}
	
	@RequestMapping(value = "/removeAssigner", method = RequestMethod.POST)
	@ResponseBody
	public BooleanResponse removeAssigner(@RequestBody RemoveAssignerRequest request){
		return adminService.removeAssigner(request);
	}
	
	@RequestMapping(value = "/removeWorker", method = RequestMethod.POST)
	@ResponseBody
	public BooleanResponse removeWorker(@RequestBody RemoveWorkerRequest request){
		return adminService.removeWorker(request);
	}
	
	@RequestMapping(value = "/removeCompanyService", method = RequestMethod.POST)
	@ResponseBody
	public BooleanResponse removeCompanyService(@RequestBody RemoveCompanyServiceRequest request){
		return adminService.removeCompanyService(request);
	}
	
	@RequestMapping(value = "/removeWorkerService", method = RequestMethod.POST)
	@ResponseBody
	public BooleanResponse removeWorkerService(@RequestBody RemoveWorkerServiceRequest request){
		return adminService.removeWorkerService(request);
	}
	
	@RequestMapping(value = "/removeService", method = RequestMethod.POST)
	@ResponseBody
	public BooleanResponse removeService(@RequestBody RemoveServiceRequest request){
		return adminService.removeService(request);
	}
	
	@RequestMapping(value = "/removeCsAssigner", method = RequestMethod.POST)
	@ResponseBody
	public BooleanResponse removeCsAssigner(@RequestBody RemoveCsAssignerRequest request){
		return adminService.removeCsAssigner(request);
	}
	
	@RequestMapping(value = "/updateWorker", method = RequestMethod.POST)
	@ResponseBody
	public BooleanResponse updateWorker(@RequestBody UpdateWorkerRequest request){
		return adminService.updateWorker(request);
	}
	
	@RequestMapping(value = "/updateAssigner", method = RequestMethod.POST)
	@ResponseBody
	public BooleanResponse updateAssigner(@RequestBody UpdateAssignerRequest request){
		return adminService.updateAssigner(request); 
	}
	@RequestMapping(value = "/updateCompanyService", method = RequestMethod.POST)
	@ResponseBody
	public BooleanResponse updateCompanyService(@RequestBody UpdateCompanyServiceRequest request){
		return adminService.updateCompanyService(request); 
	}
	
	@RequestMapping(value = "/updateWorkerService", method = RequestMethod.POST)
	@ResponseBody
	public BooleanResponse updateWorkerService(@RequestBody UpdateWorkerServiceRequest request){
		return adminService.updateWorkerService(request); 
	}
	
	@RequestMapping(value = "/updateCsAssigner", method = RequestMethod.POST)
	@ResponseBody
	public BooleanResponse updateCsAssigner(@RequestBody UpdateCsAssigneRequest request){
		return adminService.updateCsAssigner(request); 
	}
	
	@RequestMapping(value = "/addNewAdmin", method = RequestMethod.POST)
	@ResponseBody
	public AddNewAdminResponse addNewAdmin(@RequestBody AddNewAdminRequest request){
		return adminService.addNewAdmin(request);
	}
}
