package com.cbers.ennvas.orchestrator.rest.controller;

import java.util.List;

import com.cbers.ennvas.orchestrator.domain.resource.AgmProduct;
import com.cbers.ennvas.orchestrator.domain.resource.AgmProductList;
import com.cbers.ennvas.orchestrator.domain.resource.FrontQuery;
import com.cbers.ennvas.orchestrator.rest.controller.data.RcmRequestWrapper;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Controls HTTP requests to the REST API.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * @author Melany Daniela Chicaiza Quezada
 * 
 * @version 0.0.2
 */

@RestController
@RequestMapping("/ennvas/orch/rest")
public class OrchRestController
{

    @Bean
    public RestTemplate rest()//restTemplate(RestTemplateBuilder builder){
    {
        return new RestTemplate();//return builder.build();
    }
    
    @PostMapping(value = "/search", consumes = "application/json", produces = "application/json")
    public void /*SearchResponseWrapper*/ search(@RequestBody FrontQuery searchRequest)
    {

        RestTemplate restTemplate = new RestTemplate();

        /**
         * Retrieve information from the AgentManager.
         */

        System.out.println("[ENNVAS-ORCH] Submitting request to AgentManager.");

        AgmProductList agmResponse = restTemplate.getForObject(
            "http://localhost:60002/ennvas/agm/rest/retrieve",
            AgmProductList.class
        );

        System.out.println("[ENNVAS-ORCH] Got response from AgentManager.");

        List<AgmProduct> agmProducts = agmResponse.getProducts();

        for (AgmProduct product : agmProducts) {
            System.out.println(product.getName());
        }

        /**
         * Generate Recommender request and retrieve information from it.
         */

        System.out.println("[ENNVAS-ORCH] Creating request for Recommender.");

        RcmRequestWrapper rcmRequest = new RcmRequestWrapper(searchRequest, agmResponse.getProducts());

        System.out.println("[ENNVAS-ORCH] Submitting request to Recommender.");

        AgmProductList rcmResponse = restTemplate.postForObject(
            "http://localhost:60000/ennvas/rcm/rest/process",
            rcmRequest,
            AgmProductList.class
        );

        System.out.println("[ENNVAS-ORCH] Got response from Recommender.");

        List<AgmProduct> rcmProducts = rcmResponse.getProducts();

        for (AgmProduct product : rcmProducts) {
            System.out.println(product.getName());
        }

        //return new SearchResponseWrapper();
    }
}