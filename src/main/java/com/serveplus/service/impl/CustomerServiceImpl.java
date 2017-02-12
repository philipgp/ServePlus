package com.serveplus.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.CompanyDao;
import com.serveplus.data.dao.CompanyServiceDao;
import com.serveplus.data.dao.CompanyServiceRatingQuestionDao;
import com.serveplus.data.dao.CsAssignerDao;
import com.serveplus.data.dao.CustomerDao;
import com.serveplus.data.dao.ServiceContactDetailDao;
import com.serveplus.data.dao.ServiceDao;
import com.serveplus.data.dao.ServiceRatingQuestionDao;
import com.serveplus.data.dao.ServiceRequestDao;
import com.serveplus.data.dao.ServiceRequestRatingFeedbackDao;
import com.serveplus.data.dao.SrRatingDao;
import com.serveplus.data.dao.UserAddressDap;
import com.serveplus.data.entity.Company;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.CompanyServiceRatingQuestion;
import com.serveplus.data.entity.CsAssigner;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.LoginCredentials;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceRatingQuestion;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.ServiceRequestRatingFeedback;
import com.serveplus.mapper.ServiceRequestMapper;
import com.serveplus.mapper.UpdateServiceRequestMapper;
import com.serveplus.service.CustomerService;
import com.serveplus.service.ServePlusMailService;
import com.serveplus.vo.MailVO;
import com.serveplus.web.request.customer.CreateServiceRequest;
import com.serveplus.web.request.customer.CustomerMapper;
import com.serveplus.web.request.customer.CustomerRegisterRequest;
import com.serveplus.web.request.customer.CustomerServiceRequestDetailRequest;
import com.serveplus.web.request.customer.GetCustomerServiceRequest;
import com.serveplus.web.request.customer.GetFeedbackRequest;
import com.serveplus.web.request.customer.RatingFeedbackRequest;
import com.serveplus.web.request.customer.RatingFeedbackVO;
import com.serveplus.web.request.customer.RatingQuestionRequest;
import com.serveplus.web.request.customer.ServiceRequestFeedbackMapper;
import com.serveplus.web.request.customer.UpdateServiceRequest;
import com.serveplus.web.request.customer.UserServiceCompanyRequest;
import com.serveplus.web.request.customer.UserServiceRequest;
import com.serveplus.web.response.customer.CustomerRegisterResponse;
import com.serveplus.web.response.customer.CustomerServiceRequestDetailResponse;
import com.serveplus.web.response.customer.GetCustomerServiceRequestResponse;
import com.serveplus.web.response.customer.GetFeedbackResponse;
import com.serveplus.web.response.customer.RatingFeedbackResponse;
import com.serveplus.web.response.customer.RatingQuestionResponse;
import com.serveplus.web.response.customer.UpdateServiceRequestResponse;
import com.serveplus.web.response.customer.UserServiceCompanyResponse;
import com.serveplus.web.response.customer.UserServiceResponse;
import com.serveplus.web.response.mapper.CreateServiceRequestResponse;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.customer.CreateServiceRequestResponseMapper;
import com.serveplus.web.response.mapper.customer.CustomerResponseMapper;
import com.serveplus.web.response.mapper.customer.CustomerServiceRequestDetailResponseMapper;
import com.serveplus.web.response.mapper.customer.GetCustomerServiceRequestResponseMapper;
import com.serveplus.web.response.mapper.customer.GetFeedbackResponseMapper;
import com.serveplus.web.response.mapper.customer.RatingQuestionResponseMapper;
import com.serveplus.web.response.mapper.customer.UpdateServiceRequestResponseMapper;
import com.serveplus.web.response.mapper.customer.UserServiceCompanyResponseMapper;
import com.serveplus.web.response.mapper.customer.UserServiceResponseMapper;

@Component
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	ServiceDao serviceDao;
	

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CsAssignerDao csAssignerDao;
	
	@Autowired
	CompanyServiceDao companyServiceDao;
	
	@Autowired
	CompanyServiceRatingQuestionDao companyServiceRatingQuestionDao;
	
	@Autowired
	ServiceRatingQuestionDao serviceRatingQuestionDao;
	
	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	ServiceRequestDao serviceRequestDao;
	
	@Autowired
	ServiceContactDetailDao serviceContactDetailDao;
	
	@Autowired
	SrRatingDao srRatingDao;
	
	@Autowired
	UserAddressDap userAddressDao;
	
	@Autowired
	ServePlusMailService servePlusMailService;
	
	@Autowired
	ServiceRequestRatingFeedbackDao serviceRequestRatingFeedbackDao;
	
	@Override
	public UserServiceResponse getServices(UserServiceRequest request) {
		List<Service> activeServices = serviceDao.getActiveServices();
		UserServiceResponseMapper mapper = new UserServiceResponseMapper();
		UserServiceResponse response = mapper.mapFrom(activeServices);
		return response;
	}

	@Override
	public UserServiceCompanyResponse getServiceCompanies(
			UserServiceCompanyRequest request) {
		Service service = serviceDao.findById(request.getServiceId());
		UserServiceCompanyResponseMapper mapper = new UserServiceCompanyResponseMapper();
		UserServiceCompanyResponse mappedResponse = mapper.mapFrom(service);
		return mappedResponse;
	}

	@Override
	public CreateServiceRequestResponse createServiceRequest(
			CreateServiceRequest request) {
		
		Customer customer = customerDao.findById(request.getCustomerId());
		Service service = serviceDao.findById(request.getServiceId());
		Company company = companyDao.findById(request.getCompanyId());
		CompanyService companyService = companyServiceDao.findBy(company, service);
		List<CsAssigner> csAssigners = csAssignerDao.findBy(companyService);
		ServiceRequestMapper mapper = new ServiceRequestMapper(customer,companyService,null);
		ServiceRequest serviceRequest= mapper.mapFrom(request);
		/*Set<ServiceContactDetail> serviceContactDetails = serviceRequest.getServiceContactDetails();*/
/*		UserAddress userAddress = new UserAddress();
		UserAddresId userAddressId = new UserAddresId();
		userAddressId.setUser(customer.getUser());
		Address address = new Address();
		userAddressId.setAddress(address);
		userAddress.setUserAddressId(userAddressId);
		userAddressDao.save(userAddress);*/
		//serviceContactDetailDao.saveServiceContactDetails(serviceRequest.getServiceContactDetails());
		serviceRequestDao.save(serviceRequest);
		CreateServiceRequestResponseMapper responseMapper = new CreateServiceRequestResponseMapper();
		CreateServiceRequestResponse response = responseMapper.mapFrom(serviceRequest);
		return response;	
	}

	@Override
	public GetCustomerServiceRequestResponse getServiceRequests(
			GetCustomerServiceRequest request) {
		List<ServiceRequest> serviceRequests = serviceRequestDao.getServiceRequestsByCustomerId(request.getCustomerId());
		GetCustomerServiceRequestResponseMapper responseMapper = new GetCustomerServiceRequestResponseMapper();
		GetCustomerServiceRequestResponse response = responseMapper.mapFrom(serviceRequests);
		return response;
	}

	@Override
	public CustomerServiceRequestDetailResponse getServiceRequestDetail(
			CustomerServiceRequestDetailRequest request) {
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestById(request.getServiceRequestId());
		CustomerServiceRequestDetailResponseMapper mapper = new CustomerServiceRequestDetailResponseMapper();
		CustomerServiceRequestDetailResponse response = mapper.mapFrom(serviceRequest);
		return response;
	}

	@Override
	public UpdateServiceRequestResponse updateServiceRequest(
			UpdateServiceRequest request) {
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestById(request.getServiceRequestId());
		UpdateServiceRequestMapper serviceRequestMapper = new UpdateServiceRequestMapper(serviceRequest);
		serviceRequest = serviceRequestMapper.mapFrom(request);
		serviceRequestDao.save(serviceRequest); 
		UpdateServiceRequestResponseMapper updateServiceResponseMapper = new UpdateServiceRequestResponseMapper();
		UpdateServiceRequestResponse updateServiceResponse = updateServiceResponseMapper.mapFrom(serviceRequest);
		return updateServiceResponse;
	}

	@Override
	public RatingQuestionResponse getRatingQuestions(
			RatingQuestionRequest request) {
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestById(request.getServiceRequestId());
		CompanyService companyService = serviceRequest.getCompanyService();
		List<CompanyServiceRatingQuestion> companyServiceRatingQuestions = companyServiceRatingQuestionDao.findBy(companyService);
		List<ServiceRatingQuestion> serviceRatingQuestions = serviceRatingQuestionDao.findBy(companyService.getService());
		RatingQuestionResponseMapper responseMapper = new RatingQuestionResponseMapper(serviceRatingQuestions, companyServiceRatingQuestions);
		RatingQuestionResponse response = responseMapper.mapFrom();
		return response;
	}

	@Override
	public RatingFeedbackResponse setFeedback(RatingFeedbackRequest request) {
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestById(request.getServiceRequestId());
		ListToListMapper< RatingFeedbackVO, ServiceRequestRatingFeedback> feedbackMapper = new ListToListMapper<RatingFeedbackVO, ServiceRequestRatingFeedback>();
		List<ServiceRequestRatingFeedback> mappedFeedback = feedbackMapper.mapFrom(request.getFeedbacks(), new ServiceRequestFeedbackMapper(serviceRequest));
		srRatingDao.saveAll(mappedFeedback);
		serviceRequest.setRating(request.getRating());
		serviceRequestDao.save(serviceRequest);
		RatingFeedbackResponse response = new RatingFeedbackResponse();
		response.setStatus(Boolean.TRUE);
		return response;
	}

	@Override
	public GetFeedbackResponse getFeedbacks(GetFeedbackRequest request) {
		RatingQuestionRequest ratingQuestionRequest = new RatingQuestionRequest();
		ratingQuestionRequest.setCustomerId(request.getCustomerId());
		ratingQuestionRequest.setServiceRequestId(request.getServiceRequestId());
		RatingQuestionResponse ratingQuestionResponse = getRatingQuestions(ratingQuestionRequest);
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestById(request.getServiceRequestId());
		List<ServiceRequestRatingFeedback> feedbacks = srRatingDao.findByServiceRequest(serviceRequest);
		GetFeedbackResponseMapper mapper = new GetFeedbackResponseMapper(ratingQuestionResponse);
		GetFeedbackResponse response = mapper.mapFrom(feedbacks);
		return response;
	}

	@Override
	public CustomerRegisterResponse registerCustomer(
			CustomerRegisterRequest request) {
		// TODO Auto-generated method stub
		CustomerMapper customerMapper = new CustomerMapper();
		Customer customer = customerMapper.mapFrom(request);
		
		LoginCredentials loginCredentials = customer.getUser().getLoginCredentials();
		
		customerDao.save(customer);
		
		MailVO mailVO = new MailVO();
		mailVO.setFrom("vineeth5march1990@gmail.com");
		mailVO.setTemplateFile("registration_code.vm"); 
		mailVO.setSubject("ServePlus Registration");
		mailVO.setTo("ppanickar@qatarairways.com.qa");
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("otp",loginCredentials.getRegnOtpId().getCode());
		mailVO.setMap(map);
		servePlusMailService.sendMail(mailVO);
		CustomerResponseMapper responseMapper = new CustomerResponseMapper();
		CustomerRegisterResponse response = responseMapper.mapFrom(customer);
		return response;
	} 

}
