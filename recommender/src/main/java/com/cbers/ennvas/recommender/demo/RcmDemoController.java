package com.cbers.ennvas.recommender.demo;

import com.cbers.ennvas.recommender.rest.controller.RcmRestController;
import com.cbers.ennvas.recommender.rest.controller.data.RcmRequestWrapper;
import com.cbers.ennvas.recommender.rest.controller.data.RcmResponseWrapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ennvas/rcm/demo")
public class RcmDemoController
{

	/**
	 * Generates a demo RcmRequestWrapper and returns it.
	 * 
	 * @return response body
	 */
	@GetMapping(
		value = "/generate",
		produces = "application/json"
	)
	public RcmRequestWrapper demoGen()
	{

		return RcmRequestWrapper.demoRequest();

	}

	/**
	 * Generates a demo RcmRequestWrapper and passes it to 
	 * RcmRestController#passRequest.
	 * 
	 * @return response body
	 */
	@GetMapping(
		value = "/run",
		produces = "application/json"
	)
	public RcmResponseWrapper demoRun()
	{

		RcmRequestWrapper request = RcmRequestWrapper.demoRequest();

		return RcmRestController.passRequest(request);

	}

}