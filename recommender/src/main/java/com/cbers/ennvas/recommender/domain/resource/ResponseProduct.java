package com.cbers.ennvas.recommender.domain.resource;

import com.cbers.ennvas.recommender.domain.resource.Product;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a result of the recommender process, a Product wrapper.
 * 
 * Uses Jackson annotations.
 * @see https://github.com/FasterXML/jackson-docs
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
@EqualsAndHashCode(callSuper = false)
public class ResponseProduct extends Product
{
	
	/**
	 * @var Product utility
	 * 
	 * Calculated statically and on demand.
	 */
	private double utility;

	/**
	 * Constructor based in a stored product.
	 */
	public ResponseProduct(Product s)
	{
		super(
			s.getName(),
			s.getType(),
			s.getBrand(),
			s.getPrice(),
			s.getShippingPrice(),
			s.getShippingTime(),
			s.getStock(),
			s.getDescription(),
			s.getRating()
		);
		
		this.utility = 0;
	}
}