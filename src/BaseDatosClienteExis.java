
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class BaseDatosClienteExis extends javax.swing.JFrame {

    public static int confirmar;
    public int filaSelec;
    public static String dniCliSe;

    public Object select[] = new Object[2];
    DefaultTableModel tabla = new DefaultTableModel();
    static Connection con = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    void estiloTable() {
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 11));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(255, 154, 94));
        jTable1.getTableHeader().setForeground(new Color(255, 255, 255));
        
        jScrollPane1.getVerticalScrollBar().setBackground(Color.GREEN);
        
    }
   
    //metodos
    public static Connection conectar() {
        String conexionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=VETERINARIA3;"
                + "user=UTPdaniel;"
                + "password=8061;"
                + "logingTimeout=10";
        try {
            con = DriverManager.getConnection(conexionUrl);
            return con;
        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, exc);
            return null;
        }
    }

    public void consultaData() {
        try {
            stmt = BaseDatosCliente.conectar().createStatement();
            //aca especificamos la tabla a la que queremos ir
            String consulta = "SELECT*FROM TB_CLIENTE";
            rs = stmt.executeQuery(consulta);//ESCRITURA exevuteQuery

            while (rs.next()) {
                //aca tener cuidado con la cantidad de columnas de nuestra tabla sql
                Object fila[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7)};
                tabla.addRow(fila);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void limpiaTabla(final DefaultTableModel tabla) {
        for (int i = tabla.getRowCount() - 1; i >= 0; i--) {
            tabla.removeRow(i);
        }
    }

    public BaseDatosClienteExis() {

        initComponents();
        jTable1.setModel(tabla);
        estiloTable();
        tabla.addColumn("DNI cliente");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido Paterno");
        tabla.addColumn("Apellido Materno");
        tabla.addColumn("Num. Celular");
        tabla.addColumn("Email");
        tabla.addColumn("Direc. Cliente");

        //conectar();
        consultaData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new  imagenFondoPanel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/base-de-datos.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/entregabdnor.png"))); // NOI18N
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/entregabdpren.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 85, 20, 20));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/buscar32.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/buscar32.png"))); // NOI18N
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/buscar32Pren.png"))); // NOI18N
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 80, 50));

        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 153, 102));
        jScrollPane1.setFocusable(false);
        jScrollPane1.setOpaque(false);

        jTable1.setBackground(new java.awt.Color(255, 196, 101));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setOpaque(false);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 204));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.setShowGrid(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 650, 70));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/comprobado.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setOpaque(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/comprobadoPren.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setText("BUSCAR");
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setText("");
    }//GEN-LAST:event_jButton4MouseExited

    //PARA BUSCAR
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String cadenaBuscadora = null;

        String b1 = JOptionPane.showInputDialog(null, "<html>Ingrese el <font color=#FF0000>DNI DEL CLIENTE</font> a buscar:</html> ", "BUSCAR CLIENTE", 3);
        cadenaBuscadora = "DNI_CLIENTE='" + b1 + "'";

        System.out.println(cadenaBuscadora);

        if (!"DNI_CLIENTE=''".equals(cadenaBuscadora) && b1 != null) {
            limpiaTabla(tabla);
            try {
                stmt = BaseDatosCliente.conectar().createStatement();
                String consulta = "SELECT * FROM TB_CLIENTE WHERE " + cadenaBuscadora + "";

                System.out.println(consulta);
                rs = stmt.executeQuery(consulta);
                while (rs.next()) {
                    Object fila[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7)};
                    tabla.addRow(fila);
                }
                if (jTable1.getRowCount() == 0) {
                    JOptionPane.showInternalMessageDialog(null, "NOT FOUND", "respuesta", 2);
                    consultaData();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if ("".equals(b1)) {
            JOptionPane.showInternalMessageDialog(null, "BAD REQUEST", "respuesta", 0);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limpiaTabla(tabla);
        consultaData();
        select[0] = null;

    }//GEN-LAST:event_jButton5ActionPerformed


    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        filaSelec = jTable1.getSelectedRow();

        select[0] = jTable1.getValueAt(filaSelec, 0);
        select[1] = jTable1.getValueAt(filaSelec, 1);


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (select[0] != null && select[1] != null) {
            confirmar = JOptionPane.showConfirmDialog(null, "<html><center>¿ESTA SEGURO QUE DESEA UNA NUEVA<br>"
                    + "SOLICITUD PARA EL CLIENTE: <font color=#ff0000>" + select[1] + "</font> <br>"
                    + "IDENTIFICADO CON DNI:<font color=#ff0000>" + select[0] + "</font>?</center></html>",
                    "PRECAUCION", JOptionPane.YES_NO_CANCEL_OPTION, 3);

            switch (confirmar) {
                case 0:
                    dniCliSe = String.valueOf(select[0]);
                    this.dispose();
                    JOptionPane.showInternalMessageDialog(null, "PRECIONE F5", "REFRESCAR", 1);
                    break;
                case 1:
                    dniCliSe = null;
                    JOptionPane.showInternalMessageDialog(null, "PROCESO CANCELADO", "RESPUESTA", 0);
                    break;
                default:
                    this.dispose();
                    JOptionPane.showInternalMessageDialog(null, "NADA POR RECUPERAR", "INFORMACION", 2);
                    break;
            }
        }else{
            JOptionPane.showInternalMessageDialog(null, "SELECCIONE A UN CLIENTE", "ERROR", 0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaseDatosClienteExis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

//Clases para fondo ajustado automatico
    //jframe
    class imagenFondoPanel extends JPanel {

        private Image imagen;

        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("fondos/dena.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);//para que la imagen no sea transparente
            super.paint(g);
        }
    }
}
