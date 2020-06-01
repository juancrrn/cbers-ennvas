package com.cbers.ennvas.orchestrator.rest.controller.template;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class OrchRestTemplate
{
    
    @Bean
    public RestTemplate rest()
    {
        return new RestTemplate();
    }
}