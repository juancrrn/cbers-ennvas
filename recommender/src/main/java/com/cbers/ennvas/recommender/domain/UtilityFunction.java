package com.cbers.ennvas.recommender.domain;

import com.cbers.ennvas.recommender.domain.resource.Product;
import com.cbers.ennvas.recommender.domain.resource.Query;

/**
 * Provides the calculation of the algorithm's utility function.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * @author Melany Daniela Chicaiza Quezada
 * 
 * @version 0.0.2
 */

public class UtilityFunction
{

	/**
	 * @var Unicode characters to be replaced.
	 */
	private static final String UNICODE =
		"ÀàÈèÌìÒòÙùÁáÉéÍíÓóÚúÝýÂâÊêÎîÔôÛûŶŷÃãÕõÑñÄäËëÏïÖöÜüŸÿÅåÇçŐőŰű";
	
	/**
	 * @var ASCII characters to replace with.
	 */
	private static final String PLAIN_ASCII =
		"AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu";
		
	/**
	 * Converts an Unicode string to plain ASCII.
	 * 
	 * @param str String to convert
	 * 
	 * @return Converted string
	 */
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
	public static double calculate(Product product, Query query)
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
		if (query.getPriceMin() > 0.0 && query.getPriceMin() > product.getPrice()) {
			utility--;
		}

		/* Query maximum price. */
		if (query.getPriceMax() > 0.0 && query.getPriceMax() < product.getPrice()) {
			utility--;
		}

		/* Query free shipping. */
		if (query.isFreeShipping() && ! product.isShippingFree()) {
			utility--;
		}

		/* Query maximum shipping time. */
		if (query.getMaxShippingTime() > 0 && query.getMaxShippingTime() < product.getShippingTime()) {
			utility--;
		}

		/* Query available. */
		if (query.isAvailable() && ! product.isAvailable()) {
			utility--;
		}

		/* Query minimum rating. */
		if (query.getMinRating() > 0 && query.getMinRating() > product.getRating()) {
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
			
			String lcp = UtilityFunction.strToAscii(p).toLowerCase();
			
			/*
			 * Check every attribute that could be specified in the phrase.
			 */
			
			if (UtilityFunction.strToAscii(product.getName()).toLowerCase().contains(lcp)) {
				utility++;
			}

			if (UtilityFunction.strToAscii(product.getType()).toLowerCase().contains(lcp)) {
				utility++;
			}

			if (UtilityFunction.strToAscii(product.getBrand()).toLowerCase().contains(lcp)) {
				utility++;
			}

			if (UtilityFunction.strToAscii(product.getDescription()).toLowerCase().contains(lcp)) {
				utility++;
			}
		}

		return utility;
	}
}