package com.cbers.recommender;

public class ResultValue
{

	private final String name;
	private final String type;
	private final String brand;
	private final double price;
	private final double shippingPrice;
	private final int shippingTime; // En días
	private final int stock; // En unidades disponibles
	private final String description;
	private final double rating;

	/**
	 * Constructor basado en un elemento almacenado.
	 * @return
	 */
	public ResultValue(StoredValue s)
	{
		this.name = s.getName();
		this.type = s.getType();
		this.brand = s.getBrand();
		this.price = s.getPrice();
		this.shippingPrice = s.getShippingPrice();
		this.shippingTime = s.getShippingTime();
		this.stock = s.getStock();
		this.description = s.getDescription();
		this.rating = s.getRating();
	}

	
}