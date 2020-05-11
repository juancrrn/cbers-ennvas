package com.cbers.ennvas.agentmanager.rest.controller;

import com.cbers.ennvas.agentmanager.application.service.ProductService;
import com.cbers.ennvas.agentmanager.rest.controller.data.ProductResponse;
import com.cbers.ennvas.agentmanager.rest.controller.data.AgmRequestWrapper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/ennvas/agm/rest")
public class AgmRestController
{

	private ProductService service;

	@PostMapping(
		value="/retrieve",
		consumes = "application/json",
		produces = "application/json"
	)
	public ResponseEntity<ProductResponse> postMethodName(@RequestBody AgmRequestWrapper request)
	{
		return ResponseEntity.ok(service.getAllProducts());
	}
	
}