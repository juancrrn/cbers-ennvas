package com.cbers.ennvas.recommender.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "phrase",
    "available",
    "free_shipping",
    "price_min",
    "price_max",
    "max_shipping_time",
    "min_rating"
})
public class Query
{

	/**
	 * @var Query phrase
	 * 
	 * May include name, type, brand and description.
	 */
	@JsonProperty("phrase")
	private String phrase;
	
	/**
	 * Default values are used to decide if data is relevant in
	 * the utility function. If value is default, data is ignored.
	 * 
	 * @see StoredValue#utilityFunction
	 */
	
	/**
	 * @var Query available.
	 * 
	 * Default value: false (accept both available and unavailable products).
	 */
	@JsonProperty("available")
	private boolean available;
	
	/**
	 * @var Query free shipping.
	 * 
	 * Default value: false.
	 */
	@JsonProperty("free_shipping")
	private boolean freeShipping;
	
	/**
	 * @var Query minimum price.
	 * 
	 * Default value: 0.0.
	 */
	@JsonProperty("price_min")
	private double priceMin;
	
	/**
	 * @var Query maximum price.
	 * 
	 * Default value: 0.0.
	 */
	@JsonProperty("price_max")
	private double priceMax;
	
	/**
	 * @var Query maximum shipping time.
	 * 
	 * Measured in days.
	 * 
	 * Default value: 0.
	 */
	@JsonProperty("max_shipping_time")
	private int maxShippingTime;
	
	/**
	 * @var Query minimum rating.
	 * 
	 * Default value: 0.
	 */
	@JsonProperty("min_rating")
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
	@JsonCreator
	public Query(
		@JsonProperty("phrase") String phrase,
		@JsonProperty("available") double priceMin,
		@JsonProperty("free_shipping") double priceMax,
		@JsonProperty("price_min") boolean freeShipping,
		@JsonProperty("price_max") int maxShippingTime,
		@JsonProperty("max_shipping_time") boolean available,
		@JsonProperty("min_rating") double minRating
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

	@JsonProperty("phrase")
	public String getPhrase()
	{
		return this.phrase;
	}

    @JsonProperty("phrase")
    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    @JsonProperty("available")
	public boolean getAvailable()
	{
		return this.available;
	}

    @JsonProperty("available")
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @JsonProperty("free_shipping")
    public boolean isFreeShipping() {
        return freeShipping;
    }

    @JsonProperty("free_shipping")
    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

	@JsonIgnore
	public boolean isShippingFree()
	{
		return this.freeShipping;
	}

    @JsonProperty("price_min")
	public double getPriceMin()
	{
		return this.priceMin;
	}

    @JsonProperty("price_min")
    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    @JsonProperty("price_max")
	public double getPriceMax()
	{
		return this.priceMax;
	}

    @JsonProperty("price_max")
    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }

    @JsonProperty("max_shipping_time")
	public int getMaxShippingTime()
	{
		return this.maxShippingTime;
	}

    @JsonProperty("max_shipping_time")
    public void setMaxShippingTime(int maxShippingTime) {
        this.maxShippingTime = maxShippingTime;
    }

    @JsonProperty("min_rating")
	public double getMinRating()
	{
		return this.minRating;
	}

    @JsonProperty("min_rating")
    public void setMinRating(int minRating) {
        this.minRating = minRating;
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