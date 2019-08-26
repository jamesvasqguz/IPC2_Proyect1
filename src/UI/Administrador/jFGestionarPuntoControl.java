package UI.Administrador;
//Importamos las clases y las utilidades que usaremos en la actulizacion del usuario

import UI.Administrador.jFActualizarPunto;
import Class.ConectorDB;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jara
 */
public class jFGestionarPuntoControl extends javax.swing.JFrame {

//Atributos que declaramos globales para poder ser usados en los distintos metodos
    String user;
    public static String actualizarPunto = "";
    public static int idRuta;
    public static int idUsuario;
    public static int idPunto;
    DefaultTableModel model = new DefaultTableModel();
    Connection cn = ConectorDB.conexion();

    /**
     * Creates new form jFGestionarPuntoControl
     */
    public jFGestionarPuntoControl() {
        initComponents();
        setSize(750,500);
        setResizable(false);
        setTitle("Gestionar Punto de Control");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        llenarPuntos();                                                         //Llamamos al metodo que llena la tabla de los PC
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePunto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(650, 500));
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 3, 24)); // NOI18N
        jLabel1.setText("Puntos de Control");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(170, 20, 310, 40);

        tablePunto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablePunto);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(10, 70, 730, 190);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 750, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablePunto;
    // End of variables declaration//GEN-END:variables
//Este metodo llena la tabla con la imformacion de los Puntos Control
    public void llenarPuntos() {
        try {
            PreparedStatement ps = cn.prepareStatement(
                    "SELECT id_punto, id_rutas, id_usuario, estado_punto, nombre_punto, tarifa, size FROM PuntoControl");
            ResultSet rs = ps.executeQuery();
            tablePunto = new JTable(model);
            jScrollPane2.setViewportView(tablePunto);
            model.addColumn("ID Punto Control");
            model.addColumn("ID de la Ruta");
            model.addColumn("ID del Operador");
            model.addColumn("Estado");
            model.addColumn("Nombre del Punto");
            model.addColumn("Tarifa");
            model.addColumn("Capacidad");
            while (rs.next()) {
                Object[] ob = new Object[7];
                for (int i = 0; i < ob.length; i++) {
                    ob[i] = rs.getObject(i + 1);
                }
                model.addRow(ob);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al rellenar la tabla");
            JOptionPane.showMessageDialog(null, "Error en la conexion DB con la Tabla");
        }
//Este evento hace que al darle click envie al admin a actualizar los datos del PC
        tablePunto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tablePunto.rowAtPoint(e.getPoint());
                
                if (fila_point > -1) {
                    actualizarPunto = (String)model.getValueAt(fila_point,4);
                    idRuta = (int)model.getValueAt(fila_point,1);
                    idUsuario = (int)model.getValueAt(fila_point,2);
                    idPunto = (int)model.getValueAt(fila_point,0);
                    jFActualizarPunto ap = new jFActualizarPunto();
                    ap.setVisible(true);
                }
            }
        });
    }
}
