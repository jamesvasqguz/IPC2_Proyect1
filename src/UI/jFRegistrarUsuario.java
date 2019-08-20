package UI;
import java.sql.*;
import Class.ConectorDB;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author jara
 */
public class jFRegistrarUsuario extends javax.swing.JFrame {
    
    String user;

    /**
     * Creates new form jFRegistrarUsuario
     */
    public jFRegistrarUsuario() {
        initComponents();
        setTitle("Registrar Usuario");
        setSize(650, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        user = FromPrincipal.user;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTFNueUsuario = new javax.swing.JTextField();
        jTFNueUserName = new javax.swing.JTextField();
        jTFNuePass = new javax.swing.JTextField();
        cmb_niveles = new javax.swing.JComboBox<>();
        btnRegistrarNueUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel1.setText("Registrar Nuevo Usuario");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(170, 10, 450, 50);

        jLabel2.setText("Ingresar nombre del Usuario:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 70, 190, 15);

        jLabel4.setText("Ingresar UserName:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 170, 150, 15);

        jLabel5.setText("Ingresar Password:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 270, 130, 15);

        jLabel6.setText("Seleccionar Nivel de Usuario");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(360, 70, 200, 15);
        jPanel1.add(jTFNueUsuario);
        jTFNueUsuario.setBounds(20, 90, 280, 32);
        jPanel1.add(jTFNueUserName);
        jTFNueUserName.setBounds(20, 190, 280, 32);
        jPanel1.add(jTFNuePass);
        jTFNuePass.setBounds(20, 290, 280, 32);

        cmb_niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Operador", "Recepcionista" }));
        jPanel1.add(cmb_niveles);
        cmb_niveles.setBounds(360, 90, 139, 32);

        btnRegistrarNueUsuario.setText("Registrar");
        btnRegistrarNueUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarNueUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarNueUsuario);
        btnRegistrarNueUsuario.setBounds(410, 310, 110, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarNueUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarNueUsuarioActionPerformed
        int permisos_cmb, validacion = 0;
        String nombre, username, pass, idNU, permisos_string = "";
        
        nombre = jTFNueUsuario.getText().trim();
        username = jTFNueUserName.getText().trim();
        pass = jTFNuePass.getText().trim();
        permisos_cmb = cmb_niveles.getSelectedIndex() + 1;
        
        if (nombre.equals("")) {
            jTFNueUsuario.setBackground(Color.red);
            validacion++;
        }
        
        if (username.equals("")) {
            jTFNueUserName.setBackground(Color.red);
            validacion++;
        }
        
        if (pass.equals("")) {
            jTFNuePass.setBackground(Color.red);
            validacion++;
        }
        
        if (permisos_cmb == 1) {
            permisos_string = "Administrador";
        } else if (permisos_cmb == 2) {
            permisos_string = "Operador";
        } else if (permisos_cmb == 3) {
            permisos_string = "Recepcionista";
        }
        
        try {
            Connection cn = ConectorDB.conexion();
            PreparedStatement ps = cn.prepareStatement(
                    "SELECT username FROM Usuario WHERE username='"
                    + username + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                jTFNueUserName.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Nombre de usuario ya existe! \n Prueba con otro");
                cn.close();
            } else {
                cn.close();
                if (validacion == 0) {
                    try {
                        Connection cn1 = ConectorDB.conexion();
                        PreparedStatement ps1 = cn1.prepareStatement("INSERT INTO Usuario VALUES(?,?,?,?,?,?)");
                        ps1.setInt(1,0);
                        ps1.setString(2, nombre);
                        ps1.setString(3, username);
                        ps1.setString(4, pass);
                        ps1.setString(5, permisos_string);
                        ps1.setString(6, "Activo");
                        ps1.executeUpdate();
                        cn1.close();
                        clear();
                        jTFNuePass.setBackground(Color.green);
                        jTFNueUserName.setBackground(Color.green);
                        jTFNueUsuario.setBackground(Color.green);
                        JOptionPane.showMessageDialog(null, "Usuario creado exitosamente!");
                        this.dispose();
                    } catch (SQLException e) {
                        System.err.println("Erro al registrar nuevo usuario." + e);
                        JOptionPane.showMessageDialog(null, "Error al registrar usuario!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Campos incompletos!! \n Ingrese todos los datos.");
                    
                }
                
            }
        } catch (SQLException e) {
            System.err.println("Error al validar usuario" + e);
            JOptionPane.showMessageDialog(null, "Error al comparar usuario!");
        }
    }//GEN-LAST:event_btnRegistrarNueUsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarNueUsuario;
    private javax.swing.JComboBox<String> cmb_niveles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFNuePass;
    private javax.swing.JTextField jTFNueUserName;
    private javax.swing.JTextField jTFNueUsuario;
    // End of variables declaration//GEN-END:variables

    public void clear() {
        jTFNuePass.setText("");
        jTFNueUserName.setText("");
        jTFNueUsuario.setText("");
        cmb_niveles.setSelectedIndex(0);
    }
}
