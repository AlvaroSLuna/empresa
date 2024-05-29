package BBDDempresa;

import java.sql.*;

public class Conexion{
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3010/Empresa?allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root";
    private static final String CLAVE = "123456789";


    public Connection conectar() {
        Connection conexion = null;
        try {
            // Obtiene la conexión a la base de datos utilizando las constantes de conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión OK");
        } catch (SQLException e) {
            // Si hay un error en la conexión, imprime un mensaje de error y muestra la traza de la excepción
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        return conexion;
    }
   public void startDB(){
        Conexion con = new Conexion();
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            cn = con.conectar();
            if (cn != null) {
                if (!tableExists(cn, "DIETAS")) {
                    stm = cn.createStatement();
                    stm.executeUpdate("CREATE TABLE Dietas (ID VARCHAR(12) NOT NULL, Empleado VARCHAR(45), Departamento VARCHAR(45), Cantidad DOUBLE, Concepto VARCHAR(120), PRIMARY KEY (ID))");
                    System.out.println("Tabla 'Dietas' creada exitosamente.");
                } else {
                    stm = cn.createStatement();
                    System.out.println("La tabla 'Dietas' ya existe.");
                }

                rs = stm.executeQuery("SELECT * FROM Dietas");

                while (rs.next()) {
                    String id = rs.getString("ID");
                    String empleado = rs.getString("Empleado");
                    String departamento = rs.getString("Departamento");
                    String cantidad = rs.getString("Cantidad");
                    String concepto = rs.getString("Concepto");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static boolean tableExists(Connection connection, String tableName) throws SQLException {
        boolean exists = false;
        DatabaseMetaData meta = connection.getMetaData();
        try (ResultSet rs = meta.getTables(null, null, tableName, null)) {
            if (rs.next()) {
                exists = true;
            }
        }
        return exists;
    }

    public String anyadirDietas(Dieta dieta) {

    Conexion con = new Conexion();
    Connection cn = null;
    Statement stm = null;
    ResultSet rs = null;
    String result = null;

    try {
        cn = con.conectar();
        stm = cn.createStatement();
        stm.executeUpdate("INSERT INTO Dietas (ID, Empleado, Cantidad, Concepto) VALUES ('" + dieta.getID() + "', '" + dieta.getEmpleado() + "', '" + dieta.getDepartamento() + "', '"+ dieta.getCantidad() + "', '" + dieta.getConcepto() + "')");
        result = "Dietas insertadas correctamente";
    }catch (SQLException e) {
        //e.printStackTrace();
        result = "\nError en la inserción\n";
    }
    return result;
    }

public String mostarDietas() {

    Conexion con = new Conexion();
    Connection cn = null;
    Statement stm = null;
    ResultSet rs = null;
    String result = null;

    try {
        cn = con.conectar();
        stm = cn.createStatement();
        rs = stm.executeQuery("SELECT * FROM Dietas WHERE Departamento = 'Informática' AND Cantidad > 30");
        while (rs.next()) {
            String id = rs.getString("ID");
            String empleado = rs.getString("Empleado");
            String departamento = rs.getString("Departamento");
            String cantidad = rs.getString("Cantidad");
            String concepto = rs.getString("Concepto");
        }
    } catch (SQLException e) {
        //e.printStackTrace();
        result = "\nError en la consulta\n";
    }
    return result;
}

}
