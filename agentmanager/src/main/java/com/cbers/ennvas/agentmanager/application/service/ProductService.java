package com.cbers.ennvas.agentmanager.application.service;

import com.cbers.ennvas.agentmanager.rest.controller.data.ProductResponse;

/**
 * Product service interface.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * 
 * @version 1.0.0
 */

public interface ProductService
{
	
	/**
	 * Returns all the products.
	 * 
	 * @return All the products.
	 */
	ProductResponse getAllProducts();
}