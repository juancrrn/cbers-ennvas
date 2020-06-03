package com.cbers.ennvas.agentmanager.rest.controller;

import com.cbers.ennvas.agentmanager.application.service.ProductServiceImpl;
import com.cbers.ennvas.agentmanager.rest.controller.data.ProductResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO Describe this class
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * 
 * @version 1.0.0
 */

@RestController
@RequestMapping("/ennvas/agm/rest")
public class AgmRestController
{

    private static final Logger log = LoggerFactory.getLogger(AgmRestController.class);

	@Autowired
	private ProductServiceImpl productServiceImpl;

	/**
	 * TODO Describe this method
	 * 
	 * @return
	 */
	@GetMapping(value="/retrieve", produces = "application/json")
	public ResponseEntity<ProductResponse> retrieve()
	{
		log.info("Received product data request.");

		log.info("Sengind product data.");

		return ResponseEntity.ok(productServiceImpl.getAllProducts());
	}
}