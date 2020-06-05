package com.cbers.frontend;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrontApp
{
    
    public static void main(String[] args)
    {
        /*
         * Validate command line arguments.
         */
    
        if (args.length != 1) {
            throw new IllegalArgumentException("One argument is required.");
        }
    
        try {
            new URL(args[0]);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("First argument (orchestrator component) is expected to be a correctly formatted URL (scheme://host:port).");
        }

		/*
		 * Run the Spring application.
		 */

        SpringApplication.run(FrontApp.class, args);
    }
}