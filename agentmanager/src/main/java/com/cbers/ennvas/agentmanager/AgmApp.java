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
 * @author Melany Daniela Chicaiza Quezada
 * 
 * @version 0.0.2
 */

@SpringBootApplication
public class AgmApp
{

	public static void main(String[] args)
	{
		SpringApplication.run(AgmApp.class, args);
	}
}