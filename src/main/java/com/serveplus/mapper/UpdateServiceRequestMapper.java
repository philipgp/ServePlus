package com.serveplus.mapper;

import java.util.List;
import java.util.Set;

import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.Assigner;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.Location;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceContactDetail;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.ServiceRequestStatus;
import com.serveplus.data.entity.SrAction;
import com.serveplus.data.entity.SrActionHistory;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.request.LocationMapper;
import com.serveplus.web.request.customer.CreateServiceRequest;
import com.serveplus.web.request.customer.CreateServiceRequestBase;
import com.serveplus.web.request.customer.UpdateServiceRequest;
import com.serveplus.web.response.PreferredTime;
import com.serveplus.web.response.mapper.ListToSetMapper;
import com.serveplus.web.response.mapper.Mapper;
import com.serveplus.web.response.mapper.customer.ServiceRequestContactMapper;


public class UpdateServiceRequestMapper implements Mapper<UpdateServiceRequest,ServiceRequest>{

	private ServiceRequest serviceRequest;
	
	public UpdateServiceRequestMapper(ServiceRequest serviceRequest) {
		super();
		this.serviceRequest = serviceRequest;
	}

	@Override
	public ServiceRequest mapFrom(UpdateServiceRequest source) {
		
		LocationMapper locationMapper = new LocationMapper();
		Location mappedLocation = locationMapper.mapFrom(source.getLocation());
		AddressVOMapperWithId addressMapper = new AddressVOMapperWithId(mappedLocation,serviceRequest.getAddress());
		Address address = addressMapper.mapFrom(source.getLocalAddress());
		serviceRequest.setAddress(address);
		serviceRequest.setRequest(source.getRequest());
		PreferredTime prefferedTime = source.getPreferredTime(); 
		if(prefferedTime!=null){
			String prefferedDays = prefferedTime.getPrefferedDays();
			serviceRequest.setPreferredDays(prefferedDays);
			
			String prefferedTime2 = prefferedTime.getPrefferedTime();
			serviceRequest.setPreferredTime(prefferedTime2);
		}
		SrActionHistoryMapper actionHistoryMapper = new SrActionHistoryMapper(SrAction.UPDATED);
		SrActionHistory actionHistory = actionHistoryMapper.mapFrom(serviceRequest);
		serviceRequest.addAction(actionHistory);
		List<ContactVO> contactInfos = source.getContactInfos();
		ListToSetMapper<ContactVO, ServiceContactDetail> serviceContactDetailMapper = new ListToSetMapper<ContactVO, ServiceContactDetail>();
		Set<ServiceContactDetail> serviceContacts = serviceContactDetailMapper.mapFrom(contactInfos, new ServiceRequestContactMapper(serviceRequest));
		serviceRequest.setServiceContactDetails(serviceContacts);
		
		return serviceRequest;
	}
	 
}
