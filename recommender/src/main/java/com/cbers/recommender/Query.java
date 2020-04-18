package com.cbers.recommender;

public class Query
{

	/**
	 * Incluye name, type, brand y description
	 */
	private String phrase;
	
	private double priceMin;
	private double priceMax;
	private boolean freeShipping;
	private int maxShippingTime; // En días
	private boolean available; // El producto está disponible
	private double minRating;

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

}

