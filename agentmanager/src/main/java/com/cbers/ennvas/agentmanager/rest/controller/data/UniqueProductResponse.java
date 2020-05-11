package com.cbers.ennvas.agentmanager.rest.controller.data;

import lombok.Data;

@Data
public class UniqueProductResponse
{

	/**
	 * @var Product name
	 */
	private String name;
	
	/**
	 * @var Product type
	 */
	private String type;
	
	/**
	 * @var Product brand
	 */
	private String brand;
	
	/**
	 * @var Product price
	 */
	private double price;
	
	/**
	 * @var Product shipping price
	 */
	private double shippingPrice;
	
	/**
	 * @var Product shipping time
	 * 
	 * Measured in days.
	 */
	private int shippingTime;
	
	/**
	 * @var Product stock
	 *  
	 * Measured in product units.
	 */
	private int stock;
	
	/**
	 * @var Product description
	 */
	private String description;
	
	/**
	 * @var Product rating.
	 * 
	 * In range 0.0 to 5.0.
	 */
	private double rating;
}