package com.cbers.ennvas.recommender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Runs the recommender component Spring application.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * 
 * @version 1.0.0
 */

@SpringBootApplication
public class RcmApp
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
			Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("First argument (minimum utility) is expected to be an integer.");
		}

		try {
			Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Second argument (first x elements) is expected to be an integer.");
		}

		/*
		 * Run the Spring application.
		 */

		SpringApplication.run(RcmApp.class, args);
	}
}