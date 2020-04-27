package com.cbers.ennvas.recommender.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Represents a stored value of a product.
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
public class StoredValue
{

	/**
	 * @var Product name
	 */
	@JsonProperty("name")
	private String name;
	
	/**
	 * @var Product type
	 */
	@JsonProperty("type")
	private String type;
	
	/**
	 * @var Product brand
	 */
	@JsonProperty("brand")
	private String brand;
	
	/**
	 * @var Product price
	 */
	@JsonProperty("price")
	private double price;
	
	/**
	 * @var Product stock
	 *  
	 * Measured in product units.
	 */
	@JsonProperty("stock")
	private int stock;
	
	/**
	 * @var Product description
	 */
	@JsonProperty("description")
	private String description;
	
	/**
	 * @var Product rating.
	 * 
	 * In range 0.0 to 5.0.
	 */
	@JsonProperty("rating")
	private double rating;
	
	/**
	 * @var Product shipping price
	 */
	@JsonProperty("shipping_price")
	private double shippingPrice;
	
	/**
	 * @var Product shipping time
	 * 
	 * Measured in days.
	 */
	@JsonProperty("shipping_time")
	private int shippingTime;

	/**
	 * @var Unicode characters to be replaced.
	 */
	@JsonIgnore
	private static final String UNICODE =
		"ÀàÈèÌìÒòÙùÁáÉéÍíÓóÚúÝýÂâÊêÎîÔôÛûŶŷÃãÕõÑñÄäËëÏïÖöÜüŸÿÅåÇçŐőŰű";
	
	/**
	 * @var ASCII characters to replace with.
	 */
	@JsonIgnore
	private static final String PLAIN_ASCII =
		"AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu";

	/**
	 * @var Product utility
	 * 
	 * Calculated statically and on demand.
	 */
	@JsonIgnore
	protected double utility;

	/**
	 * @var Additional properties added by Jackson.
	 */
	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Constructs a StoredValue object.
	 * 
	 * @param name
	 * @param type
	 * @param brand
	 * @param price
	 * @param shippingPrice
	 * @param shippingTime
	 * @param stock
	 * @param description
	 * @param rating
	 */
	@JsonIgnore
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

	@JsonCreator
	public StoredValue()
	{
		this.name = "";
		this.type = "";
		this.brand = "";
		this.price = 0;
		this.shippingPrice = 0;
		this.shippingTime = 0;
		this.stock = 0;
		this.description = "";
		this.rating = 0;
	}
	
	/**
	 * Converts an Unicode string to plain ASCII.
	 * 
	 * @param str String to convert
	 * 
	 * @return Converted string
	 */
	@JsonIgnore
	public static String strToAscii(String str) {
	    if (str == null) {
	        return null;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for (int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        int pos = UNICODE.indexOf(c);
	        if (pos > -1) {
	            sb.append(PLAIN_ASCII.charAt(pos));
	        } else {
	            sb.append(c);
	        }
	    }
	    
	    return sb.toString();
	}

	/**
	 * Utility function
	 * 
	 * Returns an utility value based on a query.
	 * 
	 * @param query Query base
	 * 
	 * @return Utility value
	 */
	@JsonIgnore
	public double utilityFunction(Query query)
	{

		double utility = 0;
		
		/*
		 * Every "if" statement checks if the param has a default value.
		 * If value is default, param is not checked, it is taken as null
		 * (not specified).
		 * 
		 * Negative utility values are allowed, as getting any result is a
		 * priority.
		 */
		
		/* Query minimum price. */
		if (query.getPriceMin() > 0.0 && query.getPriceMin() > this.getPrice()) {
			utility--;
		}

		/* Query maximum price. */
		if (query.getPriceMax() > 0.0 && query.getPriceMax() < this.getPrice()) {
			utility--;
		}

		/* Query free shipping. */
		if (query.isShippingFree() && ! this.isShippingFree()) {
			utility--;
		}

		/* Query maximum shipping time. */
		if (query.getMaxShippingTime() > 0 && query.getMaxShippingTime() < this.getShippingTime()) {
			utility--;
		}

		/* Query available. */
		if (query.getAvailable() && ! this.isAvailable()) {
			utility--;
		}

		/* Query minimum rating. */
		if (query.getMinRating() > 0 && query.getMinRating() > this.getRating()) {
			utility--;
		}
		
		/*
		 * Ignore special symbols: allow only a-z, A-Z, 0-9 and space.
		 * Also compress spaces: "    " and " " are replaced with ";".
		 */
		
		String phrase = query.getPhrase().replaceAll("[^\\sA-Za-z0-9]", "");
		phrase = phrase.replaceAll("[\\s]+", ";");
		
		/*
		 * Semicolon-split the phrase.
		 */
		
		String[] phraseArray = phrase.split(";");

		/*
		 * TODO: Qué pasa con las palabras de una sola letra.
		 * TODO: Qué pasa con las palabras sin significado (preposiciones, etc.).
		 * TODO: Qué pasa con las palabras repetidas.
		 */

		for (String p : phraseArray) {
			/*
			 * All strings are ASCII-compared to avoid diacritic mistakes.
			 * 
			 * Lowercase the phrase.
			 */
			
			String lcp = StoredValue.strToAscii(p).toLowerCase();
			
			/*
			 * Check every attribute that could be specified in the phrase.
			 */
			
			if (StoredValue.strToAscii(this.name).toLowerCase().contains(lcp)) {
				utility++;
			}

			if (StoredValue.strToAscii(this.type).toLowerCase().contains(lcp)) {
				utility++;
			}

			if (StoredValue.strToAscii(this.brand).toLowerCase().contains(lcp)) {
				utility++;
			}

			if (StoredValue.strToAscii(this.description).toLowerCase().contains(lcp)) {
				utility++;
			}
		}

		return utility;
	}

    @JsonProperty("name")
	public String getName()
	{
		return this.name;
	}

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("type")
	public String getType()
	{
		return this.type;
	}

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("brand")
	public String getBrand()
	{
		return this.brand;
	}

    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonProperty("price")
	public double getPrice()
	{
		return this.price;
	}

    @JsonProperty("price")
    public void setPrice(double price) {
        this.price = price;
	}
	
    @JsonProperty("stock")
	public int getStock()
	{
		return this.stock;
	}

    @JsonProperty("stock")
    public void setStock(int stock) {
        this.stock = stock;
    }
	
	@JsonIgnore
	public boolean isAvailable()
	{
		return this.stock > 0;
	}

    @JsonProperty("description")
	public String getDescription()
	{
		return this.description;
	}

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("rating")
	public double getRating()
	{
		return this.rating;
	}

    @JsonProperty("rating")
    public void setRating(double rating) {
        this.rating = rating;
    }

    @JsonProperty("shipping_price")
	public double getShippingPrice()
	{
		return this.shippingPrice;
	}

    @JsonProperty("shipping_price")
    public void setShippingPrice(double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

	@JsonIgnore
	public boolean isShippingFree()
	{
		return this.shippingPrice == 0;
	}

    @JsonProperty("shipping_time")
	public int getShippingTime()
	{
		return this.shippingTime;
	}

    @JsonProperty("shipping_time")
    public void setShippingTime(int shippingTime) {
        this.shippingTime = shippingTime;
    }

	/**
	 * Pre-calculates and stores the product utility.
	 * 
	 * @param query Query to use in the utility function
	 */
	@JsonIgnore
	public void calculateUtility(Query query)
	{
		this.utility = this.utilityFunction(query);
	}

	@JsonIgnore
	public double getUtility()
	{
		return this.utility;
	}
	
	@Override
	@JsonIgnore
	public String toString() {
		String s =
			"StoredValue: {\n" +
			"    name: \"" + this.getName() + "\",\n" +
			"    type: \"" + this.getType() + "\",\n" +
			"    brand: \"" + this.getBrand() + "\",\n" +
			"    price: " + this.getPrice() + ",\n" +
			"    shippingPrice: " + this.getShippingPrice() + ",\n" +
			"    shippingTime: " + this.getShippingTime() + ",\n" +
			"    stock: " + this.getStock() + ",\n" +
			"    description: \"" + this.getDescription() + "\",\n" +
			"    rating: " + this.getRating() + "\n" +
			"}";
		;
		
		return s;
	}

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public StoredValue withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}