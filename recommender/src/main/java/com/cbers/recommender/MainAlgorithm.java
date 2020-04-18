package com.cbers.recommender;

import java.util.LinkedList;
import java.util.Comparator;

public class MainAlgorithm {
	private static final int FIRST_X_ELEMENTS = 5;
	private LinkedList<StoredValue> storedValues;

	public MainAlgorithm(LinkedList<StoredValue> storedValues)
	{
		this.storedValues = storedValues;
	}

	public LinkedList<ResultValue> processQuery(Query query)
	{
		/**
		 * Precalcular todas las utilidades de todos los artículos.
		 */

		for (StoredValue v : storedValues) {
			v.calculateUtility(query);
		}

		/**
		 * Ordenar valores de la base de conocimiento según la función de 
		 * utilidad del valor de consulta.
		 */

		this.storedValues.sort(Comparator.comparingDouble(StoredValue:: getUtility));
		
		/**
		 * Coger los primeros X elementos, es decir, los que mejor cumplen la
		 * función de utilidad.
		 * 
		 * Al mismo tiempo, transformamos los valores almacenados seleccionados 
		 * al formato de retorno.
		 */

		LinkedList<ResultValue> returnValues = new LinkedList<ResultValue>();
		
		for (int i = 0; i < FIRST_X_ELEMENTS; i++) {
			returnValues.add(new ResultValue(storedValues.get(i)));
		}

		/**
		 * Devolver elementos resultado.
		 */

		return returnValues;
	}

	public static void main(String[] args)
	{
		/**
		 * Recibimos la consulta por GET
		 */

		//JSONObject query = new JSONObject();//el json de la url;
		//JSONObject knowledgeBase = new JSONObject();
		
		/**
		 * Convertimos el JSON a LinkedList<StoredValue>
		 */
		//JSONObject jo = new JSONObject(new JSONTokener(in)); in siendo el fichero en un InputStream.
		//JSONArray arr = jo.getJSONArray("articles");


		Query query = new Query(
			"apple iphone 5 blanco",
			300.0,
			400.0,
			true, // Envío gratuito
			7, // Tiempo máximo de entrega en días
			true, // Disponible
			3 // Rating
		);
		
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

		/**
		 * Procesamos todo.
		 */

		System.out.println("Stored articles are:");
		System.out.println(storedValues);
		 
		System.out.println("Creating MainAlgorithm object.");
		MainAlgorithm rec = new MainAlgorithm(storedValues);

		System.out.println("Current query is:");
		System.out.println(query);
		
		System.out.println("Query passed and processed.");
		LinkedList<ResultValue> results = rec.processQuery(query);

		if (results.isEmpty()) {
			System.out.println("No results were found. Try a less restrictive query.");
		} else {
			System.out.println("Found " + results.size() + " results:");
			System.out.println(results);
		}

	}
}