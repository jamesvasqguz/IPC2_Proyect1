package UI.Recepcionista;
//Importamos las clases y las utilidades que usaremos en la actulizacion del usuario

import UI.Inicio.FromPrincipal;
import java.sql.*;
import Class.ConectorDB;
import static UI.Administrador.jFGestionarRuta.actualizarRuta;
import static UI.Administrador.jFGestionarRuta.destino;
import static UI.Administrador.jFGestionarRuta.nombreRuta;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author jara
 */
public class jFRegistrarPaquete extends javax.swing.JFrame {

//Atributos que declaramos globales para poder ser usados en los distintos metodos    
    String user;
    Connection cn = ConectorDB.conexion();
    DefaultTableModel model = new DefaultTableModel();
    String nitCliente;
    String cmb_Destino;
    float precio, peso;
    String localizacion = "";
    String estado_paquete = "";
    int prioridad_cmb;
    int tiempo = 0;
    String ruta = "";

    /**
     * Constructor
     */
    public jFRegistrarPaquete() {
        initComponents();
        setSize(1300, 550);
        setResizable(false);
        setTitle("Registrar Nuevo Paquete");
        setLocationRelativeTo(null);
        user = FromPrincipal.user;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        aggDestino();                                                           //Llamamos al metodo que nos cargan los destinos disponibles
//Creamos al inicio la tabla que cargara el paquete ya que se necesita que este antes de que se agreguen 
        tableLista = new JTable(model);
        jScrollPane1.setViewportView(tableLista);
        model.addColumn("ID Paquete");
        model.addColumn("NIT");
        model.addColumn("Peso");
        model.addColumn("Destino");
        model.addColumn("Fecha Ingreso");
        model.addColumn("Prioridad");
        model.addColumn("Estado Paquete");
        model.addColumn("Precio");
        model.addColumn("localizacion");

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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIDCliente = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        cmbPrioridad = new javax.swing.JComboBox<>();
        btnGenerarFactura = new javax.swing.JButton();
        jDFecha = new com.toedter.calendar.JDateChooser();
        cmbDestino = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLista = new javax.swing.JTable();
        btnAgregarPaquete = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel1.setText("Datos de Paquete");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(200, 20, 240, 40);

        jLabel2.setText("Ingrese el NIT del Cliente");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 90, 170, 15);

        jLabel4.setText("Ingrese el Peso del Paquete(Libras)");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 170, 230, 15);

        jLabel5.setText("Fecha y Hora de Ingreso");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 330, 170, 15);

        jLabel6.setText("Prioridad del paquete");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 410, 150, 15);

        jLabel7.setText("Seleccione Destino del Paquete");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 250, 200, 15);
        jPanel2.add(txtIDCliente);
        txtIDCliente.setBounds(30, 110, 230, 32);
        jPanel2.add(txtPeso);
        txtPeso.setBounds(30, 190, 230, 32);

        cmbPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", " " }));
        jPanel2.add(cmbPrioridad);
        cmbPrioridad.setBounds(30, 430, 70, 32);

        btnGenerarFactura.setFont(new java.awt.Font("Bitstream Vera Sans", 3, 14)); // NOI18N
        btnGenerarFactura.setText("Generar Factura");
        btnGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFacturaActionPerformed(evt);
            }
        });
        jPanel2.add(btnGenerarFactura);
        btnGenerarFactura.setBounds(720, 360, 180, 100);

        jDFecha.setDateFormatString("yyyy/MM/dd HH:mm:ss");
        jPanel2.add(jDFecha);
        jDFecha.setBounds(30, 350, 230, 32);

        jPanel2.add(cmbDestino);
        cmbDestino.setBounds(30, 270, 230, 32);

        tableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableLista);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(310, 80, 980, 210);

        btnAgregarPaquete.setFont(new java.awt.Font("Bitstream Vera Sans", 3, 14)); // NOI18N
        btnAgregarPaquete.setText("Agregar Paquete");
        btnAgregarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPaqueteActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarPaquete);
        btnAgregarPaquete.setBounds(380, 360, 190, 100);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1300, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Este boton tiene el evento de obtener todos los datos de la tabla de los paquetes del cliente y llama al metodo que genera la factura
    private void btnGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFacturaActionPerformed
        generateFac();
    }//GEN-LAST:event_btnGenerarFacturaActionPerformed
//Este boton tiene el evento de aggpaquete el cual permite crear el paquete
    private void btnAgregarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPaqueteActionPerformed
        aggPaquete();
    }//GEN-LAST:event_btnAgregarPaqueteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAgregarPaquete;
    private javax.swing.JButton btnGenerarFactura;
    private javax.swing.JComboBox<String> cmbDestino;
    private javax.swing.JComboBox<String> cmbPrioridad;
    private com.toedter.calendar.JDateChooser jDFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableLista;
    private javax.swing.JTextField txtIDCliente;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables
//Este metodo permite limpiar los campos que han sido llenados al crear un nuevo cliente    
    public void clear() {
        txtIDCliente.setEnabled(false);
        txtIDCliente.setBackground(Color.WHITE);
        txtPeso.setBackground(Color.WHITE);
        txtPeso.setText("");
        cmbDestino.setSelectedIndex(0);
        cmbPrioridad.setSelectedIndex(0);
        jDFecha.setDate(null);
    }
//Este metodo agrega el Paquete a la Cola de la Bodega para despues ser procesado por el Operario

    public void aggPaquete() {
        int validacion = 0, cantidad = 1;
        boolean prioridad_boolean = true;
        String fecha = ((JTextField) jDFecha.getDateEditor().getUiComponent()).getText();
        nitCliente = txtIDCliente.getText().trim();
        peso = Float.parseFloat(txtPeso.getText().trim());
        prioridad_cmb = cmbPrioridad.getSelectedIndex() + 1;
        cmb_Destino = cmbDestino.getSelectedItem().toString();
        estado_paquete = "No entregado";
        localizacion = "Bodega";

        if (nitCliente.equals("")) {
            txtIDCliente.setBackground(Color.red);
            validacion++;
        }
        if (prioridad_cmb == 1) {
            prioridad_boolean = true;
        } else if (prioridad_cmb == 2) {
            prioridad_boolean = false;
        }
        calcPrecio(peso);
        obtenerRuta();
        System.out.println(peso);
        System.out.println(precio);
        
            try {
                PreparedStatement ps1 = cn.prepareStatement("INSERT INTO Paquete VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
                ps1.setInt(1, 0);
                ps1.setString(2, nitCliente);
                ps1.setFloat(3, peso);
                ps1.setString(4, cmb_Destino);
                ps1.setString(5, fecha);
                ps1.setBoolean(6, prioridad_boolean);
                ps1.setString(7, estado_paquete);
                ps1.setFloat(8, precio);
                ps1.setString(9, localizacion);
                ps1.setInt(10, tiempo);
                ps1.setString(11, ruta);
                ps1.setInt(12, 0);
                ps1.executeUpdate();
                txtIDCliente.setBackground(Color.green);
                txtPeso.setBackground(Color.green);
                JOptionPane.showMessageDialog(null, "Paquete ingresado exitosamente!");
                tabla(fecha);
                clear();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "El NIT ingresado no existe!! \n Cree el cliente");
                compareNIT();
                this.dispose();
            }
    }
//Este metodo compara si el nit ingresado por el cliente existe y si no existe llama a la venta registrar cliente la cual permite la creacion de un nuevo cliente

    public void compareNIT() {
        try {
            PreparedStatement ps1 = cn.prepareStatement("SELECT nit_cliente FROM Clientes WHERE nit_cliente ='" + nitCliente + "'");
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
            } else {
                jFRegistrarCliente rg = new jFRegistrarCliente();
                rg.setVisible(true);
            }
        } catch (SQLException e) {
            System.err.println("Error al crear cliente en paquete " + e);
        }
    }
//Este metodo obtiene los destinos posibles de la ruta y los inserta en un ArrayList para luego ser agregado al ComboBox del destino

    public void aggDestino() {
        ArrayList<String> list = new ArrayList<String>();

        try {
            PreparedStatement ps2 = cn.prepareStatement("SELECT destino FROM Rutas WHERE estado_ruta='Activo'");
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                list.add(rs2.getString("destino"));
            }
            for (int i = 0; i < list.size(); i++) {
                cmbDestino.addItem(list.get(i));
            }
        } catch (SQLException e) {
            System.err.println("Error en el array " + e);
        }
    }
//Este metodo llena la tabla que servira como base para convertirla en pdf, "Crea como sera la factura".

    public void tabla(String fecha) {
        try {
            PreparedStatement ps2 = cn.prepareStatement("SELECT id_paquete, nit_cliente, peso, destino, fecha_ingreso, prioridad, estado_paquete, precio, localizacion FROM Paquete WHERE fecha_ingreso='" + fecha + "'");
            ResultSet rs2 = ps2.executeQuery();

            if (rs2.next()) {
                Object[] row = new Object[9];
                row[0] = rs2.getInt("id_paquete");
                row[1] = rs2.getString("nit_cliente");
                row[2] = rs2.getFloat("peso");
                row[3] = rs2.getString("destino");
                row[4] = rs2.getString("fecha_ingreso");
                row[5] = rs2.getBoolean("prioridad");
                row[6] = rs2.getString("estado_paquete");
                row[7] = rs2.getFloat("precio");
                row[8] = rs2.getString("localizacion");
                model.addRow(row);
            }
        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla " + e);
        }
    }
//Este metodo calcula el precio y lo actualiza si es que ya fue procesado por algun operario

    public void calcPrecio(float peso) {
        float precioL = 0, precioD = 0, precioP = 0;
        try {
            PreparedStatement ps = cn.prepareStatement("SELECT precio_libra, precio_destino, precio_prioridad FROM Rutas WHERE destino='" + cmb_Destino + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                precioL = rs.getFloat("precio_libra");
                precioD = rs.getFloat("precio_destino");
                if (prioridad_cmb == 1) {
                    precioP = rs.getInt("precio_prioridad");
                } else if (prioridad_cmb == 2) {
                    precioP = 0;
                }
                System.out.println("Destino " + precioD + " Libra" + precioL + " Prioridad " + precioP);

            } else {
                System.out.println("No Entre!");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el precio por libra " + e);
        }
        precio = (precioL * peso) + precioD + precioP;
    }
//Este metodo genera la factura de los paquetes que haya ingresado el cliente y los exporta como pdf a la direccion que se le asigna

    public void generateFac() {
        Document documento = new Document();
        String fechaf = ((JTextField) jDFecha.getDateEditor().getUiComponent()).getText();              //Guardamos en una variable tipo String la fecha que ingreso    
        try {
            String root = System.getProperty("user.home");                                              //Guardamos en una variable tipo String el usuario que usara el documento para guardarlo
            PdfWriter.getInstance(documento, new FileOutputStream(root + "/Desktop/IPC2_Proyect1/" + nitCliente + "_factura.pdf"));             //Abrimos un canal de salida para documento con la direccion a la cual debe de guardarse
            documento.open();
            PdfPTable table = new PdfPTable(7);
            table.addCell("ID Paquete");
            table.addCell("NIT Cliente");
            table.addCell("Peso");
            table.addCell("Destino");
            table.addCell("Fecha Ingreso");
            table.addCell("Prioridad");
            table.addCell("Precio");
            try {
                PreparedStatement ps = cn.prepareStatement("SELECT id_paquete, nit_cliente, peso, destino, fecha_ingreso, prioridad, precio FROM Paquete WHERE nit_cliente='" + txtIDCliente.getText() + "'");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    do {
                        table.addCell(rs.getString(1));
                        table.addCell(rs.getString(2));
                        table.addCell(rs.getString(3));
                        table.addCell(rs.getString(4));
                        table.addCell(rs.getString(5));
                        table.addCell(rs.getString(6));
                        table.addCell(rs.getString(7));
                    } while (rs.next());
                    documento.add(table);
                }
            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Factura creada con exito!");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
    }
//Este metodo guarda en una variable la seleccion de ComboBox de Destino    

    public void obtenerRuta() {
        try {
            PreparedStatement ps3 = cn.prepareStatement("SELECT nombre_ruta FROM Rutas WHERE destino ='" + cmb_Destino + "'");
            ResultSet rs3 = ps3.executeQuery();
            if (rs3.next()) {
                ruta = rs3.getString("nombre_ruta");
            }
        } catch (SQLException e) {
            System.err.println("Error al jalar la ruta " + e);
        }
    }
}
