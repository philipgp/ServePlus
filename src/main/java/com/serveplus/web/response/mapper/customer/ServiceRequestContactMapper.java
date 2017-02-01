package com.serveplus.web.response.mapper.customer;

import com.serveplus.data.entity.ContactDetail;
import com.serveplus.data.entity.ServiceContactDetail;
import com.serveplus.data.entity.ServiceContactDetailId;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.response.mapper.ContactMapper;
import com.serveplus.web.response.mapper.Mapper;

public class ServiceRequestContactMapper implements Mapper<ContactVO,ServiceContactDetail>{

	private ServiceRequest serviceRequest;
	
	
	@Override
	public ServiceContactDetail mapFrom(ContactVO source) {
		ContactMapper contactMapper = new ContactMapper();
		ContactDetail contactDetails = contactMapper.mapFrom(source);
		ServiceContactDetail serviceContactDetail = new ServiceContactDetail();
		//ServiceContactDetailId serviceContactDetailId = new ServiceContactDetailId();
		//serviceContactDetailId.setServiceRequest(serviceRequest);
		//serviceContactDetailId.setContactDetail(contactDetails);
		serviceContactDetail.setContactDetail(contactDetails);
		serviceContactDetail.setServiceRequest(serviceRequest);
		return serviceContactDetail;
	}

	public ServiceRequestContactMapper(ServiceRequest serviceRequest) {
		super();
		this.serviceRequest = serviceRequest;
	}

}
