package UI.Administrador;
//Importamos las clases o las utilidades que vayamos a implementar

import UI.Inicio.FromPrincipal;
import Class.Cola;
import java.sql.*;
import Class.ConectorDB;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author jara
 */
public class jFCheckpoints extends javax.swing.JFrame {
//Definimos atributos globales para luego ser usados en diferentes metodos

    String user;
    Connection cn = ConectorDB.conexion();
    int cmb_estado = 0, id, numOpe, size = 0, costo;
    String nombrePunto, ruta, ope, cmb_Estado = "";
    float tarifa;

    /**
     * Creates new form jFCheckpoints
     */
    public jFCheckpoints() {
        initComponents();
        setTitle("Crear Punto de Control");
        setSize(650, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        user = FromPrincipal.user;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        createCheckpoint();                                                     //Llamamos al metodo carga las operarios en ComboBox
        rutas();                                                                //Llamamos al metodo carga las rutas en ComboBox
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbRuta = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbOperador = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbEstadoControl = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioHora = new javax.swing.JTextField();
        btnCrearPC = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNombrePC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans", 3, 24)); // NOI18N
        jLabel1.setText("Nuevo Punto de Control");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(120, 10, 370, 40);

        jLabel2.setText("Seleccione Ruta a la cual pertenece:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 70, 290, 15);

        jPanel1.add(cmbRuta);
        cmbRuta.setBounds(30, 90, 220, 32);

        jLabel3.setText("Seleccione Operador");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 160, 230, 15);

        jPanel1.add(cmbOperador);
        cmbOperador.setBounds(30, 180, 220, 32);

        jLabel4.setText("Estado del Punto de Control");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(350, 70, 220, 15);

        cmbEstadoControl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel1.add(cmbEstadoControl);
        cmbEstadoControl.setBounds(350, 90, 102, 32);

        jLabel5.setText("Tarifa Global:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(350, 160, 130, 15);
        jPanel1.add(txtPrecioHora);
        txtPrecioHora.setBounds(350, 180, 190, 32);

        btnCrearPC.setText("Crear Punto de Control");
        btnCrearPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPCActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearPC);
        btnCrearPC.setBounds(210, 360, 160, 80);

        jLabel6.setText("Nombre del Punto Control");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(220, 290, 190, 15);

        txtNombrePC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePCKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombrePC);
        txtNombrePC.setBounds(120, 310, 380, 32);

        jLabel7.setText("Capacidad del Punto Control:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(210, 230, 230, 15);

        txtSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSizeKeyTyped(evt);
            }
        });
        jPanel1.add(txtSize);
        txtSize.setBounds(250, 250, 100, 32);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 780, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

//Este boton tiene el evento que crea los PC     
    private void btnCrearPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPCActionPerformed
        combo();
        createPC();
        createColaPC();
    }//GEN-LAST:event_btnCrearPCActionPerformed
//Este metodo permite que no puedan ser ingresados numeros en la cantidad de paquete que almacena el PC
    private void txtSizeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSizeKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtSizeKeyTyped

    private void txtNombrePCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePCKeyTyped

    }//GEN-LAST:event_txtNombrePCKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearPC;
    private javax.swing.JComboBox<String> cmbEstadoControl;
    private javax.swing.JComboBox<String> cmbOperador;
    private javax.swing.JComboBox<String> cmbRuta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNombrePC;
    private javax.swing.JTextField txtPrecioHora;
    private javax.swing.JTextField txtSize;
    // End of variables declaration//GEN-END:variables

//Este metodo crea un ArrayList que contiene a todos los usuarios que son operadores
    public ArrayList<String> operarios() {
        ArrayList<String> list = new ArrayList<String>();
        String dato = "SELECT tipo_nivel, nombre_usuario FROM Usuario";
        try {
            PreparedStatement ps1 = cn.prepareStatement(dato);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                if (rs.getString("tipo_nivel").equals("Operador")) {
                    list.add(rs.getString("nombre_usuario"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar DB con Usuario");
        }
        return list;
    }

//Este metodo agrega los operadores del metodo anterior al combo de los usuarios
    public void createCheckpoint() {
        try {
            operarios();
            ArrayList<String> list = new ArrayList<String>();
            list = operarios();
            for (int i = 0; i < list.size(); i++) {
                cmbOperador.addItem(list.get(i));
            }
        } catch (Exception e) {
        }
    }

//Este metodo crea un ArrayList que contiene a todos las rutas que se le pueden asiganar al PC
    public ArrayList<String> arrayRuta() {
        ArrayList<String> list1 = new ArrayList<String>();
        String dato1 = "SELECT nombre_ruta FROM Rutas";
        try {
            PreparedStatement ps2 = cn.prepareStatement(dato1);
            ResultSet rs1 = ps2.executeQuery();
            while (rs1.next()) {
                list1.add(rs1.getString("nombre_ruta"));
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar DB con ruta");
        }
        return list1;
    }

//Este metodo agrega las rutas del metodo anterior al combo de las rutas 
    public void rutas() {
        try {
            arrayRuta();
            ArrayList<String> list1 = new ArrayList<String>();
            list1 = arrayRuta();
            for (int i = 0; i < list1.size(); i++) {
                cmbRuta.addItem(list1.get(i));
            }
        } catch (Exception e) {
        }
    }

//Este metodo convierte la eleccion del checkBox a un String que settea el estado del PC     
    public void combo() {
        cmb_estado = cmbEstadoControl.getSelectedIndex() + 1;
        if (cmb_estado == 1) {
            cmb_Estado = "Activo";
        } else if (cmb_estado == 2) {
            cmb_Estado = "Inactivo";
        }
    }

//Este metodo manda el parametro a la cola del PC nuevo que va creando    
    public String destinoF() {
        System.out.println(id);
        String destinoF = "";
        try {
            PreparedStatement ps1 = cn.prepareStatement("SELECT destino FROM Rutas WHERE id_rutas =" + id);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                destinoF = rs1.getString("destino");
            }
        } catch (SQLException ex) {
            System.err.println("Eror " + ex);
        }
        System.out.println(destinoF);
        return destinoF;
    }

//Este metodo crea el PC obteniendo toda la informacion que el Administrador proporciona
    public void createPC() {
        ruta = cmbRuta.getSelectedItem().toString();
        ope = cmbOperador.getSelectedItem().toString();
        tarifa = Float.parseFloat(txtPrecioHora.getText().trim());
        nombrePunto = txtNombrePC.getText().trim();
        size = Integer.parseInt(txtSize.getText().trim());
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT id_rutas FROM Rutas WHERE nombre_ruta = '" + ruta + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_rutas");
                System.out.println("El id de la ruta es " + id);
            }
            PreparedStatement ps1 = cn.prepareStatement("SELECT id_usuario FROM Usuario WHERE nombre_usuario='" + ope + "'");
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                numOpe = rs1.getInt("id_usuario");
                System.out.println("El id del usuario es " + numOpe);
            }
            PreparedStatement ps2 = cn.prepareStatement("INSERT INTO PuntoControl VALUES(?,?,?,?,?,?,?)");
            ps2.setInt(1, 0);
            ps2.setInt(2, id);
            ps2.setInt(3, numOpe);
            ps2.setString(4, cmb_Estado);
            ps2.setString(5, nombrePunto);
            ps2.setFloat(6, tarifa);
            ps2.setInt(7, size);
            ps2.executeUpdate();
            txtPrecioHora.setBackground(Color.green);
            txtNombrePC.setBackground(Color.green);
            txtSize.setBackground(Color.green);
            JOptionPane.showMessageDialog(null, "Punto de control creado y asignado exitosamente!");
            this.dispose();
        } catch (SQLException e) {
            System.err.println("Error al crear nuevo punto de control." + e);
            JOptionPane.showMessageDialog(null, "Error al registrar punto de control!");
        }
    }

//Este metodo crea la Cola del PC    
    public void createColaPC() {
        Cola c = new Cola(size);
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM Paquete WHERE localizacion <>'Bodega'"
                    + "AND ruta='" + cmbRuta.getSelectedItem().toString() + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            } else {
                c.llenar(nombrePunto, destinoF());
            }
        } catch (SQLException e) {
            System.err.println("Error en la conexion de DB con Administrador" + e);
        }
    }
}
