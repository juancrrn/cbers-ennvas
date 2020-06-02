package com.cbers.ennvas.agentmanager.rest.controller;

import com.cbers.ennvas.agentmanager.application.service.ProductServiceImpl;
import com.cbers.ennvas.agentmanager.rest.controller.data.ProductResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

	@Autowired
	private ProductServiceImpl service;

	/**
	 * TODO Describe this method
	 * 
	 * @return
	 */
	@GetMapping(value="/retrieve", produces = "application/json")
	public ResponseEntity<ProductResponse> retrieve()
	{
		System.out.println("[ENNVAS-AGM] Received product data request.");

		System.out.println("[ENNVAS-AGM] Sengind product data.");

		return ResponseEntity.ok(service.getAllProducts());
	}
}