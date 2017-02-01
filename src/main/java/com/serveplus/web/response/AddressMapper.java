package com.serveplus.web.response;

import com.serveplus.data.entity.Address;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.response.mapper.Mapper;

public class AddressMapper implements Mapper<Address,AddressVO>{

	protected void setValues(AddressVO addressVO,Address source){
		addressVO.setFirstLine(source.getFirstLine());
		addressVO.setSecondLine(source.getSecondLine());
	}
	@Override
	public AddressVO mapFrom(Address source) {
		AddressVO addressVO = new AddressVO();
		setValues(addressVO, source);
		return addressVO;
	}
	
}
