package com.jstudyplanner;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.logging.ClasspathLoggingApplicationListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		servletContext.setInitParameter("contextConfigLocation", "/WEB-INF/spring/root-context.xml");
		servletContext.addListener(ContextLoaderListener.class);
	//	servletContext.addListener(ClasspathLoggingApplicationListener.class);
		// XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		// appContext.setConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("appServlet", new DispatcherServlet());
		//dispatcher.setInitParameter("contextConfigLocation", "/WEB-INF/spring/appServlet/servlet-context.xml");
		dispatcher.setInitParameter("contextConfigLocation", "/WEB-INF/spring/appServlet/root-context.xml");

		dispatcher.addMapping("/");
		dispatcher.setLoadOnStartup(1);
		super.onStartup(servletContext);

	}

	@Bean
	public DelegatingFilterProxy securityFilterChainRegistration() {
		DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(delegatingFilterProxy);
		registrationBean.addUrlPatterns("/*");

		return delegatingFilterProxy;
	}

}
