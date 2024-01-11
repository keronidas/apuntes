public static void main (String[] args){
    File archivoEntrada = new File("C://entrada.txt");
    File archivoSalida = new File("C://salida.txt");
    try{
        FileReader fr = new FileReader(archivoEntrada);
        FileWriter fw = new FileWriter(archivoSalida);
        int value;
        while((value=fr.read())!=-1){
            fw.write(value);
        }
       
    } catch (IOException e){
        e.printStackTrace();
    }
}


Connection miCon=DriverManager.getConexion("jdbc:mysql://localhost:3306/BD","root","");
String consulta="";
PreparedStatement miSentencia=miCon.prepareStatement(consulta);

----

-CREATE-
miSentencia.setString(1,"PACO")
miSentencia.executeUpdate();


-READ-
ResultSet miRs= miSentencia.executeQuery();
while(miRs.next()){
    miRs.getString(1);
}


-UPDATE-
miSentencia.setString(1,"PACIO");
miSentencia.executeUpdate();

-DELETE- 
miSentencia.setString(1,"Nombre")
miSentencia.executeUpdate()



HIBERNATE

public static void main(String [] args){
    SessionFactory sesion = HibernateUtil.getSessionFactory();
    Session session = sesion.openSession();
}

//CREATE
try{
    Transaction tx =session.beginTransaction();
    Empleados emp=new Empleados("PACO",22);
    session.save(emp);
    try{
        tx.commit();
    }
}

//READ

Query q =session.createQuery("From empleados");

try{
    List<Object> list=q.list();
    Iterator iter=list.iterator();

    while(iter.hasNext()){
        Object[] obj=iter.next();
        Empleado emp = (Empleados) obj[0];
        Departamento dep =(Departamento) obj[1];
    }
}

//Update

Transaction tx=session.beginTransaction();
String consulta="";
Query q =session.createQuery(consulta);
try{
    int filas=execu
}








