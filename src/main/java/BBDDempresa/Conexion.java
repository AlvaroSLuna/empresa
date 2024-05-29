package BBDDempresa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

}
