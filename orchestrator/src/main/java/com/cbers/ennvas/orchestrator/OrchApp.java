package com.cbers.ennvas.orchestrator;

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
 * @version 0.0.2
 */

@SpringBootApplication
public class OrchApp
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(OrchApp.class, args);
    }
}