package Class;
//Importamos las clases y las utilidades que usaremos en la actulizacion del usuario

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jara
 */
public class ConectorDB {
       
    /**
     *Este metodo retorna una conexion con la base de datos
     * @return
     */
    public static Connection conexion(){
        String user="jara";
        String password="asdf1234";
        String stringConnection = "jdbc:mysql://localhost:3306/Paqueteria";
        try{
            Connection cn = DriverManager.getConnection(stringConnection, user, password);
            return cn;
            }
        catch (SQLException e) {
            System.out.println("Fallo la conexion.");
            System.out.println(e);
        }
        return (null);
    }
    
}
