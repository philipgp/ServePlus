package com.serveplus.web.response.mapper.customer;

import java.util.List;
import java.util.Set;

import com.serveplus.data.entity.ContactDetail;
import com.serveplus.data.entity.User;
import com.serveplus.data.entity.UserAddress;
import com.serveplus.data.entity.UserContact;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.request.customer.UserRegisterRequest;
import com.serveplus.web.response.customer.UserAddressMapper;
import com.serveplus.web.response.customer.UserAddressVOMapper;
import com.serveplus.web.response.mapper.ListToSetMapper;
import com.serveplus.web.response.mapper.Mapper;

public class UserMapper implements Mapper<UserRegisterRequest,User>{

	@Override
	public User mapFrom(UserRegisterRequest source) {
		User user = null;
		if(source!=null){
			user = new User();
			user.setFirstName(source.getFirstName());
			user.setLastName(source.getLastName());
			user.setMiddleName(source.getMiddleName());
			List<ContactVO> contactInfos = source.getContactInfos();
			if(contactInfos!=null && !contactInfos.isEmpty()){
				ListToSetMapper<ContactVO, UserContact> contactListMapper = new ListToSetMapper<>();
				Set<UserContact> mappedItem = contactListMapper.mapFrom(contactInfos, new UserContactMapper(user));
				user.setUserContactDetails(mappedItem);
			}
			
			List<AddressVO> addresses = source.getAddresses();
			if(addresses!=null && !addresses.isEmpty()){
				ListToSetMapper<AddressVO, UserAddress> listOfAddressMapper = new ListToSetMapper<>();
				Set<UserAddress> mappedItem = listOfAddressMapper.mapFrom(addresses, new UserAddressMapper(user));
				user.setUserAddresses(mappedItem);
			}
		}
		return user;
	}
	
}
