# Manejo de ficheros


# TEMARIO

1. Ficheros Caracteres/texto
2. Ficheros configuracion 
3. Ficheros binario
4. Ficheros .dat
5. Ficheros clase Object
6. Documentos XML
7. Conexion BBDD
8. Hibernate
9. MongoDB
10. 

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
public class EjemploCRUD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
        String user = "usuario";
        String password = "contraseña";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            // CREATE
            createEmpleado(con, 1, "Paco");

            // READ
            readEmpleados(con);

            // UPDATE
            updateEmpleado(con, 1, "Francisco");

            // DELETE
            deleteEmpleado(con, 1);

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos CRUD
    private static void createEmpleado(Connection con, int id, String nombre) throws SQLException {
        String sql = "INSERT INTO empleados (id, nombre) VALUES (?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            pstmt.executeUpdate();
        }
    }

    private static void readEmpleados(Connection con) throws SQLException {
        String sql = "SELECT * FROM empleados";
        try (PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre"));
            }
        }
    }

    private static void updateEmpleado(Connection con, int id, String nuevoNombre) throws SQLException {
        String sql = "UPDATE empleados SET nombre = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, nuevoNombre);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }

    private static void deleteEmpleado(Connection con, int id) throws SQLException {
        String sql = "DELETE FROM empleados WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
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
### Update

```
    SessionFactory sesion = HibernateUtil.getSessionFactory();
    Session session = sesion.openSession();
    Transaction tx = session.beginTransaction();
    Cliente miCliente=session.get(Clientes.class,1);
    miCliente.setName("Pedro");
    tx.commit();
    session.close();
```
    SessionFactory sesion = HibernateUtil.getSessionFactory();
    Session session = sesion.openSession();
    Transaction tx = session.beginTransaction();

### Delete
```

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


## MongoDB

Comandos con MongoDB
- Listar bases de datos -> `show databases`
- Mostrar la base de datos actual -> `db`
- Mostrar colecciones de la base de datos actual -> `show collections`
- Usar una base de datos -> `use database`
- Para usar count debemos hacer `db.nombre_coleccion.count()`, tambien sirve para `.save` y `.insert`
```
use mibasededatos
Amigo1={nombre:'Ana',edad:23};
db.amigos.save(Amigo1);
```
- Para consultar registros usamos `.find`
```
use mibasededatos
db.amigos.find()

//Ordenados por nombre
db.amigos.find().sort({nombre:1})
db.amigos.find().sort({nombre:-1})
```

### El mongo id esta basado en 12 bytes

- Los 4 primeros son `marca de tiempo`
- Los 3 siguientes son `identificacion equipo`
- Los 2 siguientes `identificador proceso`
- Los 3 ultimos `numero aleatorio`

Para conectarse en JAVA

```
MongoClient cliente =new MongoClient();
MongoClient db = cliente.getDatabase("mibasededatos);
MongoCollection<Document> coleccion = db.getCollection("amigos");

//Para buscar
List <Document> consulta = coleccion.find().into(new ArrayList <Document>());

for (int i=0;i<consulta.size();i++){
    System.out.println("",consulta.get(i).toString());
    Document amig = consulta.get(i);
    amig.getString(nombre)
    amig.getString(curso)
    amig.getString(edad)
}


```

Otra clase seria 
```
MongoCursor<Document> cursor = coleccion.find().iterator();

while (cursor.hasNext()){
    Document doc = cursor.next()

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

