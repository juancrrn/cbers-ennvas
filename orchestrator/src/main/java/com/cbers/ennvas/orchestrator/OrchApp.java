package com.cbers.ennvas.orchestrator;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Runs the orchestrator component Spring application.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * @author Melany Daniela Chicaiza Quezada
 * 
 * @version 1.0.0
 */

@SpringBootApplication
public class OrchApp
{
    
    public static void main(String[] args)
    {
        /*
         * Validate command line arguments.
         */
    
        if (args.length != 2) {
            throw new IllegalArgumentException("Two arguments are required.");
        }
    
        try {
            new URL(args[0]);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("First argument (agent manager component) is expected to be a correctly formatted URL (scheme://host:port).");
        }
    
        try {
            new URL(args[1]);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("First argument (recommender component) is expected to be a correctly formatted URL (scheme://host:port).");
        }

		/*
		 * Run the Spring application.
		 */

        SpringApplication.run(OrchApp.class, args);
    }
}