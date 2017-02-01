package com.serveplus.mapper;

import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.Location;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.request.LocationMapper;
import com.serveplus.web.response.mapper.Mapper;

public class AddressVOMapper implements Mapper<AddressVO,Address>{
	
	

	
	protected void setValues(Address address,AddressVO source){
		
		LocationMapper locationMapper = new LocationMapper();
		Location location = locationMapper.mapFrom(source.getLocation());
		
			if(address!=null && (source!=null || location!=null)){
				address.setFirstLine(source.getFirstLine());
				address.setSecondLine(source.getSecondLine());
				address.setLocation(location);
				
			}
	}
	
	@Override
	public Address mapFrom(AddressVO source) {
		Address address = null;
			address = new Address();
			setValues(address,source);
		
		return address;
	}
	
}
