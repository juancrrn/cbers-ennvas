package com.cbers.ennvas.recommender.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a result of the recommender process.
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
		
		super.utility = s.getUtility();
	}

	/**
	 * Allows Jackson to serialize a ResultValue with a utility value field.
	 * 
	 * @return utility value
	 */
	@JsonProperty("utility_value")
	public double getUtilityValue()
	{
		return super.getUtility();
	}

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