package com.serveplus.web.response.mapper.worker;



import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.ContactDetail;
import com.serveplus.data.entity.ContactType;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.UserContact;
import com.serveplus.data.entity.Location;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.User;
import com.serveplus.data.entity.UserAddress;
import com.serveplus.web.response.ServiceRequestVO;
import com.serveplus.web.response.mapper.Mapper;

public class ServiceRequestToWorkMapper extends ServiceReqeuestBaseMapper implements Mapper<ServiceRequest,ServiceRequestVO>{

	
	
	@Override
	public ServiceRequestVO mapFrom(ServiceRequest serviceRequest) {
		ServiceRequestVO workVO = new ServiceRequestVO();
		map(serviceRequest,workVO);
		return workVO;
	}

	

}
