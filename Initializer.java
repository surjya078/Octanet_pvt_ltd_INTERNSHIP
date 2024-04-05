package com.jsp.driver;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.jsp.entity.Config;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// specify package name to dispatcherservlet by Handler Mapping
	protected Class<?>[] getServletConfigClasses() {
		Class[] configClasses = { Config.class };
		return configClasses;
	}

	@Override
	protected String[] getServletMappings() {
		String[] urls = { "/" }; // '/' -> it means all the url pass to the dispatcherservlet .
		return urls;
	}

}
