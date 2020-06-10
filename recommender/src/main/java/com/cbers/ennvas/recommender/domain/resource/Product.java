package com.cbers.ennvas.recommender.domain.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
 * 
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product
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
	
	/**
	 * Utility. Calculated statically and on demand.
	 */
	@JsonIgnore
	private double utility;

	/**
	 * Constructs a Product from another Product.
	 * 
	 * @param p Source Product.
	 */
	public Product(Product p)
	{
		this.name = p.name;
		this.type = p.type;
		this.brand = p.brand;
		this.price = p.price;
		this.stock = p.stock;
		this.rating = p.rating;
		this.shippingPrice = p.shippingPrice;
		this.shippingTime = p.shippingTime;
		this.description = p.description;
		this.utility = p.utility;
		this.providerName = p.providerName;
		this.providerUniqueUrl = p.providerUniqueUrl;
	}
	
	@Override
	public String toString()
	{
		return "Product: [ " +
		"name: " + this.name + ", " +
		"type: " + this.type + ", " +
		"brand: " + this.brand + ", " +
		"price: " + this.price + ", " +
		"stock: " + this.stock + ", " +
		"rating: " + this.rating + ", " +
		"shippingPrice: " + this.shippingPrice + ", " +
		"shippingTime: " + this.shippingTime + ", " +
		"description: " + this.description + ", " +
		"providerName: " + this.providerName + ", " +
		"providerUniqueUrl: " + this.providerUniqueUrl +
		"UTILITY: " + this.utility +
		" ]";
	}
} 