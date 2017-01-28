package com.serveplus.mapper;

import com.serveplus.data.entity.Address;
import com.serveplus.data.entity.Location;
import com.serveplus.web.request.AddressVO;
import com.serveplus.web.response.mapper.Mapper;

public class AddressVOMapper implements Mapper<AddressVO,Address>{
	private Float latitude,longitude;
	
	public AddressVOMapper(Float latitude, Float longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public Address mapFrom(AddressVO source) {
		
		Address address = null;
		if(source!=null || latitude!=null || longitude!=null){
			address = new Address();
			address.setFirstLine(source.getFirstLine());
			address.setSecondLine(source.getSecondLine());
			Location location = new Location();
			address.setLocation(location);
			location.setLatitude(String.valueOf(latitude));
			location.setLongitude(String.valueOf(longitude));
		}
		return address;
	}
	
}
