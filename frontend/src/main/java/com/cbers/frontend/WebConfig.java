package com.cbers.frontend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer
{
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/webjars/**")
          .addResourceLocations("/webjars/");

        registry
            .addResourceHandler("/images/**")
            .addResourceLocations("classpath:/META-INF/images/");

        registry
            .addResourceHandler("/css/**")
            .addResourceLocations("classpath:/META-INF/css/");

        registry
            .addResourceHandler("/js/**")
            .addResourceLocations("classpath:/META-INF/js/");
    }
}