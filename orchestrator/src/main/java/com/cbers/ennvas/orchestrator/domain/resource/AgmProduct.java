package com.cbers.ennvas.orchestrator.domain.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a persistent value of a Product.
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
    "name",
    "type",
    "brand",
    "price",
    "stock",
    "description",
    "rating",
    "available",
    "shipping_price",
    "shipping_time"
})
public class AgmProduct
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

	@JsonIgnore
	public boolean isShippingFree() {
		return this.shippingPrice == 0;
	}

	@JsonIgnore
	public boolean isAvailable() {
		return this.stock > 0;
	}
}