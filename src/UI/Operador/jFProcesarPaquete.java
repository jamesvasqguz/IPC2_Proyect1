package UI.Operador;
//Importamos todo lo que necesitaremos
import UI.Inicio.FromPrincipal;
import Class.Cola;
import Class.ConectorDB;
import static UI.Administrador.Administrador.sesion_usuario;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author jara
 */
public class jFProcesarPaquete extends javax.swing.JFrame {
    
//Creamos atributos globales para ser utilizados en diferentes metodos 
    String destino = "";
    Connection cn = ConectorDB.conexion();
    float costo;
    int hora;
    
//Constructor del Form jFProcesarPaquete
    public jFProcesarPaquete() {
        initComponents();
        setSize(750, 300);
        setResizable(false);
        setTitle("Operador");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        cargarPunto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnProcesar = new javax.swing.JButton();
        txtHoras = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbPuntoControl = new javax.swing.JComboBox<>();
        cmbPaquetesCola = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbDestino = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 18)); // NOI18N
        jLabel1.setText("Procesar Paquetes");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(92, 7, 203, 34);

        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });
        jPanel1.add(btnProcesar);
        btnProcesar.setBounds(540, 180, 140, 70);
        jPanel1.add(txtHoras);
        txtHoras.setBounds(208, 190, 220, 33);

        jLabel2.setText("Cantidad de horas");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(12, 189, 149, 32);

        jLabel3.setText("Punto de control");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(12, 61, 102, 15);

        cmbPuntoControl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPuntoControlItemStateChanged(evt);
            }
        });
        cmbPuntoControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPuntoControlActionPerformed(evt);
            }
        });
        jPanel1.add(cmbPuntoControl);
        cmbPuntoControl.setBounds(208, 53, 220, 32);

        cmbPaquetesCola.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel1.add(cmbPaquetesCola);
        cmbPaquetesCola.setBounds(208, 120, 220, 32);

        jLabel4.setText("Paquetes en cola");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(12, 128, 102, 15);

        jLabel5.setText("Destino del Paquete:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(540, 90, 150, 15);

        jPanel1.add(cmbDestino);
        cmbDestino.setBounds(500, 110, 230, 32);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 750, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Este boton tiene un evento que es que procesa cada paquete
    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        int IdPaquete = Integer.parseInt(cmbPaquetesCola.getSelectedItem().toString());
        String des = cmbDestino.getSelectedItem().toString();
        hora = Integer.parseInt(txtHoras.getText().trim());
        String loca = "";

        try {
            PreparedStatement ps2 = cn.prepareStatement("SELECT localizacion FROM Paquete WHERE id_paquete='" + cmbPaquetesCola.getSelectedItem().toString() + "'");
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) {
                loca = rs2.getString("localizacion");
            }
        } catch (SQLException e) {
            System.err.println("Error al jalar localizacion para la variable loca " + e);
        }

        try {
            PreparedStatement ps1 = cn.prepareStatement("UPDATE Paquete SET localizacion=?, tiempoRuta=?,costo=? WHERE id_paquete ='" + IdPaquete + "' AND localizacion='" + loca + "'");
            ps1.setString(1, des);
            ps1.setInt(2, calcularHoras());
            ps1.setFloat(3, calcularCostos());          
            ps1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paquete paso Correctamente el Punto de Seguridad");
        } catch (SQLException e) {
            System.err.println("Error al actulizar paquete " + e);
        }
        
    }//GEN-LAST:event_btnProcesarActionPerformed
//Este evento me detecta cuando cambio de item en los combosB
    private void cmbPuntoControlItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPuntoControlItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            cmbPaquetesCola.removeAllItems();
            cmbDestino.removeAllItems();
            cargarPaquetes();
        }
    }//GEN-LAST:event_cmbPuntoControlItemStateChanged

    private void cmbPuntoControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPuntoControlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPuntoControlActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcesar;
    private javax.swing.JComboBox<String> cmbDestino;
    private javax.swing.JComboBox<String> cmbPaquetesCola;
    private javax.swing.JComboBox<String> cmbPuntoControl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtHoras;
    // End of variables declaration//GEN-END:variables

//Este metodo me carga los puntos de control existentes en la ruta    
    public void cargarPunto() {
        String user1 = FromPrincipal.user;
        int idUsuario = 0;

        ArrayList<String> list1 = new ArrayList<>();
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT id_usuario FROM Usuario WHERE username='" + user1 + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idUsuario = rs.getInt("id_usuario");
            }
            ps = cn.prepareStatement(
                    "SELECT nombre_punto FROM PuntoControl WHERE id_usuario= '" + idUsuario + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombrePunto = rs.getString("nombre_punto");
                list1.add(nombrePunto);
            }
            for (int i = 0; i < list1.size(); i++) {
                cmbPuntoControl.addItem(list1.get(i));
            }
        } catch (SQLException e) {
            System.err.println("Error en la conexion de DB con Administrador" + e);
        }
    }

//Este metodo me carga los paquete existentes de cada punto de control    
    public void cargarPaquetes() {
        String puntoControl = cmbPuntoControl.getSelectedItem().toString();
        ArrayList<String> list = new ArrayList<>();
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT id_paquete FROM Paquete WHERE localizacion='" + puntoControl + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String IdPaquete = String.valueOf(rs.getInt("id_paquete"));
                list.add(IdPaquete);
                for (int i = 0; i < list.size(); i++) {
                    cmbPaquetesCola.addItem(list.get(i));
                }
            }
            if (!list.isEmpty()) {
                cargarDestino();
            } else {
                cmbPaquetesCola.addItem("No hay paquetes");
            }
        } catch (SQLException e) {
            System.err.println("Error en la conexion de DB con Administrador" + e);
        }
    }

//Este metodo carga los puntos de control siguiente o si es el ultimo PC entonces llega a su destino
    public void cargarDestino() {
        ArrayList<String> list2 = new ArrayList<>();
        int idRuta = 0, idPunto = 0;

        try {
            PreparedStatement ps1 = cn.prepareStatement("SELECT id_rutas FROM PuntoControl WHERE nombre_punto='" + cmbPuntoControl.getSelectedItem().toString() + "'");
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                idRuta = rs1.getInt("id_rutas");
            }
        } catch (SQLException e) {
            System.err.println("Error en jalar id Ruta " + e);
        }

        try {
            PreparedStatement ps2 = cn.prepareStatement("SELECT id_punto FROM PuntoControl WHERE nombre_punto ='" + cmbPuntoControl.getSelectedItem().toString() + "'");
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) {
                idPunto = rs2.getInt("id_punto");
            }
        } catch (SQLException e) {
            System.err.println("Error al jalar el ID Punto " + e);
        }

        try {
            PreparedStatement ps = cn.prepareStatement("SELECT nombre_punto FROM PuntoControl WHERE id_rutas ='" + idRuta + "' AND id_punto>'" + idPunto + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombrePunto = rs.getString("nombre_punto");
                list2.add(nombrePunto);
            }
            if (!rs.next() && cmbPaquetesCola.getItemCount() != 0) {
                String idPaquetes = cmbPaquetesCola.getSelectedItem().toString();
                try {
                    PreparedStatement ps4 = cn.prepareStatement("SELECT destino FROM Paquete WHERE id_paquete='" + idPaquetes + "'");
                    ResultSet rs4 = ps4.executeQuery();
                    if (rs4.next()) {
                        destino = rs4.getString("destino");
                        list2.add(destino);
                    }
                } catch (SQLException e) {
                    System.err.println("Error al jalar destino para la variable destino " + e);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al jalar nombre del punto" + e);
        }
        for (int i = 0; i < list2.size(); i++) {
            cmbDestino.addItem(list2.get(i));
        }
    }

//Este metodo calcula las horas que el paquete pasa en los Puntos de Control
    public int calcularHoras() {
        int horasNuevas = 0, horas;
        String id = cmbPaquetesCola.getSelectedItem().toString();

        try {
            PreparedStatement ps6 = cn.prepareStatement("SELECT tiempoRuta, costo FROM Paquete WHERE id_paquete='" + id + "'");
            ResultSet rs6 = ps6.executeQuery();
            if (rs6.next()) {
                horas = rs6.getInt("tiempoRuta");
                horasNuevas = horas + hora;
                System.out.println(horas);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener horas que paso el paquete en el punto de control " + e);
        }
        return horasNuevas;
    }

//Este metodo calcula el costo del paquete en sus puntos de control multiplicando la horas que paso en el PC con la tarifa del PC    
    public float calcularCostos() {
        float costoNuevo = 0, tarifaC = 0;
        int time = 0;
        String punto = cmbPuntoControl.getSelectedItem().toString();
        String id = cmbPaquetesCola.getSelectedItem().toString();
        time = Integer.parseInt(txtHoras.getText().trim());
        try {
            PreparedStatement ps5 = cn.prepareStatement("SELECT tarifa FROM PuntoControl WHERE nombre_punto='" + punto + "'");
            ResultSet rs5 = ps5.executeQuery();
            if (rs5.next()) {
                tarifaC = rs5.getFloat("tarifa");
                System.out.println(punto);
                System.out.println(tarifaC);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener tarifa del punto de control " + e);
        }
        try {
            PreparedStatement ps6 = cn.prepareStatement("SELECT costo FROM Paquete WHERE id_paquete='" + id + "'");
            ResultSet rs6 = ps6.executeQuery();
            if (rs6.next()) {
                costo = rs6.getFloat("costo");
                costoNuevo = costo + (time * tarifaC);
                System.out.println(costo);
                System.out.println(time);
                System.out.println(costoNuevo);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener tiempoRuta y costo de Paquete " + e);
        }
        return costoNuevo;
    }
}
