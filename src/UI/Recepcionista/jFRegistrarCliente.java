package UI.Recepcionista;
//Importamos las clases y las utilidades que usaremos en la actulizacion del usuario

import UI.Inicio.FromPrincipal;
import java.sql.*;
import Class.ConectorDB;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author jara
 */
public class jFRegistrarCliente extends javax.swing.JFrame {

//Atributos que declaramos globales para poder ser usados en los distintos metodos   
    String user;
    Connection cn = ConectorDB.conexion();
    public static String nombre, nitCliente;

    /**
     * Constructor
     */
    public jFRegistrarCliente() {
        initComponents();
        setSize(650, 500);
        setResizable(false);
        setTitle("Registrar Nuevo Cliente");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        user = FromPrincipal.user;

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
        jLabel3 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        btnRegistrarClient = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNitCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Source Code Pro Semibold", 3, 24)); // NOI18N
        jLabel1.setText("Ingrese los Datos del Cliente");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 20, 460, 40);

        jLabel3.setText("Nombre del Cliente:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 80, 150, 15);

        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreCliente);
        txtNombreCliente.setBounds(30, 100, 300, 32);

        btnRegistrarClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnRegistrarClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClientActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarClient);
        btnRegistrarClient.setBounds(240, 290, 130, 100);

        jLabel2.setText("NIT Cliente:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 180, 100, 15);

        txtNitCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNitClienteKeyTyped(evt);
            }
        });
        jPanel1.add(txtNitCliente);
        txtNitCliente.setBounds(30, 200, 300, 32);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 640, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Este boton tiene el evento que al darle click agregue al nuevo cliente a la DB
    private void btnRegistrarClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClientActionPerformed
        aggCliente();
    }//GEN-LAST:event_btnRegistrarClientActionPerformed
//Este evento en el campo donde ingresan el nombre no permite ingresar ningun numero
    private void txtNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyTyped
        char c = evt.getKeyChar();
        if (c < 'a' || c > 'z') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreClienteKeyTyped
//Este evento en el campo donde ingresan el nit no permite agregar letras
    private void txtNitClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitClienteKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNitClienteKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarClient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNitCliente;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
 //Este metodo limpia los campos que fueron llenados durante la creacion del cliente
    public void clear() {
        txtNombreCliente.setText("");
        txtNitCliente.setText("");
    }
//Este metodo permite la creacion de un cliente nuevo

    public void aggCliente() {
        int validacion = 0;

        nombre = txtNombreCliente.getText().trim();
        nitCliente = txtNitCliente.getText().trim();

        if (nombre.equals("")) {
            txtNombreCliente.setBackground(Color.red);
            validacion++;
        }
        if (nitCliente.equals("")) {
            txtNitCliente.setBackground(Color.red);
            validacion++;
        }
        try {
            PreparedStatement ps = cn.prepareStatement(
                    "SELECT nit_cliente FROM Clientes WHERE nit_cliente='"
                    + nitCliente + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                txtNombreCliente.setBackground(Color.red);
                txtNitCliente.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Cliente ya existe! \n Prueba con otro");
                cn.close();
            } else {
                if (validacion == 0) {
                    try {
                        PreparedStatement ps1 = cn.prepareStatement("INSERT INTO Clientes VALUES(?,?,?)");
                        ps1.setInt(1, 0);
                        ps1.setString(2, nitCliente);
                        ps1.setString(3, nombre);
                        ps1.executeUpdate();

                        clear();
                        txtNombreCliente.setBackground(Color.green);
                        txtNitCliente.setBackground(Color.green);
                        JOptionPane.showMessageDialog(null, "Cliente creado exitosamente!");
                        this.dispose();
                    } catch (SQLException e) {
                        System.err.println("Error al registrar nuevo cliente." + e);
                        JOptionPane.showMessageDialog(null, "Error al registrar nuevo cliente!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Campos incompletos!! \n Ingrese todos los datos.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al validar cliente" + e);
            JOptionPane.showMessageDialog(null, "Error al comparar cliente!");
        }
    }
}
