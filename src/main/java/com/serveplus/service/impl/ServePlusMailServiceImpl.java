package com.serveplus.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serveplus.data.dao.HostPropDao;
import com.serveplus.service.GmailRunnable;
import com.serveplus.service.MailConfiguration;
import com.serveplus.service.ServePlusMailService;
import com.serveplus.vo.MailVO;

@Component
public class ServePlusMailServiceImpl implements ServePlusMailService{
	
	@Autowired
	private VelocityEngine velocityEngine;
	@Autowired
	HostPropDao hostPropDao;
	
	public void sendMail(MailVO mailVO ){
		MailConfiguration mailConfiguration = new MailConfiguration();
		mailConfiguration.setServer(hostPropDao.getValue("MAIL_SERVER"));
		mailConfiguration.setPort(hostPropDao.getValue("MAIL_PORT"));
		mailConfiguration.setUserName(hostPropDao.getValue("MAIL_USERNAME"));
		mailConfiguration.setPassword(hostPropDao.getValue("MAIL_PASSWORD"));
		
		if(StringUtils.isNotEmpty(mailVO.getTemplateFile())){
		String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
				mailVO.getTemplateFile(), "UTF-8", mailVO.getMap());
		mailVO.setBody(text);
		}
		GmailRunnable runnable = new GmailRunnable(mailVO.getFrom(), mailVO.getTo(), mailVO.getSubject(), mailVO.getBody());
		runnable.setSession(mailConfiguration.getServer(), mailConfiguration.getPort(), 
				mailConfiguration.getUserName(), mailConfiguration.getPassword());
		
		runnable.start();
	}
	
}
