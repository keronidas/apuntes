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
<?xml version="1.0" encoding="UTF-8"?>
<empleados>
    <empleado>
        <nombre>Juan Pérez</nombre>
        <departamento>Recursos Humanos</departamento>
        <email>juan.perez@example.com</email>
    </empleado>
    <empleado>
        <nombre>Ana López</nombre>
        <departamento>Finanzas</departamento>
        <email>ana.lopez@example.com</email>
    </empleado>
    <!-- Más empleados aquí -->
</empleados>
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