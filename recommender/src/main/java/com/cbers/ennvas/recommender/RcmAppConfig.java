package com.cbers.ennvas.recommender;

import java.util.List;

//import com.cbers.ennvas.recommender.rest.controller.converters.RcmRequestWrapperConverter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan
public class RcmAppConfig
	implements WebMvcConfigurer 
{

	/**
	 * Register HTTP message converters
	 */
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//converters.add(0, new RcmRequestWrapperConverter());
		converters.add(0, new MappingJackson2HttpMessageConverter());
    }

}