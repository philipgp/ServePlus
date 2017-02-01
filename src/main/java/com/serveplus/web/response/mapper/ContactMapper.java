package com.serveplus.web.response.mapper;

import com.serveplus.data.entity.ContactDetail;
import com.serveplus.web.request.ContactVO;

public class ContactMapper implements Mapper<ContactVO,ContactDetail>{

	private void setValue(ContactVO contactVO,ContactDetail source){
		source.setContactType(contactVO.getType());
		source.setValue(contactVO.getValue());
	}
	@Override
	public ContactDetail mapFrom(ContactVO source) {
		ContactDetail contactVO = new ContactDetail();
		setValue( source,contactVO);
		return contactVO;
	}

}
