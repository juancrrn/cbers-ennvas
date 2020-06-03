package com.cbers.ennvas.recommender.rest.controller;

import java.util.LinkedList;
import java.util.List;

import com.cbers.ennvas.recommender.domain.MainAlgorithm;
import com.cbers.ennvas.recommender.domain.resource.Product;
import com.cbers.ennvas.recommender.domain.resource.ProductList;

import com.cbers.ennvas.recommender.rest.controller.data.RcmRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
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
 * 
 * @version 1.0.0
 */

@RestController
@RequestMapping("/ennvas/rcm/rest")
public class RcmRestController
{

	@Autowired
	private ApplicationArguments applicationArguments;

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
	 * @param input InputWrapper that contains a query and a knowledge base.
	 * 
	 * @return response body
	 */
	@PostMapping(
		value = "/process",
		consumes = "application/json",
		produces = "application/json"
	)
	public ProductList process(@RequestBody RcmRequest request)
	{
		System.out.println("[ENNVAS-RCM] Received query process request.");

		/*
		 * Retrieve command line arguments (pre-validated).
		 */

		String[] args = applicationArguments.getSourceArgs();
		int minimumUtilityArg = Integer.parseInt(args[0]);
		int firstXElementsArg = Integer.parseInt(args[1]);

		/*
		 * Pass the request.
		 */

		return RcmRestController.passRequest(
			request,
			minimumUtilityArg,
			firstXElementsArg
		);
	}

	/**
	 * Initializes the algorithm with the parameters and processes the query.
	 * 
	 * @param request
	 * 
	 * @return Response wrapper with the result values.
	 */
	public static ProductList passRequest(RcmRequest request, int minimumUtilityArg, int firstXElementsArg)
	{
		System.out.println("[ENNVAS-RCM] Received query:\n");
		System.out.println(request.getQuery());
		System.out.println("");

		System.out.println("[ENNVAS-RCM] Received knowledge base products:\n");

		for (int i = 0; i < request.getProducts().size(); i++) {
			System.out.println(request.getProducts().get(i));
			System.out.println("");
		}

		/*
		 * Instantiate the algorithm.
		 */

		MainAlgorithm rec = new MainAlgorithm(request.getProducts(), minimumUtilityArg, firstXElementsArg);

		List<Product> results =
			(LinkedList<Product>) rec.processQuery(request.getQuery());

		System.out.println("[ENNVAS-RCM] Algorithm result products:\n");

		for (int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
			System.out.println("");
		}

		System.out.println("[ENNVAS-RCM] Query processed correctly.\n");

		ProductList response = new ProductList(results);

		System.out.println("[ENNVAS-RCM] Sending query process results.\n");
	
		return response;
	}
}