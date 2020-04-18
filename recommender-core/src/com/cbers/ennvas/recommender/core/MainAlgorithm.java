package com.cbers.ennvas.recommender.core;

import java.util.LinkedList;
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
	private LinkedList<StoredValue> storedValues;

	/**
	 * Constructs an algorithm object with a knowledge base.
	 * 
	 * @param storedValues Knowledge base
	 */
	public MainAlgorithm(LinkedList<StoredValue> storedValues)
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
	public LinkedList<ResultValue> processQuery(Query query)
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

		LinkedList<ResultValue> returnValues = new LinkedList<ResultValue>();
		
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

	public static void main(String[] args)
	{
		/*
		 * Create CLI presentation.
		 */
		
		String ennvasAsciiArt =
			" ______\n" +                           
			"|  ____|\n" +
			"| |__   _ __  _ ____   ____ _ ___\n" + 
			"|  __| | '_ \\| '_ \\ \\ / / _` / __|\n" +
			"| |____| | | | | | \\ V / (_| \\__ \\\n" +
			"|______|_| |_|_| |_|\\_/ \\__,_|___/\n";
		
		String ennvasPresentation =
			"Ennvas version 0.1 2020-04-18 19:00\n\n" +
			"Recommender component core algorithm test\n\n" +
			"By Juan Francisco Carrión Molina,\n" + 
			"Raquel Pérez González de Ossuna,\n" + 
			"Olga Posada Iglesias,\n" + 
			"Nicolás Pardina Popp and\n" + 
			"Melany Daniela Chicaiza Quezada.";
		
		String div = "\n----------------------------------------------\n";
		
		/*
		 * Create example products and store them.
		 */
		
		StoredValue v1 = new StoredValue(
			"Apple iPhone 11 (64 GB) - en Negro", // String name
			"smartphone", // String type
			"Apple", // String brand
			793.99, // double price
			0, // double shippingPrice
			20, // int shippingTime
			568, // int stock
			"Pantalla LCD Liquid Retina HD de 6,1 pulgadas, Resistencia al agua y al polvo (2 metros hasta 30 minutos, IP68), Sistema de cámara dual de 12 Mpx con gran angular y ultra gran angular; modo Noche, modo Retrato y vídeo 4K hasta 60 f/s, Cámara frontal TrueDepth de 12 Mpx con modo Retrato, vídeo 4K y ,grabación a cámara lenta, Face ID para autenticarse deforma segura yusar ApplePay, Chip A13 Bionic con Neural Engine de 3.ª generación, Admite la carga rápida Carga inalámbrica", // String description
			4.7 // double rating
		);

		StoredValue v2 = new StoredValue(
			"Samsung Galaxy 10+",
			"smartphone",
			"Samsung",
			1009,
			0,
			15,
			678,
			"Smartphone de 6.4 QHD+ Curved Dynamic AMOLED, 16 MP, Exynos 9820, Wireless & Fast & Reverse Charging, 128 GB, Prisma Negro (Prism Black) [Clase de eficiencia energética A]",
			4.6
		);

		StoredValue v3 = new StoredValue(
			"Frozen 2",
			"DVD, movies, children",
			"Disney",
			18.90,
			0,
			1,
			67,
			"Formato: Edición estandar, Audio: Inglés, Español, Subtítulos: Español, Región: Región 2, Calificación española (ICAA): Apta para todos los públicos",
			0
		);

		StoredValue v4 = new StoredValue(
			"Animal Crossing: New Horizons",
			"videogame",
			"Nintendo",
			59.90,
			3.99,
			3,
			1000,
			"Personaliza tu casa y a tu personaje, decora el paisaje (¡hasta con muebles, si quieres!) y ve creando poco a poco tu propia isla paradisíaca. ",
			5
		);
		
		LinkedList<StoredValue> storedValues = new LinkedList<StoredValue>();
		storedValues.add(v1);
		storedValues.add(v2);
		storedValues.add(v3);
		storedValues.add(v4);

		/*
		 * Create example query.
		 */

		Query query = new Query(
			"Apple iPhone 11 (64 GB) hey - - en Negro",
			300.0,
			400.0,
			true, // Envío gratuito
			7, // Tiempo máximo de entrega en días
			true, // Disponible
			3 // Rating
		);

		/*
		 * Run.
		 */
		
		System.out.println(ennvasAsciiArt);
		System.out.println(ennvasPresentation);
		System.out.println(div);

		System.out.println("### Stored articles are:\n");
		System.out.println(storedValues);
		System.out.println(div);
		 
		System.out.println("### Creating MainAlgorithm object.");
		MainAlgorithm rec = new MainAlgorithm(storedValues);
		System.out.println(div);

		System.out.println("### Current query is:\n");
		System.out.println(query);
		System.out.println(div);
		
		System.out.println("### Query passed and processed.");
		LinkedList<ResultValue> results = rec.processQuery(query);
		System.out.println(div);

		if (results.isEmpty()) {
			System.out.println("### No results were found. Try a less restrictive query.");
		} else {
			if (results.size() < 5) {
				System.out.println("### Only " + results.size() + " results were found.");
				System.out.println("### Try a less restrictive query.\n");
			} else {
				System.out.println("### Found " + results.size() + ".\n");
			}
			
			System.out.println("### Results:\n");
			System.out.println(results);
		}

	}
}