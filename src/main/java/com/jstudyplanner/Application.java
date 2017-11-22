package com.jstudyplanner;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;


@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public DelegatingFilterProxy securityFilterChainRegistration() {
	
		DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(delegatingFilterProxy);
		registrationBean.addUrlPatterns("/");
	
		return delegatingFilterProxy;
	}
	
	 
    @Bean
	    public TilesConfigurer tilesConfigurer() {
	        final TilesConfigurer configurer = new TilesConfigurer();
	        configurer.setDefinitions(new String[] { "WEB-INF/views/views.xml" });
	        configurer.setCheckRefresh(true);
	       
	        return configurer;
	    }
    
    @Bean
    public TilesViewResolver tilesViewResolver() {
        final TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }
   

}