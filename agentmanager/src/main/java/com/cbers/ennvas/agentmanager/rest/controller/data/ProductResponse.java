package com.cbers.ennvas.agentmanager.rest.controller.data;

import java.util.List;

import lombok.Data;

/**
 * Product response.
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
	 * A list with the products of the response.
	 */
	private List<UniqueProductResponse> products;
}