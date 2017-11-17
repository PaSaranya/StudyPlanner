package com.jstudyplanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;


@Configuration
	public class ConfigurationForTiles {
	private static final String PREFIX = "/WEB-INF/views/";
	private static final String SUFFIX = ".jsp";
	 
	    @Bean
	    public TilesConfigurer tilesConfigurer() {
	        final TilesConfigurer configurer = new TilesConfigurer();
	        configurer.setDefinitions(new String[] { "WEB-INF/views/views.xml" });
	        configurer.setCheckRefresh(true);
	        configurer.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
	        return configurer;
	    }

	 
	    @Bean
	    public TilesViewResolver tilesViewResolver() {
	        final TilesViewResolver resolver = new TilesViewResolver();
	       // resolver.setPrefix(PREFIX);
	       // resolver.setSuffix(SUFFIX);
	      
	        resolver.setViewClass(TilesView.class);
	        return resolver;
	    }
	}
