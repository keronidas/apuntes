# Apuntes desarrollo aplicaciones

# Carpetas de un proyecto Android

En un proyecto de Android, la estructura de carpetas y archivos sigue un patrón específico que facilita la organización y el manejo del código, recursos y configuraciones. Aquí tienes una explicación de las carpetas más importantes:
1. app/src/main:

Esta es la carpeta principal donde se encuentra la mayor parte del código y recursos del proyecto.

- Java/Kotlin: Contiene los archivos de código fuente (.java o .kt). Aquí es donde escribes el código de tus actividades, servicios, receptores de difusión, etc.

- res: Contiene todos los recursos que no son código, como layouts XML, imágenes (drawables), valores (strings, dimens, colors), menús, etc.

    - layout: Archivos XML que definen la UI de tus actividades, fragmentos, etc.
    - drawable: Imágenes y gráficos utilizados en la aplicación.
    - mipmap: Íconos de la aplicación en diferentes resoluciones.
    - values: Archivos XML para strings, colores, dimensiones, estilos, etc.
        - strings.xml : Guarda strings para la App.
- AndroidManifest.xml: Es el archivo que define todas las componentes de tu aplicación (actividades, servicios, permisos, versión de SDK, etc.).

2. Gradle Scripts:

Aquí encontrarás los archivos build.gradle (a nivel de proyecto y de app) que son usados para configurar la compilación de tu aplicación, incluyendo dependencias, versiones del SDK de Android, plugins, etc.
3. Test:

- androidTest: Para pruebas que se ejecutan en un dispositivo Android. Estas son pruebas de integración y UI.
- test: Para pruebas unitarias que se ejecutan en el JVM.
4. assets:

Esta carpeta es opcional y se usa para almacenar archivos brutos que puedes querer acceder en tu aplicación, como archivos HTML, bases de datos, etc. No todos los proyectos la tienen por defecto, y puede necesitar ser creada manualmente si se requiere.
5. libs:

También opcional, esta carpeta se usa para incluir bibliotecas locales en forma de archivos .jar o .aar.
Cabe destacar que esta estructura puede variar ligeramente dependiendo de la configuración específica de tu proyecto y de si estás utilizando características adicionales o plugins. Sin embargo, la estructura descrita aquí representa el esquema general que encontrarás en la mayoría de los proyectos Android.

# Comandos CSS en android

- `layout_gravity` mueve el continente
- `gravity` mueve el contenido



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
