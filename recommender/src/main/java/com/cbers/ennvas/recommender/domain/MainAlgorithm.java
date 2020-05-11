package com.cbers.ennvas.recommender.domain;

import java.util.LinkedList;
import java.util.List;

import com.cbers.ennvas.recommender.domain.resource.Product;
import com.cbers.ennvas.recommender.domain.resource.Query;
import com.cbers.ennvas.recommender.domain.resource.ResponseProduct;

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
 * @author Melany Daniela Chicaiza Quezada
 * 
 * @version 0.0.2
 */

public class MainAlgorithm
{

	/**
	 * @var Result elements to show the user. 
	 */
	private static final int FIRST_X_ELEMENTS = 6;
	
	/**
	 * @var Minimum accepted utility for the results.
	 */
	private static final int MINIMUM_UTILITY = 1;

	/**
	 * @var Knowledge base.
	 */
	@Setter
	@Getter
	private List<ResponseProduct> responseProducts;

	/**
	 * Constructs an algorithm object with a knowledge base and pre-initializes 
	 * response products.
	 * 
	 * @param products Knowledge base
	 */
	public MainAlgorithm(List<Product> products)
	{
		this.responseProducts = new LinkedList<ResponseProduct>();

		for (Product product : products) {
			this.responseProducts.add(new ResponseProduct(product));
		}
	}

	/**
	 * Processes a query.
	 * 
	 * @param query Query to process
	 * 
	 * @return Result list
	 */
	public List<ResponseProduct> processQuery(Query query)
	{
		/**
		 * Pre-calculate all products' utility based on the query.
		 */

		for (ResponseProduct rp : responseProducts) {
			double utility = UtilityFunction.calculate(rp, query);
			rp.setUtility(utility);
		}

		/**
		 * Sort the knowledge base products by their utility.
		 */

		this.responseProducts.sort(Comparator.comparingDouble(ResponseProduct:: getUtility).reversed());
		
		/**
		 * Take the first FIRST_X_ELEMENTS elements, that is, those whose
		 * utility value is higher.
		 * 
		 * We also require a minimum utility value: MINIMUM_UTILITY;
		 * 
		 * Simultaneously, we transform selected Product objects
		 * to ResponseProduct objects.
		 */

		List<ResponseProduct> returnValues = new LinkedList<ResponseProduct>();
		
		for (int i = 0; i < FIRST_X_ELEMENTS && i < responseProducts.size(); i++) {
			if (responseProducts.get(i).getUtility() >= MINIMUM_UTILITY) {
				returnValues.add(new ResponseProduct(responseProducts.get(i)));
			}
		}

		/**
		 * Return result objects.
		 */

		return returnValues;
	}
}