package com.cbers.ennvas.recommender.rest.controller;

import java.util.LinkedList;

import com.cbers.ennvas.recommender.domain.MainAlgorithm;
import com.cbers.ennvas.recommender.domain.ResultValue;
import com.cbers.ennvas.recommender.rest.controller.data.RcmRequestWrapper;
import com.cbers.ennvas.recommender.rest.controller.data.RcmResponseWrapper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests to the REST API.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * @author Melany Daniela Chicaiza Quezada
 * 
 * @version 0.1
 */

@RestController
@RequestMapping("/ennvas/rcm/rest")
public class RcmRestController
{

	/**
	 * Receives a POST request and passes it as RcmRequestWrapper to 
	 * RcmRestController#passRequest.
	 * 
	 * @see https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-requestbody
	 * @see https://github.com/FasterXML/jackson-docs
	 * @see http://websystique.com/springmvc/spring-mvc-requestbody-responsebody-example/
	 * @see https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#remoting
	 * @see https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/custom-http-message-converter.html
	 * @see https://www.baeldung.com/spring-httpmessageconverter-rest
	 * 
	 * @param input InputWrapper that contains a query and a knowledgebase.
	 * 
	 * @return response body
	 */
	@PostMapping(
		value = "/process",
		consumes = "application/json",
		produces = "application/json"
	)
	public RcmResponseWrapper process(@RequestBody RcmRequestWrapper request)
	{

		return RcmRestController.passRequest(request);

	}

	/**
	 * Initializes the algorithm with the parameters and processes the query.
	 * 
	 * @param request
	 * 
	 * @return Response wrapper with the result values.
	 */
	public static RcmResponseWrapper passRequest(RcmRequestWrapper request)
	{

		MainAlgorithm rec = new MainAlgorithm(request.getStoredValues());

		LinkedList<ResultValue> results =
			(LinkedList<ResultValue>) rec.processQuery(request.getQuery());

		RcmResponseWrapper response = new RcmResponseWrapper(results);
	
		return response;

	}

}
