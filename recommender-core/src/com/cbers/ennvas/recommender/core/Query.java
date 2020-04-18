package com.cbers.ennvas.recommender.core;

/**
 * Represents a query to the recommender.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * @author Melany Daniela Chicaiza Quezada
 * 
 * @version 0.1
 */

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
	 * @see StoredValue#utilityFunction
	 */
	
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
	 * @var Query free shipping.
	 * 
	 * Default value: false.
	 */
	private boolean freeShipping;
	
	/**
	 * @var Query maximum shipping time.
	 * 
	 * Measured in days.
	 * 
	 * Default value: 0.
	 */
	private int maxShippingTime;
	
	/**
	 * @var Query available.
	 * 
	 * Default value: false (accept both available and unavailable products).
	 */
	private boolean available;
	
	/**
	 * @var Query minimum rating.
	 * 
	 * Default value: 0.
	 */
	private double minRating;

	/**
	 * Constructs a Query object.
	 * 
	 * @param phrase
	 * @param priceMin
	 * @param priceMax
	 * @param freeShipping
	 * @param maxShippingTime
	 * @param available
	 * @param minRating
	 */
	public Query(
		String phrase,
		double priceMin,
		double priceMax,
		boolean freeShipping,
		int maxShippingTime,
		boolean available,
		double minRating
	)
	{
		this.phrase = phrase;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.freeShipping = freeShipping;
		this.maxShippingTime = maxShippingTime;
		this.available = available;
		this.minRating = minRating;
	}

	public String getPhrase()
	{
		return this.phrase;
	}

	public double getPriceMin()
	{
		return this.priceMin;
	}

	public double getPriceMax()
	{
		return this.priceMax;
	}

	public boolean isShippingFree()
	{
		return this.freeShipping;
	}

	public int getMaxShippingTime()
	{
		return this.maxShippingTime;
	}

	public boolean getAvailable()
	{
		return this.available;
	}

	public double getMinRating()
	{
		return this.minRating;
	}
	
	@Override
	public String toString() {
		String s =
			"Query: {\n" +
			"    phrase: \"" + this.getPhrase() + "\",\n" +
			"    priceMin: " + this.getPriceMin() + ",\n" +
			"    priceMax: " + this.getPriceMax() + ",\n" +
			"    freeShipping: " + this.isShippingFree() + ",\n" +
			"    maxShippingTime: " + this.getMaxShippingTime() + ",\n" +
			"    available: " + this.getAvailable() + ",\n" +
			"    minRating: " + this.getMinRating() + "\n" +
			"}";
		;
		
		return s;
	}

}