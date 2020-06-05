package com.cbers.frontend.domain.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a query to the recommender.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * @author Melany Daniela Chicaiza Quezada
 * 
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Query
{

	/**
	 * Phrase. May include name, type, brand and description.
	 */
	private String phrase;
	
	/**
	 * Available. Default: false (accept both available and unavailable
	 * products).
	 */
	private boolean available;
	
	/**
	 * Free shipping. Default: false (accept product with free and non-free 
	 * shipping).
	 */
	private boolean freeShipping;
	
	/**
	 * Minimum price. Default: 0.0 (no minimum).
	 */
	private double priceMin;
	
	/**
	 * Maximum price. Default: 0.0 (no maximum).
	 */
	private double priceMax;
	
	/**
	 * Maximum shipping time (in days). Default: 0 (no maximum).
	 */
	private int maxShippingTime;
	
	/**
	 * Minimum rating. Default: 0 (no minimum).
	 */
	private double minRating;
	
	@Override
	public String toString()
	{
		return "Query: [ " +
		"phrase: " + this.phrase + ", " +
		"available: " + this.available + ", " +
		"freeShipping: " + this.freeShipping + ", " +
		"priceMin: " + this.priceMin + ", " +
		"priceMax: " + this.priceMax + ", " +
		"maxShippingTime: " + this.maxShippingTime + ", " +
		"minRating: " + this.minRating +
		" ]";
	}
}