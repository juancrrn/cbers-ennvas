package com.cbers.recommender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RESTAPI {

	public static void main(String[] args)
	{
		SpringApplication.run(RESTAPI.class, args);
	}

	// localhost/hello?name=Juan

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		return "<h1>" + String.format("Hello %s!", name) + "</h1>";
	}

}
