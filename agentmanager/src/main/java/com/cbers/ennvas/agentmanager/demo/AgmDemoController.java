package com.cbers.ennvas.agentmanager.demo;

import com.cbers.ennvas.agentmanager.persistence.entity.ProductEntity;
import com.cbers.ennvas.agentmanager.persistence.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ennvas/agm/demo")
public class AgmDemoController
{

    @Autowired
    private ProductRepository repository;

	@GetMapping(value="/generate")
	public void generate()
	{
        ProductEntity p;

		p = new ProductEntity(null, "Apple iPhone 11 (64 GB) - en Negro", "smartphone", "Apple", 793.99, 0, 20, 568, "Pantalla LCD Liquid Retina HD de 6,1 pulgadas, Resistencia al agua y al polvo (2 metros hasta 30 minutos, IP68), Sistema de cámara dual de 12 Mpx con gran angular y ultra gran angular; modo Noche, modo Retrato y vídeo 4K hasta 60 f/s, Cámara frontal TrueDepth de 12 Mpx con modo Retrato, vídeo 4K y ,grabación a cámara lenta, Face ID para autenticarse de forma segura y usar ApplePay, Chip A13 Bionic con Neural Engine de 3.ª generación, Admite la carga rápida Carga inalámbrica", 4.7);
        repository.save(p);

        p = new ProductEntity(null, "Samsung Galaxy 10+", "smartphone", "Samsung", 1009, 0, 15, 678, "Smartphone de 6.4 QHD+ Curved Dynamic AMOLED, 16 MP, Exynos 9820, Wireless & Fast & Reverse Charging, 128 GB, Prisma Negro (Prism Black) [Clase de eficiencia energética A]", 4.6);
        repository.save(p);

        p = new ProductEntity(null, "Frozen 2", "DVD, movies, children", "Disney", 18.9, 0, 1, 67, "Formato: Edición estandar, Audio: Inglés, Español, Subtítulos: Español, Región: Región 2, Calificación española (ICAA): Apta para todos los públicos", 0);
        repository.save(p);

        p = new ProductEntity(null, "Animal Crossing: New Horizons", "videogame", "Nintendo", 59.9, 3.99, 3, 1000, "Personaliza tu casa y a tu personaje, decora el paisaje (¡hasta con muebles, si quieres!) y ve creando poco a poco tu propia isla paradisíaca. ", 5);
        repository.save(p);

        p = new ProductEntity(null, "Toshiba Canvio Basics", "electronics computer parts hdd", "Toshiba", 60.99, 0, 1, 200, "2TB Disco duro externo de 2.5 Acabado mate Puerto superspeed usb 3.0 Alimentado usb Toshiba Canvio Basics - Disco duro externo portátil USB 3.0 de 2.5 pulgadas (2 TB) color negro", 4.6);
        repository.save(p);

        p = new ProductEntity(null, "Virus!", "card games", "Tranjis Games", 16, 5.99, 7, 43, "Enfrentar la pandemia y competir para ser el primero en erradicar el virus mediante el aislamiento de un cuerpo sano. tico o no, todos los medios a su alcance son validos para lograr la victoria. Utiliza tu ingenio para boicotear los esfuerzos de sus rivales y ganar. Cada turno de Virus! ya sea que juegues una carta o descartar cualquier número de cartas, luego reponer la mano de tres cartas. Las tarjetas pueden ser: Uno de los cuatro granos (o el grano comodín) Uno de los cuatro virus (específico para cada grano o el virus comodín) Uno de los cuatro pastillas (específico para cada grano o la píldora comodín) Una carta de acción especial Se puede jugar solo una de cada granos en el rea del reproductor. Las píldoras y los virus se pueden reproducir en cualquier reproductor de granos, pero solo en el mismo grano de color. Una segunda píldora en cualquier grano que inmuniza contra la infección. Su objetivo es ser el primero en tener cuatro granos sanos en frente de usted.", 4.8);
        repository.save(p);

        p = new ProductEntity(null, "El Principito", "books classics", "Salamandra", 5.65, 2.99, 1, 113, "Antoine De Saint Exupery 96 páginas ISBN-10: 8498381495 El valor de la amistad, el heroísmo como meta y la responsabilidad como motor de la conducta moral encuentran su plasmación definitiva en el mundo que descubre El principito. ", 4.7);
        repository.save(p);

        p = new ProductEntity(null, "Entrada 18 JSY", "football tshirt sports clothes", "Adidas", 10.99, 2.99, 1, 80, "Jersey de Fútbol de Manga Corta, Hombre XS/S/M/L/XL Regular fit Climalite anti-humidity fabric 50% Poliéster, 50% Poliéster Reciclado Adidas logo on the front Tecnologías innovadoras y el mayor confort. Esta camiseta está confeccionada con el material funcional climalite que garantiza una gestión óptima de la humedad. La tela ligera y el accesorio deportivo son agradables suaves en la piel, un ajuste perfecto y la máxima libertad de movimiento. El logo de rendimiento en el cofre y el clásico 3-Stripes en las mangas representan la marca de calidad adidas. ", 4.5);
        repository.save(p);

        p = new ProductEntity(null, "Casio Reloj Vintage", "digital watch", "Casio", 10.43, 0, 2, 34, "Color: Negro Incluye cronómetro, alarma, indicador de hora de 12/24 horas y calendario automático Caja y correa de resina sintética, un material resistente y flexible La duración de la batería es de 7 años Resistente al agua y soporta pequeñas salpicaduras de agua", 4.6);
        repository.save(p);

        p = new ProductEntity(null, "Resident Evil 2 - Edición Estándar", "videogames", "Capcom", 59.99, 0, 9, 1000, "Una escalofriante reinvención de un clásico del horror Apartado visual terroríficamente realista Enfréntate a hordas grotescas Contempla a tus personajes favoritos bajo una perspectiva nueva Ponte en la piel de ambos héroes", 4.8);
        repository.save(p);

        p = new ProductEntity(null, "Cubierta para boca desechable, 100 unidades", "hygiene", "ISAMANNER", 37, 0, 49, 112, "Máscara facial desechable: esta máscara es ideal para proteger a las personas del polvo, Talla única: esta máscara facial desechable es súper cómoda y fácil de llevar. Cómodo de llevar: esta máscara cuenta con un alambre de nariz ajustable para garantizar un ajuste perfecto. Ocasión adecuada: esta máscara facial es buena para que la gente se mantenga alejada del polvo.", 2);
        repository.save(p);

        p = new ProductEntity(null, "Energizer E92 - Pack de 24 pilas alcalinas AAA", "electronics", "Energizer", 9.95, 0, 9, 238, "Energía duradera para los dispositivos que utiliza a diario Larga duración de la carga cuando la necesitas Mantiene la carga hasta 10 años Aparatos de uso cotidiano, despertadores, mandos a distancia, etc Contiene 24 pilas aaa", 4.7);
        repository.save(p);

        p = new ProductEntity(null, "DJI Phantom 4 - Drone cuadricoptero - color blanco", "drones,electronics,photography", "DJI", 598.07, 0, 3, 1, "Hasta 28 minutos de tiempo de vuelo y hasta 5 km de rango de control Estabilizador integrado para mayor estabilidad de cámara y vídeo más fluido Rastrea objetivos móviles automáticamente usando ActiveTrack Esquiva obstáculos automáticamente y tiene una velocidad máxima de 72 km/h Distancia de transmisión máx. para control remoto: Según normas FCC: 7 km (4.3 mi); Según normas CE: 3.5 km (2.2 mi); (sin obstáculos, libre de interferencias)", 4.1);
        repository.save(p);
        
        p = new ProductEntity(null, "Guantes de latex blancos 100 Uds", "hygiene", "Wonduu", 17.9, 0, 49, 280, "en 4 cajas de 25 unidades Talla unica S-M-L Deshechable", 4.1);
        repository.save(p);

        p = new ProductEntity(null, "1917 Blu-ray", "Blu-ray,movies,action", "Universal pictures", 19.99, 0, 3, 432, "Durante la Primera Guerra Mundial, dos jóvenes soldados británicos reciben una orden, aparentemente, imposible de ejecutar: en una carrera contra el reloj, deben infiltrarse en territorio enemigo para entregar un mensaje que podría salvar a miles de compañeros.", 4.4);
        repository.save(p);
        
        p = new ProductEntity(null, "Báscula Digital de Cocina 5kg / 11 lbs", "electronics,food,cooking", "ACCUWEIGHT", 18.99, 0, 6, 37, "【PRECISO】: ACCUWEIGHT bascula multifunción para alimentos equipada con sensores de alta precisión y tecnología de medición de líquidos para proporcionarle un peso preciso en todo momento, desde 1 g hasta 5 kg. Perfecto para el volumen de medición de líquidos, cocinar en casa, hornear.【MULTIFUNCIONAL】: la balanza eléctrica indica la batería baja y la sobrecarga; función Cero/Tara (reducción a cero para el peso neto); función de apagado automático; 2 pilas AAA (incluidas).【VERSATILIDAD ÚTIL】: la báscula digital ACCUWEIGHT es perfecta para que tus hijos aprendan sobre pesos y medidas y sobre cómo seguir las instrucciones; fantástico para el control de las porciones y para perder peso.【DISEÑO PORTÁTIL】: la plataforma de vidrio resistente a las manchas se limpia fácilmente. La báscula es compacta, así que la puedes guardar sin problemas cuando no esté en uso. Perfecta para cocinar en casa y para crear porciones de la comida.【EXTENSIÓN DE GARANTÍA DE 2 + 2 AÑOS】: REGISTRE su ACCUWEIGHT producto después de la compra e INCREMENTE SU COBERTURA DE GARANTÍA DE 2 AÑOS A 4 AÑOS.", 4.6);
        repository.save(p);
        
        p = new ProductEntity(null, "Juego de brochas planas 3 unidades, 30, 50 y 70 mm", "DIY,painting,home", "Color Expert", 9.9, 12.9, 3, 0, "Color Expert 82650350 Mando de plastico Excelente relación calidad-precio. Para los exigentes bricolaje Barniz plana de juego de pinceles", 4.4);
        repository.save(p);
        
        p = new ProductEntity(null, "Alpen 4392140 - Deslizador de Nieve", "sports,entertainment", "Alpen", 42.15, 0, 3, 52, "Color rojo Unidad Alpine rojo trineo dirigible Volante con barra de metal 93 x 39 x 25 cm Seguridad a través del diseño estable corredor Pullstring con mango de plástico Desde HDPE de alta calidad Elástico a bajas temperaturas y estable", 3.8);
        repository.save(p);
        
        p = new ProductEntity(null, "Sartén para Mini Crepes 800 W negro", "cooking", "Bestron", 32.91, 0, 3, 76, "Para desayunos, meriendas o celebraciones: decorativa sartén para preparar deliciosos mini crepes holandeses y pequeños panqueques Elemento de calentamiento rápido para alcanzar la temperatura ideal en los 14 moldes – recetas incluidas Revestimiento antiadherente para el fácil girado/extracción de los alimentos y una fácil limpieza, práctico enrollado del cable en la base Uso seguro gracias a las patas antideslizantes, carcasa termoaislante e interruptor de encendido/apagado con piloto indicador Contenido: 1 bestron sartén para mini crepes, longitud del cable: 71-73cm, potencía: 800 w, dimensiones: 26x26x6 cm, peso: 0,94 kg, material: plástico/metal, color: negro, apfm700z", 4.4);
        repository.save(p);
        
        p = new ProductEntity(null, "Casio Calculadora FX 85 GT Plus rosa", "electronics,maths,school", "Casio", 46.99, 0, 10, 24, "La calculadora Casio FX-85-GT Plus es una calculadora científica técnica. Casio FX-85 GT Plus - Calculadora (260 funciones) FX-85 ahora está disponible con los integrantes aleatorios (números enteros). Incluye instrucciones de uso (idioma español no garantizado). e instrucciones (en inglés). Para Casio FX-85 GT Plus. Extensión de la garantía hasta 60 meses", 4.8);
        repository.save(p);
        
        p = new ProductEntity(null, "LEGO Architecture - Fontana de Trevi (21020)", "games,children", "Lego Architecture", 235.98, 0, 8, 2, "Tiene 346 piezas y un folleto explicativo con la historia de la famosa torre que lo alberga Forma parte de una colección de edificios emblemáticos dentro de la categoría Architecture de Lego Adecuado para niños a partir de 12 anos Dimensiones del producto de 19.6 x 9.6 x 9.6 cm", 4.4);
        repository.save(p);

        p = new ProductEntity(null, "Red Recogehojas para Superficie de Piscina", "gardening", "Gre", 14.2, 0, 9, 15, "Gre 40031 Red recogehojas plano que facilita la limpieza de la superficie de la piscina, con mango telescópico incorporado Recoge las hojas y otros elementos de gran tamaño de la superficie Sus dimensiones y formas maximizan la capacidad de recogida, reduciendo tiempo necesario y esfuerzo requerido Con un diseño práctico y fácil de manejar Incluye un mango telescópico con conexión clip", 4.2);
        repository.save(p);
        
        p = new ProductEntity(null, "Quitaesmalte para Uñas de Gel con Acetona 250ml", "hygiene,beauty", "MYLEE", 12, 1.2, 7, 1, "Limpiador Profesional de Uñas UV LED para Manicuras y Pedicuras. Gel Nail Polish Remover QUITAESMALTE PARA UÑAS DE GEL – Elimina el esmalte de gel en para manicuras y pedicuras. ACETONA 100% PURA – Utilizada por técnicos y profesionales de las uñas. Sin aditivos desagradables, parabenos, sulfatos, propilenglicol o aceite mineral. ELIMINA TODO TIPO DE ESMALTE DE UÑAS – Quita el esmalte de uñas, el esmalte de gel, el barniz, la purpurina, las pegatinas, las uñas postizas, los acrílicos, la fibra de vidrio e incluso el pegamento para uñas. RÁPIDO Y FÁCIL – Se disuelve rápidamente sin dañar la uña natural. CALIDAD DE SALON PROFESIONAL – Mylee ofrece a salones, profesionales y entusiastas del artes de las uñas productos líderes en manicura y pedicura. Desde productos preparación y acabado elaborados con ingredientes líderes en el mercado hasta lo último en equipos de limpieza y mucho más. Mylee cubre todos y cada uno de los tratamientos que intervienen en el cuidado de las uñas con productos excelentes que te permiten obtener los mejores resultados.", 4);
        repository.save(p);
        
        p = new ProductEntity(null, "Guirnalda mágica de luces led navideñas", "christmas decoration,home", "WSG", 15.15, 0, 14, 4, "funciona con pilas, 2 m, 3 m, 5 m y 10 metros., Rosa, 5 Metros Cable de luces led festivo en 6 colores diferentes para decorar tu hogar, lugar de trabajo o fiesta este año.Cable de luces led, multiusos y muy adaptable. Utilízalo como parte de tu decoración de Navidad tradicional, en árboles y coronas, o en botes de cristal, portavelas o jarrones.Esta guirnalda de luces de hadas también puede envolver objetos o puede colocarse alrededor de puertas, escaleras, lámparas, televisores, monitores, plantas, hogares y mucho, mucho más. Fácil de montar, desmontar y doblar alrededor de cualquier objeto, incluso puede utilizarse en el exterior o interior de su vehículo. Colores, cálido (ámbar), color blanco, multicolores, azul, púrpura y rosa.Potencia: 3 pilas AA, interruptor On/Off botón.No incluye las baterías.Luces led, brillantes y coloridas, 10 luces led por metro.Ejemplo: compra 5 metros de luces y obtienes 50 luces separadas cada 10 cm. Alambre de cobre fuerte, puede ser doblado y mantiene la posición.También se utiliza para celebraciones, bodas, festivales de luces, cumpleaños, así como eventos de presentación, manualidades y gestión de eventos.", 4.3);
        repository.save(p);
        
        p = new ProductEntity(null, "Los Sims 4 - Edición Estándar", "electronics,videogames", "Electronic Arts", 19.99, 0, 1, 37, "Género: simulación Clasificación PEGI: más de 12 años Compatible con Windows XP, Vista, 7, 8, 8.1 Incluye sólo el juego Disponible para PC Mac XBOX One y PS4 Información acerca de los requisitos mínimos de funcionamiento en la descripción del producto Los Sims 4 es el esperadísimo juego de simulación social que permite jugar a la vida como nunca antes. Crea y controla nuevos Sims con mente, cuerpo y corazón propios. Constrúyeles casas únicas. Dirige y explora las historias de tus Sims, y disfruta con los emocionantes resultados. Las nuevas herramientas creativas táctiles de Crear un Sim y un modo Construir por habitaciones ofrecen formas intuitivas y divertidas de crear contenido atractivo. Muéstrale al mundo tus creaciones favoritas con las novedosas maneras de compartir y compra contenido de la comunidad para inspirarte.", 4.3);
        repository.save(p);
       
        p = new ProductEntity(null, "Rolling Ice Cream Grill", "cooking,children,desserts,home", "Mikamax", 29.95, 0, 5, 246, "HELADO RODADO: El Ice Cream Rolling Grill te permitirá hacer tus propios Rollos de helado en casa. La máquina de helados viene con algunas recetas de moldes de hielo, 2 espátulas, 1 pajita, 1 cuchara y 6 moldes para crear sus propios rollos de helado. CÓMO HACER HELADO- ROLLOS DE HIELO: Para hacer su propio rollo de hielo, debe colocar la heladera en el congelador por un tiempo y sacarla cuando esté suficientemente fría. Luego, coloque la Mezcla de helado, que ha preparado pacer los rollos de helado. RECETAS DE HELADO INCLUIDAS: ¡El plato de helado viene con algunas recetas básicas para comenzar! Siga las instrucciones de acuerdo con el libro de recetas y una vez que la mezcla se haya solidificado, puede enrollar su helado enrollado y servirlo en un buen tazón o en un plato. ROLL CON LOS NIÑOS: Regalo ideal de helado o actividad para hacer en una tarde con niños o familiares. ¡Asegúrese de haber puesto el plato frío de helado un día antes en el congelador para que pueda ponerse a trabajar de inmediato! DIMENSIONES DEL PRODUCTO: Las dimensiones de la máquina de helados caseros son: 30 x 6,5 cm. rosa", 3.2);
        repository.save(p);
        
        p = new ProductEntity(null, "Marc by Marc Jacobs Baker - Reloj", "fashion", "Marc by Marc Jacobs", 170, 12, 16, 4, "Baker Collection Movimiento de cuarzo suizo Resistente al agua 50 metros/165 pies /5 atm 36 mm diámetro de la caja Cristal mineral Paga en 4 cuotas", 3.6);
        repository.save(p);
        
        p = new ProductEntity(null, "Razer Kraken - Auriculares de gaming con microfono", "gaming,music,electronics", "Razer", 78.99, 0, 6, 3, "Controladores optimizados de 50 mm: ofrece un amplio paisaje sonoro, desde las sutiles pisadas que se acercan a ti desde atrás a las explosiones de batalla que acaban contigo Almohadillas de gel refrigerantes: reducen el calor, mientras que la combinación de tejido suave y piel sintética proporciona comodidad y aislamiento acústico para que puedas disfrutar de jugar durante horas Micrófono retráctil unidireccional: Asegura que todas las instrucciones se reciban con total claridad Estructura de aluminio de Bauxita con un acolchado más grueso: peso ligero, duradero y flexible; el acolchado de la diadema alivia la presión sobre la cabeza, para que los auriculares resulten aún más ligeros Compatibilidad multiplataforma: Compite en tu PC, PS4, Xbox One, Switch y dispositivos móviles con el conector combinado de 3,5 mm minijack. verde ( Windows, Mac, IOS, Android )", 4.4);
        repository.save(p);
        
        p = new ProductEntity(null, "Basket Papelera dseño divertido Canasta Baloncesto", "home,children", "Balvi", 17.75, 0, 8, 48, "Con diseño divertido de canasta de baloncesto. Color blanco. Fabricada en plástico muy resistente. Medidas: 30,7x32x32 cm Material: polipropileno", 4.6);
        repository.save(p);
        
        p = new ProductEntity(null, "Logitech G502 HERO", "mouse, electronics, gaming", "Logitech", 92.99, 0, 15, 50, "Tu ratón para gaming de alto rendimiento favorito ofrece más funciones y precisión que nunca; personaliza la iluminación rgb para que coincida con tu estilo y entorno o sincronízala con otros productos logitech g; el ratón para gaming de alto rendimiento g502 incluye nuestro sensor óptico hero 16k de próxima generación para máxima precisión y seguimiento superior; sea cual sea tu estilo de gaming, puedes ajustar g502 hero fácilmente según tus requisitos de uso, con perfiles personalizados para tus juegos, valores de sensibilidad entre 200 y 16.000 dpi y un sistema de cinco pesas de 3,6 g que puedes combinar o intercambiar como quieras para conseguir la sensación y el equilibrio perfectos.", 4.7);
        repository.save(p);
        
        p = new ProductEntity(null, "New World", "videogame, electronics, gaming, windows 10", "Amazon Games", 39.99, 0, 0, 400, "New World es un MMO de mundo abierto donde los jugadores tendrán que luchar contra la naturaleza encantada de Aetérnum, una misteriosa isla descubierta durante el ocaso de la Era de la Exploración. Derrota a las brutales legiones de los corruptos y prepárate para enfrentarte a otros jugadores rivales en este mundo lleno de peligros y oportunidades. ¿Qué harás para sobrevivir en un lugar decidido a destruirte? Embárcate en una aventura en solitario para forjar tu propia historia heroica o alíate con otros, levanta defensas y prepárate para luchar.", 0);
        repository.save(p);

        p = new ProductEntity(null, "Tartas, Bizcochos Y Pasteles Caseros", "books, cooking", "Equipo Susaeta", 5.83, 1.99, 2, 1000, "Hemos elegido las recetas más deliciosas e innovadoras, creadas por chefs y profesionales con experiencia. Además, las hemos probado tres veces y elaborado un completo glosario para resolver todas sus dudas. ¡Que lo disfrute!", 4.5);
        repository.save(p);

        p = new ProductEntity(null, "1917", "movies, Blu-ray", "eONE Entertainment", 19.99, 0, 2, 20, "En el apogeo de la Primera Guerra Mundial, a dos jóvenes soldados británicos, Schofield (George MacKay) y Blake (Dean-Charles Chapman), se les asigna una misión prácticamente imposible: cruzar en una carrera a contrarreloj el territorio enemigo para entregar un mensaje y evitar así caer en una trampa enemiga que podría acabar con la vida de cientos de soldados, entre ellos, el hermano de Blake. ", 4.4);
        repository.save(p);

        p = new ProductEntity(null, "Cama para mascotas  - Pequeña ", "pets, furniture", "Amazon Basics", 24.99, 3.99, 5, 20, "Dale a tu peludo amigo un lugar suave en el que apoyar la cabeza con la cama para mascotas de espuma de AmazonBasics. Este cojín afelpado incorpora un relleno de espuma densa que le proporciona al miembro de tu familia la firmeza y la comodidad que se merece. Ideal para colocarla en una caseta cuando sales o simplemente en su rincón soleado favorito, la cama para mascotas es una opción duradera de calidad que agradecerá.", 4.5);
        repository.save(p);
        
        p = new ProductEntity(null, "Proclean 3010 - Microondas", "microwaves, cooking", "Cecotec", 46.9, 4.99, 20, 70, "El microondas proclean 3010 será indispensable en tu cocina; podrás preparar todo lo que imagines con sus 20 litros de capacidad; su puerta fullwhite le dará un toque especial a tu cocina; con la tecnología de última generación 3dwave envuelve los alimentos por completo a través de un sistema de ondas muy eficiente que no deja ningún punto frío; cuenta con una potencía de 700 w, distribuidos de forma idónea en 6 niveles que optimizan todas las características del microondas para conseguir un mejor resultado en todo tipo de alimentos; el revestimiento de nueva generación ready2clean fácil ita que tu microondas quede impecable en tan solo unos segundos; incorpora un avisador acústico que te comunicará el final de la cocción; y con su fácil usabilidad podrás utilizarlo de la forma más cómoda. ", 4.2);
        repository.save(p);
        
        p = new ProductEntity(null, "First Bike", "kids, toys", "Chicco", 29.99, 0, 30, 12, "Las bicicleta sin pedales que le ayudan a desarrollar su equilibrio sobre 2 ruedas, facilitando el paso a una bicicleta de adulto con pedales; su estructura es de metal ultraligero; el manillar y sillín son regulables en altura para ajustarse a la complexión del niño; su sillín posee efecto antideslizante, y su ruedas de 10” son anti-pinchazos; edad de uso: desde los 2 a los 5 años (hasta una altura mínima de 85 cm, y un peso máximo de 25 kg.)", 4.7);
        repository.save(p);
        
        p = new ProductEntity(null, "Lee Sin Figura de Vinilo", "figurines, videogames", "Funko", 24, 13, 5, 4, "Este es Lee Sin POP. Personaje se une a la colección de League of Legends. Lee Sin añade une a la colección de POP cada vez mayor. Cada personaje mide alrededor de 9 cm de altura y viene embalado en una caja con ventanas ilustrada. ", 4.4);
        repository.save(p);
        
        p = new ProductEntity(null, "Pokémon Espada", "electronics, videogames", "Nintendo", 59.99, 0, 0, 985, "Una nueva generación de Pokemon está llegando al sistema Nintendo Switch. ¡Conviértete en un Entrenador de Pokémon y embarca en un nuevo viaje en la nueva región de Galar! Elige entre uno de los tres nuevos Pokémon asociados: Grookey, Scorbunny o Sobble. En esta nueva aventura, encontrarás Pokémon nuevos y familiares a medida que atrapas, combates e intercambias Pokémon mientras exploras nuevas áreas y descubres una historia completamente nueva. Prepárate para la próxima aventura de Pokémon en los juegos Pokémon Espada y Pokémon Escudo. ", 5);
		repository.save(p);
		
        p = new ProductEntity(null, "Soporte Bicicletas Pared", "biking, sports", "Charles Daily", 17.99, 0, 6, 27, "El colgador de pared para bicis Charles Daily es el nuevo accesorio favorito para tu querida bicicleta. Especial para guardar bicicletas de forma segura, protegiéndola del viento y las inclemencias del tiempo, protege la pintura delicada de los arañazos e incluso ahorra espacio cuando lo pliegas. El soporte de bici para pared crea orden en el sótano y el garaje, o convierte tu bicicleta en el centro de atención en la sala de estar o el pasillo. Nuestros ganchos para colgar bicicletas vienen con unos anclajes de montaje especialmente robustos que sostienen incluso la mayoría de las bicicletas eléctricas de forma segura en la pared.", 4.2);
		repository.save(p);
		
        p = new ProductEntity(null, "Skateboard Kicker 31'", "sakting, sports", "Schildkröt ", 29.99, 5.99, 3, 0, "El kicker 31' de la nueva línea de skateboards de schildkröt es el modelo perfecto para principiantes. Con una plataforma de 31 pulgadas (79 x 20 cm) hecha de madera de arce de 9 camadas y una tabla con una cubierta de doble patada con una ligera curvatura hacia adentro (cóncava). La cinta de agarre asegura un soporte seguro y antideslizante mientras conduce. El skateboard está completamente ensamblado con ejes de aluminio pulido y ruedas(dureza 85a, tamaño: 54 x 36 mm). ", 4.3);
		repository.save(p);
		
        p = new ProductEntity(null, "Playstation 4 Pro (PS4)", "videogames, electronics", "Sony", 409.99, 0, 2, 554, "El producto representa una consola de videojuegos Play Station con un mando DualShock 4. Cuenta con el procesador x86-64 AMD “Jaguar” de 8 núcleos y posteriormente realizó modificaciones para conseguir un rendimiento de primera. Además, la compacta carcasa de líneas marcadas, PS4 tiene un aspecto refinado con sus líneas angulares hasta sus paneles de contraste en acabado brillante y mate. ", 4.4);
        repository.save(p);
        
        p = new ProductEntity(null, "RTX 2080 Ti GAMING X TRIO ", "electronics, pc", "MSI", 1339.91, 4.99, 1, 65, "El MSI GeForce RTX 2080 Ti GAMING TRIO presenta la última versión del galardonado diseño térmico de MSI: TRI-FROZR. Utiliza tres nuevos ventiladores TORX 3.0, que es la tecnología de ventilador patentada de MSI que combina dos tipos diferentes de álabes de ventilador para optimizar el flujo de aire y minimizar el ruido. ", 4.4);
        repository.save(p);

        p = new ProductEntity(null, "NF-A9x14 PWM, Ventilador ", "electronics, pc", "Noctua", 17.9, 1.99, 5, 3, "Dotado del marco AAO de Noctua y de medidas avanzadas de diseño aerodinámico, como canales de aceleración de flujo (Flow Acceleration Channels), el NF-A9x14 es un ventilador silencioso, de primera calidad y altamente optimizado, con un tamaño de 92 x 14 mm. Debido a su grosor de solo 14 mm, el NF-A9x14 es el compañero perfecto para disipadores de CPU de perfil bajo y otras aplicaciones que requieren ventiladores más delgados. El diseño personalizado del PWM IC de Noctua para obtener un control de la velocidad completamente automático, así como los rodamientos SSO2, referencia en su clase, garantizan una fluidez de funcionamiento espectacular y excelente estabilidad a largo plazo. Dotado de cables modulares y adaptador para reducción del ruido, el NF-A9x14 es una elección de primera línea para las demandas más elevadas. ", 4.8);
        repository.save(p);
        
        p = new ProductEntity(null, "Suavizante para la ropa profesional", "cleaning", "Flor", 17.38, 0.99, 1, 51, "Flor Nenuco Suavizante formato Profesional formato regular. El suavizante para lavadora Flor Nenuco proporciona la fragancia de Nenuco a la ropa en cada lavado. Además de suavizar y tratar bien la ropa, deja un olor a la fresca fragancia de Nenuco hasta 12 veces más. ", 4);
        repository.save(p);
        
        p = new ProductEntity(null, "Original Papel Higiénico - 96 Rollos", "cleaning, toilet paper", "Scottex", 22.94, 0, 2, 8765, "Scottex Original, con dos suaves capas, se renueva para ofrecer la mejor sensación de CUIDADO COMPLETO", 4.1);
        repository.save(p);
        
        p = new ProductEntity(null, "CrossAction Cabezal de Recambio", "cleaning, self care", "Oral-B", 24.9, 1.99, 3, 0, "El cabezal de cepillo de dientes Oral-B CrossAction tiene una forma redondeada inspirada en las herramientas de limpieza profesionales para limpiar diente por diente. Los filamentos CrissCross dispuestos en un ángulo de 16 grados limpian eficazmente a lo largo de la línea de las encías y penetran a mayor profundidad entre los dientes, para deshacer y eliminar hasta un 100% de placa y ofrecer una limpieza intensa comparado con un cepillo manual normal.", 4.7);
        repository.save(p);
       
        p = new ProductEntity(null, "AirPods", "music, electronics", "Apple", 138.98, 0, 1, 952, "Los AirPods se conectan fácilmente y te siguen el ritmo todo el día", 4.7);
        repository.save(p);
        
        p = new ProductEntity(null, "Echo Dot", "electronics, help, speakers", "Amazon", 34.99, 0, 1, 98, "El Echo Dot es un altavoz inteligente que se controla con la voz y que usa el Alexa Voice Service. Gracias a su diseño, es ideal para cualquier habitación. Simplemente pídele música, las noticias o información. También puedes llamar a cualquiera que tenga un dispositivo Echo, la app Alexa o Skype, así como controlar dispositivos de Hogar digital con la voz.", 4.6);
        repository.save(p);
        
        p = new ProductEntity(null, "Zelda: Breath of the Wild", "videogames, electronics", "Nintendo", 49.99, 0, 0, 94, "Prepárate para vivir la mayor aventura hasta el momento de la famosa serie The Legend of Zelda, una odisea al aire libre que abre nuevos horizontes sin perder ni un ápice de la esencia del juego original. Explora un mundo de dimensiones sin precedentes y descubre más de 100 santuarios donde deberás poner a prueba tu ingenio, aparte de una enorme variedad de armas, prendas y demás equipo. Nadie querrá dejar de jugar, ni falta que hace, porque con Nintendo Switch podrás vivir esta aventura donde quieras y cuando quieras.", 4.6);
        repository.save(p);
	}
}