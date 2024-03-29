# Cbers Ennvas

Ennvas is an artificial-intelligence-based multiagent shopping system developped by Cbers for the subject Software Engineering 2 at the Complutense University of Madrid.

Documentation/documentación: [Project final report.pdf](https://github.com/juancrrn/cbers-ennvas/blob/master/Project%20final%20report.pdf)

## Installation

Ennvas is presented as a distributed architecture application. The four components can be run in different machines or in the same one, as they use HTTP REST API communications.

The first thing to do is to initialize the MySQL database in the machine where the agent manager component will be running. Credentials can be modified in `.\agentmanager\src\main\resources\application.properties`.

Then, compile the sources of the four components. Run this command in every component's root directory:

```console
$ mvn clean package
```

## Simple running

1. Start the MySQL server.

2. Start the agent manager component. It receives one argument, which is the path to the demo data JSON file.

```console
$ java -jar .\agentmanager\target\agentmanager-1.0.0.jar ".\agentmanager\src\main\resources\demo\demo-products.json"
```

3. Start the recommender component. It receives two arguments, which are a minimum utility function for a product to be shown in the result, and the quantity of products to be shown in total.

```console
$ java -jar .\recommender\target\recommender-1.0.0.jar 1 6
```

4. Start the orchestrator component. It receives two arguments, which are the URLs of the agent manager and recommender components.

```console
$ java -jar .\target\orchestrator-1.0.0.jar http://localhost:60002 http://localhost:60004
```

5. Start the front end component. It receives one argument, which is the URL of the orchestrator component.

```console
$ java -jar .\target\frontend-1.0.0.jar http://localhost:60003
```

6. Visit the front end web UI

With all the components running, a web UI should be available generated by the front end component. By default, it is available on `http://localhost:60005`. This UI shows a simple form that submits a query to the front end application via AJAX, and receives a list of products which will be shown in the HTML list.

## Components

### Agent manager

The agent manager is in charge of managing the agents that retrieve data from the websites as a web crawler, and stores all the information in a persistent way.

Acting as a service, it receives an empty GET request and responds with all the product data it has stored.

### Recommender component

The recommender component receives a query and the product data and runs the utility algorithm with them. Then, it returns the product list result.

### Orchestrator component

The orchestrator component receives a query from the front end, fetches all the product data from the agent manager, sends both query and product data to the recommender and returns a product list result to the front end.

### Front end component

The front end component serves the web UI and acts as a bridge between it and the orchestrator, as requests cannot be sent directly due to cross site risks prevention.

## Demo

In the next titles, we show how to send demo requests to the components via a REST client, e. g. Advanced Rest Client.

### Agent manager

- REST endpoint: `http://localhost:60002/ennvas/agm/rest/retrieve`
- Method: `GET`

### Recommender component

- REST endpoint: `http://localhost:60004/ennvas/rcm/rest/process`
- Method: `POST`
- Content-type: `application/json`
- Body:

```json
{
	"query":{
		"phrase":"Apple iPhone 11 (64 GB) hey - - en Negro",
		"available":false,
		"freeShipping":true,
		"priceMin":300,
		"priceMax":800,
		"maxShippingTime":21,
		"minRating":3
	},
	"products":[
		{
			"name":"Apple iPhone 11 (64 GB) - en Negro",
			"type":"smartphone",
			"brand":"Apple",
			"price":793.99,
			"stock":568,
			"rating":4.7,
			"shippingPrice":0,
			"shippingTime":20,
			"description":"Pantalla LCD Liquid Retina HD de 6,1 pulgadas, Resistencia al agua y al polvo (2 metros hasta 30 minutos, IP68), Sistema de cámara dual de 12 Mpx con gran angular y ultra gran angular; modo Noche, modo Retrato y vídeo 4K hasta 60 f/s, Cámara frontal TrueDepth de 12 Mpx con modo Retrato, vídeo 4K y ,grabación a cámara lenta, Face ID para autenticarse de forma segura y usar ApplePay, Chip A13 Bionic con Neural Engine de 3.ª generación, Admite la carga rápida Carga inalámbrica",
			"providerName":"Amazon",
			"providerUniqueUrl":"https://www.amazon.es/Apple-iPhone-11-64-GB-Negro/dp/B07XS2ZR1K"
		},
		{
			"name":"Samsung Galaxy 10+",
			"type":"smartphone",
			"brand":"Samsung",
			"price":1009,
			"stock":678,
			"rating":4.6,
			"shippingPrice":0,
			"shippingTime":15,
			"description":"Smartphone de 6.4 QHD+ Curved Dynamic AMOLED, 16 MP, Exynos 9820, Wireless & Fast & Reverse Charging, 128 GB, Prisma Negro (Prism Black) [Clase de eficiencia energética A]",
			"providerName":"Amazon",
			"providerUniqueUrl":"https://www.amazon.es/Samsung-Galaxy-S10-Smartphone-Wireless/dp/B07NDD7W23/ref=sr_1_3?__mk_es_ES=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=samsung+galaxy+10%2B&qid=1591004563&s=electronics&sr=1-3"
		},
		{
			"name":"Frozen 2",
			"type":"DVD, movies, children",
			"brand":"Disney",
			"price":18.9,
			"stock":67,
			"rating":0,
			"shippingPrice":0,
			"shippingTime":1,
			"description":"Formato: Edición estandar, Audio: Inglés, Español, Subtítulos: Español, Región: Región 2, Calificación española (ICAA): Apta para todos los públicos",
			"providerName":"Amazon",
			"providerUniqueUrl":"https://www.amazon.es/Frozen-2-DVD-No-aplica/dp/B081FRR2R7/ref=sr_1_1?__mk_es_ES=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=frozen+2+dvd&qid=1591004673&sr=8-1"
		},
		{
			"name":"Animal Crossing: New Horizons",
			"type":"videogame",
			"brand":"Nintendo",
			"price":59.9,
			"stock":1000,
			"rating":5,
			"shippingPrice":3.99,
			"shippingTime":3,
			"description":"Personaliza tu casa y a tu personaje, decora el paisaje (¡hasta con muebles, si quieres!) y ve creando poco a poco tu propia isla paradisíaca. ",
			"providerName":"Amazon",
			"providerUniqueUrl":"https://www.amazon.es/Nintendo-Animal-crossing-Switch/dp/B07HCVN3D1/ref=sr_1_1?__mk_es_ES=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Animal+Crossing%3A+New+Horizons&qid=1591004736&sr=8-1"
		},
		{
			"name":"Toshiba Canvio Basics",
			"type":"electronics computer parts hdd",
			"brand":"Toshiba",
			"price":60.99,
			"stock":200,
			"rating":4.6,
			"shippingPrice":0,
			"shippingTime":1,
			"description":"2TB Disco duro externo de 2.5 Acabado mate Puerto superspeed usb 3.0 Alimentado usb Toshiba Canvio Basics - Disco duro externo portátil USB 3.0 de 2.5 pulgadas (2 TB) color negro",
			"providerName":"Amazon",
			"providerUniqueUrl":"https://www.amazon.es/Toshiba-Canvio-Basics-Port%C3%A1til-Pulgadas/dp/B07994QL95/ref=sr_1_2?__mk_es_ES=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Toshiba%2BCanvio%2BBasics&qid=1591004759&sr=8-2&th=1"
		},
		{
			"name":"Virus!",
			"type":"card games",
			"brand":"Tranjis Games",
			"price":16,
			"stock":43,
			"rating":4.8,
			"shippingPrice":5.99,
			"shippingTime":7,
			"description":"Enfrentar la pandemia y competir para ser el primero en erradicar el virus mediante el aislamiento de un cuerpo sano. tico o no, todos los medios a su alcance son validos para lograr la victoria. Utiliza tu ingenio para boicotear los esfuerzos de sus rivales y ganar. Cada turno de Virus! ya sea que juegues una carta o descartar cualquier número de cartas, luego reponer la mano de tres cartas. Las tarjetas pueden ser: Uno de los cuatro granos (o el grano comodín) Uno de los cuatro virus (específico para cada grano o el virus comodín) Uno de los cuatro pastillas (específico para cada grano o la píldora comodín) Una carta de acción especial Se puede jugar solo una de cada granos en el rea del reproductor. Las píldoras y los virus se pueden reproducir en cualquier reproductor de granos, pero solo en el mismo grano de color. Una segunda píldora en cualquier grano que inmuniza contra la infección. Su objetivo es ser el primero en tener cuatro granos sanos en frente de usted.",
			"providerName":"Amazon",
			"providerUniqueUrl":"https://www.amazon.es/Tranjis-games-Virus-Cartas-1138753-62/dp/8460659666/ref=sr_1_1?__mk_es_ES=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Virus%21&qid=1591004845&sr=8-1"
		},
		{
			"name":"El Principito",
			"type":"books classics",
			"brand":"Salamandra",
			"price":5.65,
			"stock":113,
			"rating":4.7,
			"shippingPrice":2.99,
			"shippingTime":1,
			"description":"Antoine De Saint Exupery 96 páginas ISBN-10: 8498381495 El valor de la amistad, el heroísmo como meta y la responsabilidad como motor de la conducta moral encuentran su plasmación definitiva en el mundo que descubre El principito. ",
			"providerName":"Amazon",
			"providerUniqueUrl":"https://www.amazon.es/El-principito-Antoine-Saint-Exup%C3%A9ry-ebook/dp/B081PDBZWF/ref=sr_1_1?__mk_es_ES=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=El+Principito&qid=1591004909&sr=8-1"
		},
		{
			"name":"Entrada 18 JSY",
			"type":"football tshirt sports clothes",
			"brand":"Adidas",
			"price":10.99,
			"stock":80,
			"rating":4.5,
			"shippingPrice":2.99,
			"shippingTime":1,
			"description":"Jersey de Fútbol de Manga Corta, Hombre XS/S/M/L/XL Regular fit Climalite anti-humidity fabric 50% Poliéster, 50% Poliéster Reciclado Adidas logo on the front Tecnologías innovadoras y el mayor confort. Esta camiseta está confeccionada con el material funcional climalite que garantiza una gestión óptima de la humedad. La tela ligera y el accesorio deportivo son agradables suaves en la piel, un ajuste perfecto y la máxima libertad de movimiento. El logo de rendimiento en el cofre y el clásico 3-Stripes en las mangas representan la marca de calidad adidas. ",
			"providerName":"Amazon",
			"providerUniqueUrl":"https://www.amazon.es/adidas-Entrada-Camiseta-Equipaci%C3%B3n-Collegiate/dp/B0779C6P9T/ref=sr_1_2?__mk_es_ES=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Entrada+18+JSY&qid=1591004946&sr=8-2"
		},
		{
			"name":"Casio Reloj Vintage",
			"type":"digital watch",
			"brand":"Casio",
			"price":10.43,
			"stock":34,
			"rating":4.6,
			"shippingPrice":0,
			"shippingTime":2,
			"description":"Color: Negro Incluye cronómetro, alarma, indicador de hora de 12/24 horas y calendario automático Caja y correa de resina sintética, un material resistente y flexible La duración de la batería es de 7 años Resistente al agua y soporta pequeñas salpicaduras de agua",
			"providerName":"Amazon",
			"providerUniqueUrl":"https://www.amazon.es/Reloj-Casio-para-Hombre-F-91W-1XY/dp/B000J34HN4/ref=sr_1_1?__mk_es_ES=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Casio+Reloj+Vintage&qid=1591004990&sr=8-1"
		},
		{
			"name":"Resident Evil 2 - Edición Estándar",
			"type":"videogames",
			"brand":"Capcom",
			"price":59.99,
			"stock":1000,
			"rating":4.8,
			"shippingPrice":0,
			"shippingTime":9,
			"description":"Una escalofriante reinvención de un clásico del horror Apartado visual terroríficamente realista Enfréntate a hordas grotescas Contempla a tus personajes favoritos bajo una perspectiva nueva Ponte en la piel de ambos héroes",
			"providerName":"Amazon",
			"providerUniqueUrl":"https://www.amazon.es/Resident-Evil-2-Edici%C3%B3n-Est%C3%A1ndar/dp/B07DM6YN7G/ref=sr_1_1?__mk_es_ES=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Resident+Evil+2+-+Edici%C3%B3n+Est%C3%A1ndar&qid=1591005038&sr=8-1"
		},
		{
			"name":"Cubierta para boca desechable, 100 unidades",
			"type":"hygiene",
			"brand":"ISAMANNER",
			"price":37,
			"stock":112,
			"rating":2,
			"shippingPrice":0,
			"shippingTime":49,
			"description":"Máscara facial desechable: esta máscara es ideal para proteger a las personas del polvo, Talla única: esta máscara facial desechable es súper cómoda y fácil de llevar. Cómodo de llevar: esta máscara cuenta con un alambre de nariz ajustable para garantizar un ajuste perfecto. Ocasión adecuada: esta máscara facial es buena para que la gente se mantenga alejada del polvo.",
			"providerName":"Amazon",
			"providerUniqueUrl":"https://www.amazon.es/50-fundas-desechables-para-boca/dp/B0865WX5XT/ref=sr_1_1?__mk_es_ES=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Cubierta+para+boca+desechable+ISAMANNER&qid=1591005249&sr=8-1"
		},
		{
			"name":"Energizer E92 - Pack de 24 pilas alcalinas AAA",
			"type":"electronics",
			"brand":"Energizer",
			"price":9.95,
			"stock":238,
			"rating":4.7,
			"shippingPrice":0,
			"shippingTime":9,
			"description":"Energía duradera para los dispositivos que utiliza a diario Larga duración de la carga cuando la necesitas Mantiene la carga hasta 10 años Aparatos de uso cotidiano, despertadores, mandos a distancia, etc Contiene 24 pilas aaa",
			"providerName":"Amazon",
			"providerUniqueUrl":"https://www.amazon.es/Energizer-E300456500-Bater%C3%ADa-Alcalina-Color/dp/B0132XX152/ref=sr_1_1?__mk_es_ES=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=%27Energizer+E92+-+Pack+de+24+pilas+alcalinas+AAA&qid=1591005278&sr=8-1"
		}
	]
}
```

### Orchestrator component

Agent manager and recommender components are required to be running in order for the orchestrator to be demoed.

- REST endpoint: `http://localhost:60003/ennvas/orch/rest/search`
- Method: `POST`
- Content-type: `application/json`
- Body:

```json
{
	"phrase":"Apple iPhone 11 (64 GB) hey - - en Negro",
	"available":true,
	"freeShipping":true,
	"priceMin":300,
	"priceMax":400,
	"maxShippingTime":7,
	"minRating":3
}
```

### Front end component

Orchestrator, agent manager and recommender components are required to be running in order for the orchestrator to be demoed.

This demo's prodedure and result is very similar, if not equal, to submitting the form in the web UI.

- REST endpoint: `http://localhost:60005/ennvas/front/rest/search`
- Method: `POST`
- Content-type: `application/json`
- Body:

```json
{
	"phrase":"Apple iPhone 11 (64 GB) hey - - en Negro",
	"available":true,
	"freeShipping":true,
	"priceMin":300,
	"priceMax":400,
	"maxShippingTime":7,
	"minRating":3
}
```
