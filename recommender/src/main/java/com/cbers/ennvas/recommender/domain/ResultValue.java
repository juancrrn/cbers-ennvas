package com.cbers.ennvas.recommender.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents a result of the recommender process.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * @author Melany Daniela Chicaiza Quezada
 * 
 * @version 0.1
 */

public class ResultValue extends StoredValue
{
	/**
	 * Constructor based in a stored product.
	 */
	@JsonIgnore
	public ResultValue(StoredValue s)
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
		
		this.utility = s.getUtility();
	}

	// TODO: Añadir utility al JSON de StoredValue.
	
	@Override
	public String toString() {
		String s =
				"ResultValue: {\n" +
				"    utility: " + this.getUtility() + ",\n" +
				"    name: \"" + this.getName() + "\"\n" +
				"}";
			;
			
			return s;
	}
}