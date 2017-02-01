package com.serveplus.web.response.mapper;

import com.serveplus.data.entity.ContactDetail;
import com.serveplus.web.request.ContactVO;

public class ContactVoMapper implements Mapper<ContactDetail,ContactVO>{

	private void setValue(ContactVO contactVO,ContactDetail source){
		contactVO.setType(source.getContactType());
		contactVO.setValue(source.getValue());
	}
	@Override
	public ContactVO mapFrom(ContactDetail source) {
		ContactVO contactVO = new ContactVO();
		setValue(contactVO, source);
		return contactVO;
	}

}
