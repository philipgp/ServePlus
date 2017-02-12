package com.serveplus.web.response.mapper;

import org.apache.commons.lang3.StringUtils;

import com.serveplus.data.entity.Location;
import com.serveplus.web.response.LocationVO;

public class LocationVoMapper implements Mapper<Location,LocationVO>{

	@Override
	public LocationVO mapFrom(Location source) {
		LocationVO location = null;
		if(source!=null){
			location = new LocationVO();
		if(StringUtils.isNotEmpty(source.getLatitude()))
			location.setLatitude(Float.valueOf(source.getLatitude()));
		if(StringUtils.isNotEmpty(source.getLongitude()))
			location.setLongitude(Float.valueOf(source.getLongitude()));
		}
		return location;
	}

}
