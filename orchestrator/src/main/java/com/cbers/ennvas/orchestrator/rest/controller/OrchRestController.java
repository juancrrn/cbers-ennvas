package com.cbers.ennvas.orchestrator.rest.controller;

import java.util.List;

import com.cbers.ennvas.orchestrator.domain.resource.Product;
import com.cbers.ennvas.orchestrator.domain.resource.ProductList;
import com.cbers.ennvas.orchestrator.domain.resource.Query;
import com.cbers.ennvas.orchestrator.rest.data.RcmRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
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
 * @version 1.0.0
 */

@RestController
@RequestMapping("/ennvas/orch/rest")
public class OrchRestController
{

	@Autowired
	private ApplicationArguments applicationArguments;

    private static final String AGENT_MANAGER_PATH = "/ennvas/agm/rest/retrieve";
    private static final String RECOMMENDER_PATH = "/ennvas/rcm/rest/process";

    private static final Logger log = LoggerFactory.getLogger(OrchRestController.class);
    
    /**
     * TODO Document method
     */
    @PostMapping(
        value = "/search",
        consumes = "application/json",
        produces = "application/json"
    )
    public ProductList search(@RequestBody Query searchRequest)
    {
        RestTemplate restTemplate = new RestTemplate();

		/*
		 * Retrieve command line arguments (pre-validated).
		 */

		String[] args = applicationArguments.getSourceArgs();
		String agentManagerUrl = args[0];
        String recommenderUrl = args[1];

        /**
         * Retrieve information from the AgentManager.
         */

        log.info("Submitting request to agent manager.");

        ProductList agmResponse = restTemplate.getForObject(
            agentManagerUrl + AGENT_MANAGER_PATH,
            ProductList.class
        );

        log.info("Received response from agent manager.");

        List<Product> agmProducts = agmResponse.getProducts();

        for (Product product : agmProducts) {
            log.info(product.toString());
        }

        /**
         * Generate Recommender request and retrieve information from it.
         */

        log.info("Creating request for recommender.");

        RcmRequest rcmRequest = new RcmRequest(searchRequest, agmResponse.getProducts());

        log.info("Submitting request to recommender.");

        ProductList rcmResponse = restTemplate.postForObject(
            recommenderUrl + RECOMMENDER_PATH,
            rcmRequest,
            ProductList.class
        );

        log.info("Received response from recommender.");

        List<Product> rcmProducts = rcmResponse.getProducts();

        for (Product product : rcmProducts) {
            log.info(product.toString());
        }

        return new ProductList(rcmProducts);
    }
}