package com.cbers.ennvas.recommender.domain.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
 * @version 0.0.2
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "phrase",
    "available",
    "free_shipping",
    "price_min",
    "price_max",
    "max_shipping_time",
    "min_rating"
})
public class Query
{

	/**
	 * @var Query phrase
	 * 
	 * May include name, type, brand and description.
	 */
	private String phrase;
	
	/**
	 * Default values are used to decide if data is relevant in
	 * the utility function. If value is default, data is ignored.
	 * 
	 * @see UtilityFunction#calculate
	 */
	
	/**
	 * @var Query available.
	 * 
	 * Default value: false (accept both available and unavailable products).
	 */
	private boolean available;
	
	/**
	 * @var Query free shipping.
	 * 
	 * Default value: false.
	 */
	private boolean freeShipping;
	
	/**
	 * @var Query minimum price.
	 * 
	 * Default value: 0.0.
	 */
	private double priceMin;
	
	/**
	 * @var Query maximum price.
	 * 
	 * Default value: 0.0.
	 */
	private double priceMax;
	
	/**
	 * @var Query maximum shipping time.
	 * 
	 * Measured in days.
	 * 
	 * Default value: 0.
	 */
	private int maxShippingTime;
	
	/**
	 * @var Query minimum rating.
	 * 
	 * Default value: 0.
	 */
	private double minRating;
}