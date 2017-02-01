package com.serveplus.mapper;

import java.util.List;
import java.util.Set;

import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.CompanyService;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.Location;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceContactDetail;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.ServiceRequestStatus;
import com.serveplus.data.entity.SrActionHistory;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.request.LocationMapper;
import com.serveplus.web.request.customer.CreateServiceRequest;
import com.serveplus.web.request.customer.CreateServiceRequestBase;
import com.serveplus.web.response.PreferredTime;
import com.serveplus.web.response.mapper.ListToListMapper;
import com.serveplus.web.response.mapper.ListToSetMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.customer.ServiceRequestContactMapper;


public class ServiceRequestMapper implements Mapper<CreateServiceRequest,ServiceRequest>{

	private Customer customer;
	private CompanyService companyService;
	private Assigner assigner;
	public ServiceRequestMapper(Customer customer, CompanyService companyService,
			Assigner assigner) {
		super();
		this.customer = customer;
		this.companyService = companyService;
		this.assigner = assigner;
	}
	
	@Override
	public ServiceRequest mapFrom(CreateServiceRequest source) { 
		ServiceRequest serviceRequest = new ServiceRequest();
		AddressVOMapper addressMapper = new AddressVOMapper();
		Address address = addressMapper.mapFrom(source.getLocalAddress());
		serviceRequest.setAddress(address);
		serviceRequest.setCustomer(customer);
		serviceRequest.setCompanyService(companyService);
		serviceRequest.setStatus(ServiceRequestStatus.REGISTERED);
		serviceRequest.setAssigner(assigner);
		serviceRequest.setRequest(source.getRequest());
		List<ContactVO> contactInfos = source.getContactInfos();
		ListToSetMapper<ContactVO, ServiceContactDetail> serviceContactDetailMapper = new ListToSetMapper<ContactVO, ServiceContactDetail>();
		Set<ServiceContactDetail> serviceContacts = serviceContactDetailMapper.mapFrom(contactInfos, new ServiceRequestContactMapper(serviceRequest));
		serviceRequest.setServiceContactDetails(serviceContacts);
		PreferredTime prefferedTime = source.getPreferredTime();
		if(prefferedTime!=null){
			String prefferedDays = prefferedTime.getPrefferedDays();
			serviceRequest.setPreferredDays(prefferedDays);
			
			String prefferedTime2 = prefferedTime.getPrefferedTime();
			serviceRequest.setPreferredTime(prefferedTime2);
		}
		SrActionHistoryMapper actionHistoryMapper = new SrActionHistoryMapper();
		SrActionHistory actionHistory = actionHistoryMapper.mapFrom(serviceRequest);
		serviceRequest.addAction(actionHistory);
		return serviceRequest;
	}
	
	 
}
