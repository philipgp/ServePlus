package com.serveplus.web.response.worker;

public class ServePlusUtil {
	public static String generateToken(){
		String token = ((Long)(Math.round(Math.random()* 89999) + 10000)).toString();
		return token;
	}
}
