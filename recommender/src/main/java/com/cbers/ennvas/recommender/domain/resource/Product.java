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
		this.name = p.getName();
		this.type = p.getType();
		this.brand = p.getBrand();
		this.price = p.getPrice();
		this.stock = p.getStock();
		this.rating = p.getRating();
		this.shippingPrice = p.getShippingPrice();
		this.shippingTime = p.getShippingTime();
		this.description = p.getDescription();
		this.providerName = p.getProviderName();
		this.providerUniqueUrl = p.getProviderUniqueUrl();
		this.utility = p.getUtility();
	}
	
	@Override
	public String toString()
	{
		return "Product: [ " +
		"name: " + this.getName() + ", " +
		"type: " + this.getType() + ", " +
		"brand: " + this.getBrand() + ", " +
		"price: " + this.getPrice() + ", " +
		"stock: " + this.getStock() + ", " +
		"rating: " + this.getRating() + ", " +
		"shippingPrice: " + this.getShippingPrice() + ", " +
		"shippingTime: " + this.getShippingTime() + ", " +
		"description: " + this.getDescription() + ", " +
		"providerName: " + this.getProviderName() + ", " +
		"providerUniqueUrl: " + this.getProviderUniqueUrl() + ", " +
		"utility: " + this.getUtility() +
		" ]";
	}
} 