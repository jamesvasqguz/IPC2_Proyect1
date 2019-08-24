package Class;

import Class.ConectorDB;
import UI.jFCheckpoints;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author jara
 */
public class Cola {
    jFCheckpoints points = new jFCheckpoints();
    Connection cn = ConectorDB.conexion();
    LinkedList cola = new LinkedList();
    int capacidad;
    int top = 0, bottom = 0, ingresados=0;
    int idPaquete, tiempoRuta;
    String destino, nitCliente, localizacion, estadoPaquete;
    boolean prioridad;
    
    public Cola(int capacidad){
        this.capacidad = capacidad;
        Paquete[] p = new Paquete[capacidad];
    }
    
    public boolean vacia() {
        if (top == 0 && bottom == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean llena() {
        if (top == capacidad) {
            return true;
        } else {
            return false;
        }
    }


    public void llenar(String call, String destinoF) {
        try {
            PreparedStatement ps = cn.prepareStatement(
                    "SELECT * FROM Paquete ORDER BY prioridad desc, id_paquete asc");
            ResultSet rs = ps.executeQuery();
         
            while (ingresados<capacidad &&rs.next()){
                idPaquete = rs.getInt("id_paquete");
                nitCliente = rs.getString("nit_cliente");
                destino = rs.getString("destino");
                prioridad = rs.getBoolean("prioridad");
                estadoPaquete = rs.getString("estado_paquete");
                localizacion = rs.getString("localizacion");
                tiempoRuta = rs.getInt("tiempoRuta");
                Paquete tmp = new Paquete(idPaquete, tiempoRuta, destino, nitCliente, localizacion, estadoPaquete, prioridad);
                PreparedStatement ps1 = cn.prepareStatement("UPDATE Paquete SET localizacion='"+call+"' WHERE id_paquete="+idPaquete);
                ps1.executeUpdate();
                cola.push(tmp);
                ingresados++;
                System.out.println("Agregado "+idPaquete);
             }
        } catch (SQLException e) {
            System.err.println("Error la cargar paquete " + e);
        }
    }
      public void llenarEnRuta(String call) {
        try {
            PreparedStatement ps = cn.prepareStatement(
                    "SELECT * FROM Paquete ORDER BY prioridad desc, id_paquete asc WHERE localizacion = 'Bodega'");
            ResultSet rs = ps.executeQuery();
             while (ingresados<capacidad &&rs.next()){
                idPaquete = rs.getInt("id_paquete");
                nitCliente = rs.getString("nit_cliente");
                destino = rs.getString("destino");
                prioridad = rs.getBoolean("prioridad");
                estadoPaquete = rs.getString("estado_paquete");
                localizacion = rs.getString("localizacion");
                tiempoRuta = rs.getInt("tiempoRuta");
                Paquete tmp = new Paquete(idPaquete, tiempoRuta, destino, nitCliente, localizacion, estadoPaquete, prioridad);
                PreparedStatement ps1 = cn.prepareStatement("UPDATE Paquete SET localizacion = '"+call+"' WHERE id_paquete = '"+idPaquete+"'");
                ps1.executeUpdate();
                cola.push(tmp);
                ingresados++;
                System.out.println(idPaquete);
             }
        } catch (SQLException e) {
            System.err.println("Error la cargar paquete " + e);
        }
    }
    

}
