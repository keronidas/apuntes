# Manejo de ficheros

##  Ficheros de caracteres/texto

Si usamos el metodo buffered necesitamos tener el siguiente orden:
1. Creamos el File
2. Creamos el FileReader y FileWriter
3. Creamos el BufferedReader y BufferedWriter
4. Creamos el bucle



```
import java.io.*;

public class CopyData {
    public static void main(String[] args) {


        // Archivos - Asegúrate de especificar la ruta correcta
        File archivoFuente = new File("ruta/del/archivo/fuente.txt");
        File archivoDestino = new File("ruta/del/archivo/destino.txt");

        try (
            // Crear objetos para leer y escribir archivos

            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivoFuente));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivoDestino))
        ) {
            String linea;

            // Leer cada línea del archivo fuente y escribirla en el archivo destino
            while ((linea = bufferedReader.readLine()) != null) {
                bufferedWriter.write(linea);
                bufferedWriter.newLine(); // Añadir salto de línea
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Si queremos leer solo un caracter el bucle seria asi 
```
 while ((caracter = fileReader.read()) != -1) {
        fileWriter.write(caracter);
     }
```

## Ficheros de configuracion

Hay una clase en Java para poder gestionar ficheros de configuración y facilita muchísimo la forma de acceder y escribir en ellos, gestiona muy bien flujo de información: Properties.

```
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateConfigFile {
    public static void main(String[] args) {
        // Crear un objeto Properties
        Properties prop = new Properties();

        // Definir algunas propiedades de configuración
        prop.setProperty("database.url", "jdbc:mysql://localhost:3306/miBaseDeDatos");
        prop.setProperty("database.user", "usuario");
        prop.setProperty("database.password", "contraseña");

        try {
            // Guardar las propiedades en un archivo
            prop.store(new FileOutputStream("config.properties"), "Configuración de la aplicación");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
```
## Ficheros de datos binarios

En los ficheros binarios se utiliza la clase FileInputStream y FileOutputStream
El condicional se basa en que el dato obtenido tenga un valor de -1, que indica final del fichero

```
public class FicherosBinariosEscribir {
	public static void main(String[] args) throws
    IOException{
        File fichero = new
    File("X:\\workspace\\FicherosBinariosEscribir\\src\\FicheroP
    rueba.dat");
        FileOutputStream salida = new
    FileOutputStream(fichero, true);
        FileInputStream entrada = new
    FileInputStream(fichero);
        int i;
    
        for (i = 0; i < 101; i++)  
        salida.write(i);
        salida.close();
    
        while ((i=entrada.read()) != ‐1)  
        System.out.println(i);
        entrada.close();
        
    }
}
```
## Ficheros de datos o .dat

En este tipo de ficheros hay que hacer los siguientes pasos:
1. Crear el objeto `File`
2. Crear el objeto `FileInputStream / FileOutputStream`
3. Crear el objeto `DataInputStream / DataOutputStream`
4. Aqui el condicional es un `while(true)`

```
public static void main(String[] args) throws
IOException{
    File fichero = new
File("X:\\workspace\\FicherosBinariosEscribir\\src\\FicheroArrays.dat");
    FileInputStream entrada = new FileInputStream(fichero);
    DataInputStream entradadatos = new DataInputStream(entrada);
   
    String marca;
    int anio;
    try {
    while (true) {
     marca = entradadatos.readUTF();
     anio =entradadatos.readInt();
     System.out.println("Marca: " + marca + " anio: " + anio);
     
    }
    } catch (EOFException e) {
    entradadatos.close();
    }
}

```
## Ficheros con clase Object

En este tipo de ficheros necesitamos hacer los siguientes pasos:
1. Crear el objeto `File`
2. Crear el objeto `FileInputStream / FileOutputStream`
3. Crear el objeto `ObjectInputStream / ObjectOutputStream`
4. Si queremos leer los datos lo hacemos con un `while(true)`

```
File fichero = new File("libro.dat");
FileOutputStream flujo = new FileOutputStream(fichero);
ObjectOutputStream objeto = new ObjectOutputStream(flujo);

//Creamos varios objetos
Libro l1= new Libro("Perro",2);

//Guardamos los datos
objeto.writeObject(l1);

lectura= (Libro) objetoEntrada.readObject()

```

## Documentos XML

Pasos en un fichero xml

1. Crear objeto DocumentBuilderFactory
2. Crear el objeto Document
3. Validar la estructura
4. Extraer el elemento raiz
5. Examinar los atributos
6. Examinar los subelementos

Dado el XML

```
<camaras_web>
    <camara id="1">
        <modelo>CÁMARA WEB EMPRESARIAL BRIO ULTRA HD PRO</modelo>
        <marca>Logitech</marca>
        <altura>27 mm </altura>
        <anchura>102 mm</anchura>
        <profundidad>27 mm</profundidad>
        <peso>63 g</peso>
        <megapixeles>13</megapixeles>
        <comentarios>RightLight 3 con HDR para ofrecer imágenes nítidas en diversas condiciones de iluminación, desde luz escasa a luz solar directa </comentarios>
    </camara>
    <camara id="2">
        <modelo>CÁMARA WEB HD PRO C920s</modelo>
        <marca>Logitech</marca>
        <altura>43,3 mm</altura>
        <anchura>94 mm</anchura>
        <profundidad>71 mm</profundidad>
        <peso>162 g</peso>
        <megapixeles>3</megapixeles>
        <comentarios>Clip universal acoplable a trípode, para monitores, pantallas LCD o portátiles </comentarios>
    </camara>
    <camara id="3">
        <modelo>STREAMCAM</modelo>
        <marca>Logitech</marca>
        <altura>66 mm </altura>
        <anchura>58 mm </anchura>
        <profundidad>48 mm </profundidad>
        <peso>222 g</peso>
        <megapixeles>-</megapixeles>
        <comentarios>Dos micrófonos omnidireccionales con filtro de reducción de ruido </comentarios>
    </camara>
    <camara id="4">
        <modelo>4K PRO MAGNETIC WEBCAM</modelo>
        <marca>Logitech</marca>
        <altura>3,5 cm </altura>
        <anchura>10,1 cm </anchura>
        <profundidad>2,7 cm </profundidad>
        <peso>90,2 g </peso>
        <megapixeles>-</megapixeles>
        <comentarios> RightLight 3 con HDR para ofrecer imágenes nítidas en diversas condiciones de iluminación, desde luz escasa a luz solar directa. Controles de imagen con la aplicación Camera Settings opcional, para funciones de panorámica, inclinación y zoom. Dos micrófonos omnidireccionales integrados con cancelación de eco y supresión de ruido </comentarios>
    </camara>
</camaras_web>
```

Tenemos que hacer 
```
public class ReadXMLFile {

    public static void main(String[] args) throws SAXException, IOException {
		// TODO Auto-generated method stub
		File miXml = new File("");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();

			// 2. Creamos el objeto DOCUMENT
			Document document = builder.parse(miXml);

			// 3. VALIDAMOS EL XML / Normalizamos
			document.getDocumentElement().normalize();

			// 4. Extraemos el nodo raiz
			Element root = document.getDocumentElement();
			NodeList nList = root.getElementsByTagName("camara");

			// Iteramos la lista de camaras
			// Crearemos un nodo temporal con el item de la lista y si es del tipo element
			// node lo extraeremos
			
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					
					// Importante hacer un casting de Element
					Element eElement = (Element) node;
					System.out.println(eElement.getAttribute("id"));
					System.out.println(eElement.getElementsByTagName("modelo").item(0).getTextContent());
				}
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
```

## Conexion BBDD
```
public static void main(String [] args){
    Connection miCon = DriverManager.getConnection("localhost","user","pass");
    String sentencia = "Select * from empleados";
    PreparedStatement sentenciaP = conexion.prepareStatement(sentencia);
    ResultSet rs = sentenciaP.executeQuery();

    //Para leer
    while(rs.next()){
        String dato1 = rs.getString(1);
        String dato2 = rs.getString(2);
    }

    //Para escribir
        rs.setString(1,"valor");
        int filasModificadas = rs.executeUpdate();
        System.out.println("hemos modificado" + filasModificadas);
}
```




## Hibernate

### Leer datos
```
public static void main(String [] args){
    SessionFactory sesion = HibernateUtil.getSessionFactory();
    Session session = sesion.openSession();
    try{
        Query q =session.createSession("from departamentos");
    }
 }
```

Ahora tenemos dos opciones
1. Crear una lista y luego un iterador
```
List <Empleados> list = q.list();
Iterator <Empleados> iter = list.iterator();
```
2. Crear el iterador directamente
```
Iterator iter = q.iterate();
```
El bucle seria siempre igual para la 1 y 2
```
while (iter.hasNext()){
    Empleados emp = (Empleados) iter.next();
    //Imprimimos lo que haga falta del objeto
}
```
3. Si extraemos con una consulta preparada lo guardamos en un array de objetos
La consulta puede ser:
`from Empleados e, departamentos d where " e.departamentos=d.numeroDepartamento order by Apellido"`
```
while(iter.hasNext()){
    Object[] obj =(Object[]) iter.next();
    Empleados emp = (Empleados) obj[0];
    Departamentos dep = (Departamentos) obj[1];
}
```

### Insertar datos
```
public static void main(String [] args){
    SessionFactory sesion = HibernateUtil.getSessionFactory();
    Session session = sesion.openSession();
    Transaction tx = session.beginTransaction();

    //Creamos el objeto

    Empleados miEmp = new Empleados("Paco",54);

    try{
        //Guardamos y hacemos commit
        session.save(miEmp);
        try{
            tx.commit();
        } catch(IOException e){

        }
    }catch(IOException e){

    }


 }
```
### Update y Delete son iguales

```
    SessionFactory sesion = HibernateUtil.getSessionFactory();
    Session session = sesion.openSession();
    Transaction tx = session.beginTransaction();

    String hqlActua="";
    Query q = session.createQuery(hqlActua);

    int filas = q.executeUpdate();
    //Imprimimos el numero de filas
    System.out.println("Se ha modificado" + filas)
    tx.commit();
```
## BBDDXML


Importante aprender

```
String codigo = "/universidad/departamento/codigo[.='IFC1']/../empleado/nombre/text()";
ResourceSet result = servicio.query(codigo);
ResourceIterator i = result.getIterator();


while(i.hasMoreResources()){
    Resource r = i.nextResource();
    String s =r.getContent().toString();
    //Parseo
    System.out.println(r.getContent());
}
```


# TEST

- ¿Qué son las operaciones altas?
    - Son las responsables de adiciones de un nuevo registro en el fichero con el que trabajamos.
- ¿Qué permite hacer el método isDirectory()?
    - Este método devuelve true si el objeto File corresponde a un directorio.
- ¿Cuál de estos métodos permite crear un array de strings con los nombres de ficheros y directorios asociados al objeto File?
    - list()
- ¿Qué hace el método int read() de la clase FileReader?
    - Lee un carácter y lo devuelve
- ¿Cuál es la operación encargada de buscar un fichero con unos datos determinados?
    - Una consulta
- Las clases FileInputStream y FileOutputStream sirven para..
    - Para el acceso a fichero binarios en Java
- Que es un stream
    - Un flujo de comunicación entre una fuente y un destino.
- ¿Qué hace un try/catch?
    - Ejecutar línea por línea el código, y si ocurre una excepción, tratarla.
- ¿Qué dos clases de acceso a un fichero existen?
    - Acceso secuencial y acceso directo o aleatorio.




Ficheros config
Binarios puros
CRUD JDBC
CRUD Hibernate

Cuando pides datos al user prepared

