package com.serveplus.web.response.mapper.customer;

import com.serveplus.data.entity.ContactDetail;
import com.serveplus.data.entity.Customer;
import com.serveplus.data.entity.User;
import com.serveplus.data.entity.UserContact;
import com.serveplus.data.entity.CustomerContactDetailId;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.response.mapper.ContactMapper;
import com.serveplus.web.response.mapper.ContactVoMapper;
import com.serveplus.web.response.mapper.Mapper;

public class UserContactMapper implements Mapper<ContactVO,UserContact>{

	private User user;
	public UserContactMapper(User customer) {
		super();
		this.user = customer;
	}
	@Override
	public UserContact mapFrom(ContactVO source) {
		ContactMapper contactMapper = new ContactMapper();
		ContactDetail contactDetails = contactMapper.mapFrom(source);
		UserContact userContact = new UserContact();
		userContact.setActive(source.getIsActive());
		userContact.setIsDefault(source.getIsDefault());
		/*CustomerContactDetailId customerContactDetailId = new CustomerContactDetailId();
		customerContactDetailId.setCustomer(customer);
		customerContactDetailId.setContactDetail(contactDetails);*/
		userContact.setContactDetail(contactDetails);
		userContact.setUser(user);
		return userContact;
	}

}
