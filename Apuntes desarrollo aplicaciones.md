# Apuntes desarrollo aplicaciones

# TEORIA

- # Arquitectura de una app Android

    ### 1. Vistas:
    Son los elementos con los que se disena la interfaz de usuario, cuadrados, botones... Todos objetos heredan de la clase View de Java
    - XML Android:

        - Los ficheros XML son ampliamente extendidos en Kotlin. El fichero por defecto es `activity_main.xml`.
        - Contiene los elementos de la interfaz de usuario, los atributos de diseno, los layouts, string, colores, dimensiones y demas elementos de UI.
    ### 2. Layout:
    Conjunto de vistas colocadas o agrupadas, dispone de diferentes tipos de layouts para organizar las vistas de forma lineal.
    ### 3. Activity:
    Un activity son las pantallas visuales que forman parte de la interfaz de la app. Cada activity es el componente principal de una app de Android. Por cada actividad hay que crear una clase heredada de Activity de Java
    - Estados de una actividad:
        - Created: Nada mas iniciarse se ejecuta el `onCreate`, es obligatorio que sea sobreescrito. 
        - Started: A continuacion del created pasariamos al `onStart`, es cuando la actividad empieza a ser visible en pantalla.
        - Resumed: Se ejecuta `onResume` al salir del started, en este punto la actividad puede ser pausada o parada.
        - Paused: Llegamos aqui cuando se quita el foco, pj una ventana emergente. Este proceso se llama `onPause`. Desde aqui podriamos volver al estado resumed con `onResume` o podriamos pararla con `onStoped`.
        - Stoped: Aqui llegamos cuando hemos parado la activity, se llega aqui cuando se inicia otra avtividad y esta queda en un segundo plano. Una actividad stoped puede volver a started mediante `onRestart` y `onStart`
        - Destroyed: Aqui se llega cuando se finaliza la app, se lelga mediante `onDestroy`, se llega desde paused.

        - ![Alt text](image.png) 

    ### 4. Intencion:
    Es un mensaje que se envia de un componente a otro, entre una app y otra, se suelen usar para ejecutar un servicio o una actividad.
    - Explicitos: Indican que compionente se debe iniciar.
    - Implicitos: No se especifica el nombre, lo que hace es indicar la operacion.
    ### 5. Servicios
    Es un componente que permite realizar operaciones de larga duracion en background. Algunos ejemplos son:
    - Sincronizar app en la nube 
    - Reproducir musica
    - Monitorear info
    Hay dos tipos de servicios
    - Started service: comienza llamando al metodo `startService`.
    - Bound service: comienza llamando al metodo `bindService`.

- # Arquitectura de Android Studio

    Esta compuesto por 3 carpetas principales

    ### Manifest
    Dentro de esta carpeta se encuentra el archivo `AndroidManifest.xml`, aqui se indican los componentes que formam la App, la API minima y las librerias que necesitan.
    ### Java
    Se aloja el codigo Java de la app, se accedera para modificar y crear nuevos archivos de codigo fuente Java.
    ### Res
    Aqui estan la mayoria de archivos de la App, imagenes, traducciones, animaciones, estilos ...
    - Carpeta `Drawable`: Contiene los archivos graficos en formato .png .gif .jpg y archivos xml.
    - Carpeta `Layout`: Contiene los xml que definen la disposicion de los elementos.
    - Carpeta `Menu`: Contiene los ficheros xml que contienen los menus de la aplicacion.
    - Carpeta `Values`: Contiene los ficheros xml que definen valores simples como enteros, colores y constantes de texto. Aqui se encuentra el fichero `string.xml`.
    - Carpeta `MiniMap`: Almacena los iconos de la aplicacion.

- # Interfaces de usuario (UI)

    ### 1. Layout
    Actua como contenedor de view. Se puede organizar en ficheros xml o con codigo Java. La mejor opcion es xml. 
    Los tipos de layout son:
    - LinearLayout: Organiza los elementos en una fila o en una columna.
    - TableLayout: Organiza los elementos en filas y columnas. Este tipo de Layout necesita el tipo TableRow, para crear filas dentro de esa tabla.
    - RelativeLayout: Muestra los elementos en posiciones relativas con respecto a otro elemento o un Layout padre.
    - AbsoluteLayout: Posiciona el elemento usando coordenadas x , y.
    - FrameLayout: Permite mostrar varios elementos en la misma región de la pantalla, de modo que cada uno de ellos oculta al que está por debajo.
    - ConstraintLayout: Esta Layout se añadió en Android Studio 2.2 y versiones posteriores, permite una edición visual desde el editor sin tener que modificar manualmente el XML.
    ### 2. View
    Son usados para dibujar contenido, algunos elementos son 
    - Widgets
    - Text
    - Containers

- # Contexto grafico
    Android permite dibujar imagenes en formato .jpg y .png. Se pueden agregar de diferentes maneras:
    - Canvas, es una superficie que se pinta.
    - View, forma sencilla de generar un grafico, pero poco flexible.
    - SurfaceView, esta recomendado si la informacion va a necesitar muchas actualizaciones. Se necesitara un thread

    ### Clases y metodos

    - Metodo onPaint
    - Metodo para dibujar formas geometricas, perteneneciente a la clase canvas, drawLine, drawpoint, drawRect y drawCircle
    - Metodo de la clase path, camino a seguir entre linea y curvas.
    - Metodo drawable
    - Metodo y clase BitmapDrawable

- # Threads
    Hilos de ejecucion

    ### Ciclos de vida
    - New
    - Runnable, una vez ejecutado el `start`
    - Not Runnable
    - Dead
    ### Asyntask
    Es una clase al igual que Handler, para mostrar los cambios generados en el thread, creada para reducir y simplificar el desarrollo de threads.

- # BBDD SQLite
    - Tiene las siguientes ventajas:
        - No necesita configuracion
        - Tiene un conjunto de librerias escritas en C, no funciona con el modelo cliente-servidor
        - Solo tiene un archivo
        - Es de codigo abierto
        - Android tiene todo lo necesario para crear y ejecutar las bases de datos de este tipo, asi como una api optimizada para ella
    - Como desventajas tenemos:
        - Funciones reducidas en comparacion a MYSQL o PostgreSQL
        - Escalabilidad limitada
        - Carece de caracteristicas de sql avanzadas como right, outer, join...
        - Bloquea la BBDD en cada escritura




# Preguntas test

## Tema 1

- Para que sirve un AVD
    - Para ver nuestros proyectos en un dispositivo virtual
- Sistemas mas actuales
    - Android e iphone
- Directorio Drawable
    - Guarda los archivos graficos
- Cual es el unico requisito para utilizar android
    - Tener version de JDK 7 y el SDK
- Donde esta el archivo manifest
    - Manifest
- Primera version Android
    - 2008
- ¿Para que sirve el archivo strings.xml?
    - Para almacenar todas las cadenas de texto del proyecto
- ¿Se puede programar en IOS de forma libre?
    - No
- ¿Para que sirve el directorio Layout?
    - Aquí tenemos los diferentes XML que definen los elementos de la pantalla y su disposición
- ¿Para que sirve el directorio Values?
    - Aquí tendremos los ficheros XML con definiciones de valores simples como enteros, colores o constantes de texto.
- ¿Una aplicación para android puede tener requisitos?
    - Si
- ¿Cual es la versión mas reciente de Android?
    - 14.X
- ¿Para que se utiliza el SDK manager?
    - Para descargar las diferentes versiones de android programables
- ¿Para que sirve el directorio Manifests?
    - Ninguna de las anteriores
- ¿Que contiene el archivo Android Manifest?
    - Lo componentes que forman la aplicación
    - Los permisos necesarios
    - El API minimo
- ¿Para que sirve el directorio Java?
    - Aquí es donde tendremos el código fuente Java que vayamos generando
- ¿Que tienen en común todas las versiones de Android?
    - Todas tienen nombre de dulces

## Tema 2
- ¿Para que sirve la propiedad id?
    - Para darle un identificador a un elemento
- ¿Cual de las siguientes etiquetas si pertenece a un TableLayout?
    - TableRow
- La mayoría de ficheros XML. en su primera línea de código...
    - Indican el encoding que tienen y la versión del XML
- ¿En que consiste un Relative Layout?
    - Este coloca los elementos de forma relativa respecto a su padre o sus hermanos
- Un widget:
    - Es una elemento gráfico
- Queremos poner un Padding de 20 ¿Como ponemos manualmente un valor en el Padding de un elemento?
    - 20dp
- ¿Por qué es necesario indicar la orientación en una table Layout?
    - Todo lo contrario, no la requieren.
- Los layouts se componen de...
    - Contenedores y widgets
- ¿Cual de los siguientes esta en desuso?
    - fill_parent
- ¿Se puede meter un Linear Layout dentro de otro?
    - se puede y es muy comun
- ¿A Que se refiere match_parent?
    - Se refiere a la altura y anchura total del contenedor
- ¿Cuál es la etiqueta que empleamos para indicar la anchura del layout?
    - Android:width
- ¿Para que sirve Android:layout_weight?
    - Para asignar un peso a un elemento
- ¿Qué clase comparten los contenedores y los widgets?
    - View
- La herramienta appt para definir los atributos de un layout crea una clase llamada...
    - R
    - R.java
- ¿Donde podemos encontrar el component tree?
    - En la parte derecha de la interfaz en la vista en modo Design
    
# Teoria desarrollo

### Indica cual es el ciclo de vida de una activity en Android y comenta brevemente lo que hace cada paso
### ¿Cuales son las ventajas / desventajas de una base de datos SQLite?
### En el motor de videojuegos unity, cual es la diferencia entre un método Update, Start y FixedUdate
### En el motor de videojuegos unity, para que valen los componentes que se asocian a los gama object. Explica los principales
### Cuando queremos desarrollar aplicaciones móviles, ¿Cuáles son las posibilidades de desarrollo en las diferentes plataformas?
### En el caso de tener dos ac0vitys en Android y queremos pasar de una a otra. ¿Cuál es el objeto que tenemos que u0lizar? Y en el caso de querer pasar datos, ¿Qué tendríamos que hacer?
### Cual es la diferencia entre un ListView y un RecyclerView. Explica brevemente como se ges0onan las pulsaciones de un recycler view
### Define como se pueden escuchar pulsaciones sobre un elemento en Android. ¿Y si se quieren asociar el mismo escuchador a varios elementos?
### En el ciclo de vida de una pantalla, hay un método que se llama onCreate(), el cual 0ene un método llamado setContentView. Indica que hace este método, su importancia y que archivos tiene relacionados
### Cuando en una pantalla queremos diferenciar lo que se ve cuando el móvil está en horizontal y en ver0cal. ¿Qué es lo que tenemos que hacer? ¿Y si queremos que todos los string de nuestra aplicación estén disponibles en español e inglés?
### Indica la importancia de guardar el estado en una aplicación Android. ¿Cómo se realiza este guardado y recuperación?
### En kotlin, existe una caracterís0ca llamada Null Safety. Indica que es y como funciona
### Además de poder u0lizar SQLite o Firebase como base de datos en Android, existe la posibilidad de u0lizar la persistencia DataStore. Explica cuando utilizar cada una de ellas
### En unity, cuando queremos que varios objetos se comporten de la misma forma y/o tengan las mismas caracterís0cas y elementos, ¿Qué podríamos hacer?
### Imagina que estamos desarrollando un juego y queremos detectar cuando un nuestro jugador está en el suelo y/o se posa sobre el. ¿Qué tendríamos que hacer?