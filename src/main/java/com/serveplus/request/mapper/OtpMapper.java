package com.serveplus.request.mapper;



import java.util.Calendar;
import java.util.Date;

import com.serveplus.data.entity.Otp;
import com.serveplus.web.response.mapper.Mapper;

public class OtpMapper implements Mapper<String,Otp>{

	private Integer otpExpiryDuration = 10;
	
	public OtpMapper(Integer otpExpiryDuration) {
		super();
		this.otpExpiryDuration = otpExpiryDuration;
	}
	public OtpMapper() {
		super();
	}

	@Override
	public Otp mapFrom(String source) {
		Otp otp = new Otp();
		otp.setCode(source);
		Date now = new Date();
		Calendar cale = Calendar.getInstance();
		cale.setTime(now);
		cale.add(Calendar.MINUTE, otpExpiryDuration);
		Date expiryTime = cale.getTime();
		otp.setExpiryDate(expiryTime);
		return otp;
	}

}
