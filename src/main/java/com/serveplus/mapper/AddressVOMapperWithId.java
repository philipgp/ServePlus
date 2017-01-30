package com.serveplus.mapper;

import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.Location;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.response.mapper.Mapper;

public class AddressVOMapperWithId  extends AddressVOMapper{
	private Float latitude,longitude;
	private Address address;
	public AddressVOMapperWithId(Float latitude, Float longitude,Address address) {
		super(latitude,longitude);
		this.address = address;
	}

	
	@Override
	public Address mapFrom(AddressVO source) {
		if(address==null && (source!=null || latitude!=null || longitude!=null))
			address = new Address();
		if(source==null )
			return null;
		setValues(address,source);
		return address;
	}
	
}
