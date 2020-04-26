package com.cbers.ennvas.recommender.rest.controller;

import java.util.LinkedList;
//import java.util.List;

import com.cbers.ennvas.recommender.domain.MainAlgorithm;
import com.cbers.ennvas.recommender.domain.ResultValue;
import com.cbers.ennvas.recommender.rest.controller.data.RcmRequestWrapper;
import com.cbers.ennvas.recommender.rest.controller.data.RcmResponseWrapper;

//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ennvas/rcm/rest")
public class RcmRestController
{

	/**
	 * Receives a POST request and passes it as RcmRequestWrapper to 
	 * RcmRestController#passRequest.
	 * 
	 * @see https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-requestbody
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
