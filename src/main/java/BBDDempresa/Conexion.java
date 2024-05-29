package BBDDempresa;

import java.sql.*;

public class Conexion {
    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3010/proyecto?allowPublicKeyRetrieval=true";
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
                    stm.executeUpdate("CREATE TABLE Usuarios (ID VARCHAR(12) NOT NULL, Empleado VARCHAR(45), Cantidad/euros DOUBLE(45), Concepto VARCHAR(120), PRIMARY KEY (ID))");
                    System.out.println("Tabla 'Usuarios' creada exitosamente.");
                } else {
                    stm = cn.createStatement();
                    System.out.println("La tabla 'Usuarios' ya existe.");
                }

                rs = stm.executeQuery("SELECT * FROM Usuarios");

                while (rs.next()) {
                    String dni = rs.getString("DNI");
                    String nombre = rs.getString("nombre");
                    String pais = rs.getString("pais");
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
}
