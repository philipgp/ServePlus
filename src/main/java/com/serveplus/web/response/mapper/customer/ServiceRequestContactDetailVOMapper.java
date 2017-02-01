package com.serveplus.web.response.mapper.customer;

import com.serveplus.data.entity.UserContact;
import com.serveplus.data.entity.ServiceContactDetail;
import com.serveplus.web.request.ContactVO;
import com.serveplus.web.response.mapper.ContactVoMapper;
import com.serveplus.web.response.mapper.Mapper;

public class ServiceRequestContactDetailVOMapper implements Mapper<ServiceContactDetail,ContactVO>{

	@Override
	public ContactVO mapFrom(ServiceContactDetail source) {
		ContactVoMapper contactVoMapper = new ContactVoMapper();
		ContactVO contactVO = contactVoMapper.mapFrom(source.getContactDetail());
		return contactVO;
	}

}
