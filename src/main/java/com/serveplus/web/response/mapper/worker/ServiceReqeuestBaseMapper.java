package com.serveplus.web.response.mapper.worker;

import org.apache.commons.lang3.StringUtils;

import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.ContactDetail;
import com.serveplus.data.entity.ContactType;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.Location;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.User;
import com.serveplus.web.response.ServiceRequestVO;

public class ServiceReqeuestBaseMapper {
	private String getAddressString(Address defaultAddress){
		StringBuilder addressSB = new StringBuilder();
		if(defaultAddress!=null)
			addressSB.append(defaultAddress.getFirstLine()).append(" ").append(defaultAddress.getSecondLine());
		return addressSB.toString();
	}
	
	protected void map(ServiceRequest serviceRequest,ServiceRequestVO workVO){
		workVO.setRegnId(String.valueOf(serviceRequest.getId()));
		Customer customer = serviceRequest.getCustomer();
		Service service = serviceRequest.getService();
		if(service!=null){
			workVO.setType(service.getName());
			workVO.setTypeId(String.valueOf(service.getId()));
		}
		workVO.setDate(serviceRequest.getCreatedDate());
		if(serviceRequest.getStatus()!=null)
			workVO.setStatus(serviceRequest.getStatus().toString());
		if(customer!=null){
			User user = customer.getUser();
			
			if(user!=null){
				Address defaultAddress = user.getDefaultAddress();
				if(defaultAddress!=null){
					
				}
				StringBuilder sb = new StringBuilder();
				sb.append(user.getFirstName());
				if(!StringUtils.isEmpty(user.getMiddleName())){
					sb.append(" ").append(user.getMiddleName());
				}
				sb.append(" ").append(user.getLastName());
				workVO.setFullName(sb.toString());
			}
			ContactDetail phoneContact = customer.getContact(ContactType.PHONE);
			if(phoneContact!=null){
				workVO.setPhoneNo(phoneContact.getValue());	
			}
			Address serviceAddress = serviceRequest.getAddress();
			if(serviceAddress!=null){
				workVO.setLocalAddress(getAddressString(serviceAddress));
				Location location = serviceAddress.getLocation();
				if(location!=null){
					Float latitude = Float.valueOf(location.getLatitude());
					workVO.setLatitude(latitude);
					Float longitude = Float.valueOf(location.getLongitude());
					workVO.setLongitude(longitude);
				}
			}
			
		}
	}
}
