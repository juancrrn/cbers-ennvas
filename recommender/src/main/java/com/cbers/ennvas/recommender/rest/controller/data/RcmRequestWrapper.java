package com.cbers.ennvas.recommender.rest.controller.data;

import java.util.LinkedList;
import java.util.List;

import com.cbers.ennvas.recommender.domain.Query;
import com.cbers.ennvas.recommender.domain.StoredValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Wraps a request with a Query and a list of StoredValues (knowledgebase).
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
    "query",
    "stored_values"
})
public class RcmRequestWrapper
{

	@JsonProperty("query")
	private Query query;

	@JsonProperty("stored_values")
	private List<StoredValue> storedValues = null;

	@JsonIgnore
	public RcmRequestWrapper(Query query, List<StoredValue> storedValues)
	{
		this.query = query;
		this.storedValues = storedValues;
	}

	@JsonCreator
	public RcmRequestWrapper()
	{
		this.query = new Query();
		this.storedValues = new LinkedList<StoredValue>();
	}

    @JsonProperty("query")
	public Query getQuery()
	{
		return this.query;
	}

    @JsonProperty("query")
    public void setQuery(Query query) {
        this.query = query;
    }

    @JsonProperty("stored_values")
	public List<StoredValue> getStoredValues()
	{
		return this.storedValues;
	}

    @JsonProperty("stored_values")
    public void setStoredValues(List<StoredValue> storedValues) {
        this.storedValues = storedValues;
    }

	/**
	 * Generates a demo request.
	 * 
	 * @return demo request
	 */
	@JsonIgnore
	public static RcmRequestWrapper demoRequest()
	{

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
		
		StoredValue v5 = new StoredValue(
			"Toshiba Canvio Basics", 
			"electronics computer parts hdd", 
			"Toshiba",
			60.99,
			0.00, 
			1,
			200,
			"2TB Disco duro externo de 2.5 Acabado mate Puerto superspeed usb 3.0 Alimentado usb Toshiba Canvio Basics - Disco duro externo portátil USB 3.0 de 2.5 pulgadas (2 TB) color negro ", 
			4.6
		);

		StoredValue v6 = new StoredValue(
			"Virus!",
			"card games",
			"Tranjis Games",
			16.00,
			5.99,
			7,
			43,
			"Enfrentar la pandemia y competir para ser el primero en erradicar el virus mediante el aislamiento de un cuerpo sano. tico o no, todos los medios a su alcance son validos para lograr la victoria. Utiliza tu ingenio para boicotear los esfuerzos de sus rivales y ganar. Cada turno de Virus! ya sea que juegues una carta o descartar cualquier número de cartas, luego reponer la mano de tres cartas. Las tarjetas pueden ser: Uno de los cuatro granos (o el grano comodín) Uno de los cuatro virus (específico para cada grano o el virus comodín) Uno de los cuatro pastillas (específico para cada grano o la píldora comodín) Una carta de acción especial Se puede jugar solo una de cada granos en el rea del reproductor. Las píldoras y los virus se pueden reproducir en cualquier reproductor de granos, pero solo en el mismo grano de color. Una segunda píldora en cualquier grano que inmuniza contra la infección. Su objetivo es ser el primero en tener cuatro granos sanos en frente de usted.",
			4.8

		);

		StoredValue v7 = new StoredValue(
			"El Principito",
			"books classics",
			"Salamandra",
			5.65,
			2.99,
			1,
			113,
			"Antoine De Saint Exupery 96 páginas ISBN-10: 8498381495 El valor de la amistad, el heroísmo como meta y la responsabilidad como motor de la conducta moral encuentran su plasmación definitiva en el mundo que descubre El principito. ",
			4.7
		);

		StoredValue v8 = new StoredValue(
			"Casio Reloj Vintage",
			"digital watch",
			"Casio",
			10.43,
			0.00,
			2,
			34,
			"Color: Negro Incluye cronómetro, alarma, indicador de hora de 12/24 horas y calendario automático Caja y correa de resina sintética, un material resistente y flexible  La duración de la batería es de 7 años  Resistente al agua y soporta pequeñas salpicaduras de agua ",
			4.6
		);

		StoredValue v9 = new StoredValue(
			"Entrada 18 JSY",
			"football tshirt sports clothes",
			"Adidas",
			10.99,
			2.99,
			1,
			80,
			"Jersey de Fútbol de Manga Corta, Hombre XS/S/M/L/XL Regular fit Climalite anti-humidity fabric  50% Poliéster, 50% Poliéster Reciclado Adidas logo on the front Tecnologías innovadoras y el mayor confort. Esta camiseta está confeccionada con el material funcional climalite que garantiza una gestión óptima de la humedad. La tela ligera y el accesorio deportivo son agradables suaves en la piel, un ajuste perfecto y la máxima libertad de movimiento. El logo de rendimiento en el cofre y el clásico 3-Stripes en las mangas representan la marca de calidad adidas. ",
			4.5
		);

		List<StoredValue> storedValues = new LinkedList<StoredValue>();
		storedValues.add(v1);
		storedValues.add(v2);
		storedValues.add(v3);
		storedValues.add(v4);
		storedValues.add(v5);
		storedValues.add(v6);
		storedValues.add(v7);
		storedValues.add(v8);
		storedValues.add(v9);

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

		return new RcmRequestWrapper(query, storedValues);
	}
}