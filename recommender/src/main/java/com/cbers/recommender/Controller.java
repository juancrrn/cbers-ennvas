package com.cbers.recommender;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Controller {

	public static void main(String[] args)
	{
		SpringApplication.run(Controller.class, args);
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/request")
	public String request(@RequestParam(value = "query") String query)
	{
		/**
		 * Llamar a la función que procesa la consulta.
		 */
		ArrayList<Result> results = MainAlgorithm.processRequest(query);

		/**
		 * Construir el JSON.
		 * 
		 * {
		 * 	"query": "..."
		 *  "result":
		 * 		{
		 * 			"1":
		 * 				{
		 * 					"id": 98
		 * 				},
		 * 			"2":
		 * 				{
		 * 					"id": 72
		 * 				}
		 * 		}
		 * }
		 */
		String jsonOutput = "";

		return jsonOutput;
	}

}
