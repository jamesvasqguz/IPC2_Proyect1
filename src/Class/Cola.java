package Class;
//Importamos las clases e utilidades que vamos a implementar en la creacion de la cola
import Class.ConectorDB;
import UI.Administrador.jFCheckpoints;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author jara
 */
public class Cola {
//Creamos atributos para luego ser usados en la creacion de la cola
    jFCheckpoints points = new jFCheckpoints();
    Connection cn = ConectorDB.conexion();
    LinkedList cola = new LinkedList();
    int capacidad;
    int top = 0, bottom = 0, ingresados = 0;
    int idPaquete, tiempoRuta;
    String destino, nitCliente, localizacion, estadoPaquete;
    boolean prioridad;

//Creamos el constructor de la clase cola mandando el parametro de su tamaño
    public Cola(int capacidad) {
        this.capacidad = capacidad;
        Paquete[] p = new Paquete[capacidad];
    }
//Este metodo llena la cola del primer PC creado para la Ruta mandandole como parametro nombre del punto y su siguiente parada

    public void llenar(String call, String destinoF) {
        try {
            PreparedStatement ps = cn.prepareStatement(
                    "SELECT * FROM Paquete WHERE destino ='" + destinoF + "' ORDER BY prioridad desc, id_paquete asc");
            ResultSet rs = ps.executeQuery();
            while (ingresados < capacidad && rs.next()) {
                idPaquete = rs.getInt("id_paquete");
                nitCliente = rs.getString("nit_cliente");
                destino = rs.getString("destino");
                prioridad = rs.getBoolean("prioridad");
                estadoPaquete = rs.getString("estado_paquete");
                localizacion = rs.getString("localizacion");
                tiempoRuta = rs.getInt("tiempoRuta");
                Paquete tmp = new Paquete(idPaquete, tiempoRuta, destino, nitCliente, localizacion, estadoPaquete, prioridad);
                PreparedStatement ps1 = cn.prepareStatement("UPDATE Paquete SET localizacion='" + call + "' WHERE id_paquete=" + idPaquete);
                ps1.executeUpdate();
                cola.add(tmp);
                ingresados++;
                System.out.println("Agregado " + idPaquete);
            }
            System.out.println(destinoF);
        } catch (SQLException e) {
            System.err.println("Error la cargar paquete " + e);
        }
    }
}
