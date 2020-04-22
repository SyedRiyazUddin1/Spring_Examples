/**package com.springmvc.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalcApplicationInitializer implements //WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		// creating WebApplicationContext (WebContainer) object for xml-based config	
		
     //	XmlWebApplicationContext webApplicationContext= new XmlWebApplicationContext();
     // webApplicationContext.setConfigLocation("classpath:application-config.xml");

//creating WebApplicationContext (WebContainer) object for java configuration class
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalcAppConfig.class);

		// create a dispatcher servlet object and passing the webContainer object so that DS gets initialized
		DispatcherServlet dispatcherServelt = new DispatcherServlet(webApplicationContext);
 
		// registering the DS with ServletContext object
		ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("myDispatcherServlet",
				dispatcherServelt);

		// setting onStartup method
		myCustomDispatcherServlet.setLoadOnStartup(1);

		// URL mapping
		myCustomDispatcherServlet.addMapping("/mywebsite.com/*");

	}

}

*/
