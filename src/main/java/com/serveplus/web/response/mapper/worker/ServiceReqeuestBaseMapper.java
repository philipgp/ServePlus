package com.serveplus.web.response.mapper.worker;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.ContactDetail;
import com.serveplus.data.entity.ContactType;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.Location;
import com.serveplus.data.entity.Service;
import com.serveplus.data.entity.ServiceContactDetail;
import com.serveplus.data.entity.ServiceRequest;
import com.serveplus.data.entity.User;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.response.AddressMapper;
import com.serveplus.web.response.LocationVO;
import com.serveplus.web.response.PreferredTime;
import com.serveplus.web.response.ServiceRequestVO;
import com.serveplus.web.response.mapper.LocationVoMapper;
import com.serveplus.web.response.mapper.SetToListMapper;
import com.serveplus.web.response.mapper.SetToSetMapper;
import com.serveplus.web.response.mapper.customer.ServiceRequestContactDetailVOMapper;

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
		
		Service service = serviceRequest.getCompanyService().getService();
		if(service!=null){
			workVO.setType(service.getName());
			workVO.setTypeId(String.valueOf(service.getId()));
		}
		if(StringUtils.isNotEmpty(serviceRequest.getPreferredDays())|| StringUtils.isNotEmpty(serviceRequest.getPreferredTime())){
			PreferredTime prefferedTime = new PreferredTime();
			prefferedTime.setPrefferedDays(serviceRequest.getPreferredDays());
			prefferedTime.setPrefferedTime(serviceRequest.getPreferredTime());
			workVO.setPreferredTime(prefferedTime);
		}
		workVO.setDate(serviceRequest.getCreatedDate());
		if(serviceRequest.getStatus()!=null)
			workVO.setStatus(serviceRequest.getStatus().toString());
		if(customer!=null){
			User user = customer.getUser();
			
			if(user!=null){
				/*Address defaultAddress = user.getDefaultAddress();
				if(defaultAddress!=null){
					
				}*/
				workVO.setFirstName(user.getFirstName());
				workVO.setMiddleName(user.getMiddleName());
				workVO.setLastName(user.getLastName());
				/*StringBuilder sb = new StringBuilder();
				sb.append(user.getFirstName());
				if(!StringUtils.isEmpty(user.getMiddleName())){
					sb.append(" ").append(user.getMiddleName());
				}
				sb.append(" ").append(user.getLastName());
				workVO.setFullName(sb.toString());*/
			}
			/*ContactDetail phoneContact = customer.getContact(ContactType.PHONE);*/
			Set<ServiceContactDetail> serviceContactDetails = serviceRequest.getServiceContactDetails();
			SetToListMapper<ServiceContactDetail, ContactVO> contactListMapper = new SetToListMapper<ServiceContactDetail, ContactVO>();
			List<ContactVO> mappedContactList = contactListMapper.mapFrom(serviceContactDetails, new ServiceRequestContactDetailVOMapper());
			workVO.setContactInfos(mappedContactList);
			/*if(phoneContact!=null){
				workVO.setPhoneNo(phoneContact.getValue());	
			}*/
			workVO.setRequest(serviceRequest.getRequest());
			Address serviceAddress = serviceRequest.getAddress();
			if(serviceAddress!=null){
				AddressMapper addressMapper = new AddressMapper();
				AddressVO addressVO = addressMapper.mapFrom(serviceAddress);
				workVO.setAddress(addressVO);
				Location location = serviceAddress.getLocation();
				LocationVoMapper locationMapper = new LocationVoMapper();
				LocationVO locationVO = locationMapper.mapFrom(location);
				workVO.setLocation(locationVO);
				/*if(location!=null){
					Float latitude = Float.valueOf(location.getLatitude());
					workVO.setLatitude(latitude);
					Float longitude = Float.valueOf(location.getLongitude());
					workVO.setLongitude(longitude);
				}*/
			}
			
		}
	}
}
