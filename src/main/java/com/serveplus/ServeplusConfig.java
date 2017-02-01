package com.serveplus;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServeplusConfig {
	@Bean
	public VelocityEngine velocityEngine(){
		VelocityEngine velocityEngine = new VelocityEngine();
		return velocityEngine;
	}
}
