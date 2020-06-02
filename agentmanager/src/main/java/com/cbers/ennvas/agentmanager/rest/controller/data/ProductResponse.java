package com.cbers.ennvas.agentmanager.rest.controller.data;

import java.util.List;

import lombok.Data;

/**
 * TODO Describe this class
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * 
 * @version 1.0.0
 */

@Data
public class ProductResponse
{
	
	/**
	 * TODO Describe this property
	 */
	private List<UniqueProductResponse> products;
}