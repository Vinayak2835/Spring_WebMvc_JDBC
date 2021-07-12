package com.Dispatcher;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class dispatcherServletClass implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext  web = new AnnotationConfigWebApplicationContext();
		web.register(Configuration1.class);
	        DispatcherServlet dispatcher=new DispatcherServlet(web);
	        ServletRegistration.Dynamic  dynamic=servletContext.addServlet("myservlet",dispatcher);
		dynamic.setLoadOnStartup(1);
		dynamic.addMapping("/");
		
	}
}
