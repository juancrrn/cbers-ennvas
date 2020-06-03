package com.cbers.ennvas.recommender.domain;

import java.util.LinkedList;
import java.util.List;

import com.cbers.ennvas.recommender.domain.resource.Product;
import com.cbers.ennvas.recommender.domain.resource.Query;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

/**
 * Main algorigthm of Ennvas recommender component.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * 
 * @version 1.0.0
 */

public class MainAlgorithm
{

	/**
	 * Number of result elements to respond with.
	 */
	private int minimumUtility;
	
	/**
	 * Minimum accepted utility for the results.
	 */
	private int firstXElements;

	/**
	 * Knowledge base.
	 */
	@Setter
	@Getter
	private List<Product> products;

	/**
	 * Constructs an algorithm object with a knowledge base and pre-initializes 
	 * response products.
	 * 
	 * @param products Knowledge base.
	 */
	public MainAlgorithm(List<Product> products, int minimumUtility, int firstXElements)
	{
		this.products = new LinkedList<Product>();
		this.minimumUtility = minimumUtility;
		this.firstXElements = firstXElements;

		for (Product product : products) {
			this.products.add(new Product(product));
		}
	}

	/**
	 * Processes a query.
	 * 
	 * @param query Query to process.
	 * 
	 * @return Result list.
	 */
	public List<Product> processQuery(Query query)
	{
		System.out.println("[ENNVAS-RCM] Processing query with minimum utility " + this.minimumUtility + " and first x elements " + this.firstXElements + ".");

		/*
		 * Pre-calculate all products' utility based on the query.
		 */

		for (Product rp : this.products) {
			double utility = UtilityFunction.calculate(rp, query);
			rp.setUtility(utility);
		}

		/*
		 * Sort the knowledge base products by their utility.
		 */

		this.products.sort(Comparator.comparingDouble(Product:: getUtility).reversed());
		
		/*
		 * Take the first FIRST_X_ELEMENTS elements, that is, those whose
		 * utility value is higher.
		 * 
		 * We also require a minimum utility value: MINIMUM_UTILITY;
		 * 
		 * Simultaneously, we transform selected Product objects
		 * to ResponseProduct objects.
		 */

		List<Product> returnValues = new LinkedList<Product>();
		
		for (int i = 0; i < this.firstXElements && i < this.products.size(); i++) {
			if (this.products.get(i).getUtility() >= this.minimumUtility) {
				returnValues.add(new Product(products.get(i)));
			}
		}

		/*
		 * Return result objects.
		 */

		return returnValues;
	}
}