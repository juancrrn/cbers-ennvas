package com.cbers.ennvas.agentmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Runs the agent manager component Spring application.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * 
 * @version 1.0.0
 */

@SpringBootApplication
public class AgmApp
{

	public static void main(String[] args)
	{
        /*
         * Validate command line arguments.
         */
    
        if (args.length != 1) {
            throw new IllegalArgumentException("One argument is required. First argument (demo data path) is expected to be a file path.");
        }

		/*
		 * Run the Spring application.
		 */

		SpringApplication.run(AgmApp.class, args);
	}
}