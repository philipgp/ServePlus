package com.serveplus.web.response.mapper;



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
import com.serveplus.web.response.WorkVO;

public class ServiceRequestToWorkMapper implements Mapper<ServiceRequest,WorkVO>{

	private String getAddressString(Address defaultAddress){
		StringBuilder addressSB = new StringBuilder();
		if(defaultAddress!=null)
			addressSB.append(defaultAddress.getFirstLine()).append(" ").append(defaultAddress.getSecondLine());
		return addressSB.toString();
	}
	@Override
	public WorkVO mapFrom(ServiceRequest serviceRequest) {
		WorkVO workVO = new WorkVO();
		workVO.setRegnId(String.valueOf(serviceRequest.getId()));
		Customer customer = serviceRequest.getCustomer();
		Service service = serviceRequest.getCompanyService().getService();
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
				
				StringBuilder sb = new StringBuilder();
				sb.append(user.getFirstName());
				if(!StringUtils.isEmpty(user.getMiddleName())){
					sb.append(" ").append(user.getMiddleName());
				}
				sb.append(" ").append(user.getLastName());
				workVO.setFullName(sb.toString());
			}
			/*ContactDetail phoneContact = customer.getContact(ContactType.PHONE);
			if(phoneContact!=null){
				workVO.setPhoneNo(phoneContact.getValue());	
			}*/
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
		return workVO;
	}

	

}
