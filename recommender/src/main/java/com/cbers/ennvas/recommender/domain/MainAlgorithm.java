package com.cbers.ennvas.recommender.domain;

import java.util.LinkedList;
import java.util.List;
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
 * @version 0.1
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
	private List<StoredValue> storedValues;

	/**
	 * Constructs an algorithm object with a knowledge base.
	 * 
	 * @param storedValues Knowledge base
	 */
	public MainAlgorithm(List<StoredValue> storedValues)
	{
		this.storedValues = storedValues;
	}

	/**
	 * Processes a query.
	 * 
	 * @param query Query to process
	 * 
	 * @return Result list
	 */
	public List<ResultValue> processQuery(Query query)
	{
		/**
		 * Pre-calculate all products' utility based on the query.
		 */

		for (StoredValue v : storedValues) {
			v.calculateUtility(query);
		}

		/**
		 * Sort the knowledge base products by their utility.
		 */

		this.storedValues.sort(Comparator.comparingDouble(StoredValue:: getUtility).reversed());
		
		/**
		 * Take the first FIRST_X_ELEMENTS elements, that is, those whose
		 * utility value is higher.
		 * 
		 * We also require a minimum utility value: MINIMUM_UTILITY;
		 * 
		 * Simultaneously, we transform selected StoredValue objects
		 * to ResultValue objects.
		 */

		List<ResultValue> returnValues = new LinkedList<ResultValue>();
		
		for (int i = 0; i < FIRST_X_ELEMENTS && i < storedValues.size(); i++) {
			if (storedValues.get(i).getUtility() >= MINIMUM_UTILITY) {
				returnValues.add(new ResultValue(storedValues.get(i)));
			}
		}

		/**
		 * Return result objects.
		 */

		return returnValues;
	}

}