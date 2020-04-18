package com.cbers.recommender;

public class StoredValue
{
	
	private String name;
	private String type;
	private String brand;
	private double price;
	private double shippingPrice;
	private int shippingTime; // En días
	private int stock; // En unidades disponibles
	private String description;
	private double rating;

	private double utility;

	public StoredValue(
		String name,
		String type,
		String brand,
		double price,
		double shippingPrice,
		int shippingTime,
		int stock,
		String description,
		double rating
	)
	{
		this.name = name;
		this.type = type;
		this.brand = brand;
		this.price = price;
		this.shippingPrice = shippingPrice;
		this.shippingTime = shippingTime;
		this.stock = stock;
		this.description = description;
		this.rating = rating;
	}

	/**
	 * Función de utilidad del algoritmo
	 * 
	 * Parámetros a comprobar:
	 *     String 	query.phrase
	 *     double 	query.priceMin
	 *     double 	query.priceMax
	 *     boolean 	query.freeShipping
	 *     int 		query.maxShippingTime
	 *     boolean 	query.available
	 *     double 	query.minRating
	 * 
	 * @param query
	 * 
	 * @return
	 */
	public double utilityFunction(Query query)
	{
		/**
		 * TODO: Comprobar que no sean null.
		 */

		/* El precio es excluyente. */
		if (query.getPriceMin() > this.getPrice() || query.getPriceMax() < this.getPrice()) {
			return 0;
		}

		/* El envío gratuito es excluyente. */
		if (query.isShippingFree() && ! this.isShippingFree()) {
			return 0;
		}

		/* El tiempo de envío máximo es excluyente. */
		if (query.getMaxShippingTime() < this.getShippingTime()) {
			return 0;
		}

		/* La disponibilidad es excluyente. */
		if (query.getAvailable() && ! this.isAvailable()) {
			return 0;
		}

		/* La valoración mínima es excluyente. */
		if (query.getMinRating() > this.getRating()) {
			return 0;
		}

		double utility = 0;

		String[] phraseArray = query.getPhrase().split(" ");

		/**
		 * TODO: Qué pasa con las palabras de una sola letra.
		 * TODO: Qué pasa con las tildes.
		 */

		for (String p : phraseArray) {
			if (this.name.toLowerCase().contains(p.toLowerCase())) {
				utility++;
			}

			if (this.type.toLowerCase().contains(p.toLowerCase())) {
				utility++;
			}

			if (this.brand.toLowerCase().contains(p.toLowerCase())) {
				utility++;
			}

			if (this.description.toLowerCase().contains(p.toLowerCase())) {
				utility++;
			}
		}

		return utility;
	}

	/**
	 * Precalcula la utilidad del artículo y la almacena.
	 * 
	 * @param query
	 */
	public void calculateUtility(Query query)
	{
		this.utility = this.utilityFunction(query);
	}

	public double getUtility()
	{
		return this.utility;
	}

	public String getName()
	{
		return this.name;
	}

	public String getType()
	{
		return this.type;
	}

	public String getBrand()
	{
		return this.brand;
	}

	public double getPrice()
	{
		return this.price;
	}

	public double getShippingPrice()
	{
		return this.shippingPrice;
	}

	public boolean isShippingFree()
	{
		return this.shippingPrice == 0;
	}

	public int getShippingTime()
	{
		return this.shippingTime;
	}

	public int getStock()
	{
		return this.stock;
	}
	
	public boolean isAvailable()
	{
		return this.stock > 0;
	}

	public String getDescription()
	{
		return this.description;
	}

	public double getRating()
	{
		return this.rating;
	}

}