package com.serveplus.service.impl;

import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class VelocityEngineUtils {

	public static String mergeTemplateIntoString(VelocityEngine velocityEngine, String template, String encoding,
			Map<String, Object> model) {
		VelocityContext velocityContext = new VelocityContext();
		StringWriter stringWriter = new StringWriter();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath"); 
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		 velocityEngine.mergeTemplate(template, encoding, velocityContext, stringWriter);
		Context model1 = null;
		// TODO Auto-generated method stub
		// velocityEngine.mergeTemplate(string, model1, new StringWriter());
		return stringWriter.toString();
	}

}
