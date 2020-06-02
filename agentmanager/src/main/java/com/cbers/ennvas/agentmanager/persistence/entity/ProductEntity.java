package com.cbers.ennvas.agentmanager.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

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
 * @version 1.0.0
 */

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity
{

	/**
	 * Unique identifier.
	 */
	@Id
	@GeneratedValue
	private Integer productId;

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
	@Lob
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