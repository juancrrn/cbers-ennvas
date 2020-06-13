package com.cbers.ennvas.agentmanager.rest.controller.data;

import lombok.Data;

/**
 * Response for a single product.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * 
 * @version 1.0.0
 */

@Data
public class UniqueProductResponse
{

	/**
	 * Name.
	 */
	private String name;
	
	/**
	 * Type.
	 */
	private String type;
	
	/**
	 * Brand.
	 */
	private String brand;
	
	/**
	 * Price (in euros).
	 */
	private double price;
	
	/**
	 * Stock (in units).
	 */
	private int stock;
	
	/**
	 * Rating (in range 0.0 to 5.0).
	 */
	private double rating;
	
	/**
	 * Shipping price (in euros).
	 */
	private double shippingPrice;
	
	/**
	 * Shipping time (in days).
	 */
	private int shippingTime;
	
	/**
	 * Description.
	 */
	private String description;

	/**
	 * Provider name (store).
	 */
	private String providerName;

	/**
	 * Provider unique URL (product URL).
	 */
	private String providerUniqueUrl;
}