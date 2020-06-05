package com.cbers.frontend.rest.controller;

import java.util.LinkedList;
import java.util.List;

import com.cbers.frontend.domain.resource.Product;
import com.cbers.frontend.domain.resource.ProductList;
import com.cbers.frontend.domain.resource.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ennvas/front/rest")
public class FrontRestController
{
    
    private static final Logger log = LoggerFactory.getLogger(FrontRestController.class);

    @Autowired
    private ApplicationArguments applicationArguments;

    private static final String ORCHESTRATOR_PATH = "/ennvas/orch/rest/search";

    @PostMapping(
        value = "/search",
        consumes = "application/json",
        produces = "application/json"
    )
    public ProductList search(@RequestBody Query query)
    {
        log.info("Received query.");

        RestTemplate restTemplate = new RestTemplate();

		/*
		 * Retrieve command line arguments (pre-validated).
		 */

		String[] args = applicationArguments.getSourceArgs();
        String orchestratorUrl = args[0];

        /*
         * Retrieve information from the orchestrator.
         */

        log.info("Submitting request to orchestrator.");

        log.info("Orchestrator URL: " + orchestratorUrl + ORCHESTRATOR_PATH);

        ProductList orchResponse = restTemplate.postForObject(
            orchestratorUrl + ORCHESTRATOR_PATH,
            query,
            ProductList.class
        );

        log.info("Received response from orchestrator.");

        for (Product product : orchResponse.getProducts()) {
            log.info(product.toString());
        }

        log.info("Responding query.");

        return orchResponse;
    }
}