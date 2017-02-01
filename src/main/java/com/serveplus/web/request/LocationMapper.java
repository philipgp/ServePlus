package com.serveplus.web.request;

import com.serveplus.data.entity.Location;
import com.serveplus.web.response.LocationVO;
import com.serveplus.web.response.mapper.Mapper;

public class LocationMapper implements Mapper<LocationVO,Location>{

	@Override
	public Location mapFrom(LocationVO source) {
		
		Location location = null;
		if(source!=null){
			location = new Location();
			location.setLatitude(String.valueOf(source.getLatitude()));
			location.setLongitude(String.valueOf(source.getLongitude()));
		}
		return location;
	}

}
