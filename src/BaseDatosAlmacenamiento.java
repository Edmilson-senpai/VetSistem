
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class BaseDatosAlmacenamiento extends javax.swing.JFrame {
    
    //icono de jframe
    @Override
    public Image getIconImage(){
                                                                         //nos permite cargar cargar recursos de nuestro poryecto
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconsRun/alb.png"));
        return retValue;
    }
    
    DecimalFormat formato = new DecimalFormat("#.00");
    private String estado = "abajo";
    private String orden = "asc";
    private String pro;
    public static String codProSelect;
    private float pcu;
    private int cantidadPro;

    public static void Abajo(JComponent componente, int milisegundos, int saltos, int parar) {
        (new Thread() {
            @Override
            public void run() {
                for (int i = componente.getHeight(); i <= parar; i += saltos) {
                    try {
                        Thread.sleep(milisegundos);
                        componente.setPreferredSize(new Dimension(componente.getWidth(), i));
                        SwingUtilities.updateComponentTreeUI(componente);
                    } catch (InterruptedException e) {
                        System.out.println("Error Thread Interrumpido: " + e);
                    }
                }
            }
        }).start();
    }

    public static void Arriba(JComponent componente, int milisegundos, int saltos, int parar) {
        (new Thread() {
            @Override
            public void run() {
                for (int i = componente.getHeight(); i >= parar; i -= saltos) {
                    try {
                        Thread.sleep(milisegundos);
                        componente.setPreferredSize(new Dimension(componente.getWidth(), i));
                        SwingUtilities.updateComponentTreeUI(componente);
                    } catch (InterruptedException e) {
                        System.out.println("Error Thread Interrumpido: " + e);
                    }
                }
            }
        }).start();
    }

    DefaultTableModel tabla = new DefaultTableModel();
    static Connection con = null;
    static Statement stmt = null;
    static ResultSet rs = null;

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
            stmt = BaseDatosAlmacenamiento.conectar().createStatement();

            String consulta = "SELECT P.COD_PRODUCTO,P.COD_PROVE,P.COD_ALMACEN,P.NOM_PRODUCTO,"
                    + "P.CANTIDAD_PRODUCTO,P.PRECIOUNI_PRODUCTO "
                    + "FROM TB_PRODUCTO P INNER JOIN TB_DETALLE_PRODUCTO DP "
                    + "ON P.COD_PRODUCTO = DP.COD_PRODUCTO";

            rs = stmt.executeQuery(consulta);

            while (rs.next()) {
                Object fila[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), formato.format(Float.parseFloat(rs.getString(6)))};
                tabla.addRow(fila);
            }

            for (int i = 0; i < tabla.getRowCount(); i++) {
                int stk = Integer.parseInt(tabla.getValueAt(i, 4).toString());

                if (stk < 10) {
                    jTable1.setBackground(Color.red);
                }
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
  
    colorCelda cr = new colorCelda();

    public BaseDatosAlmacenamiento() {
        initComponents();
        //jSpinner1.getEditor().getComponent(0).setBackground(Color.yellow);
        jTable1.setDefaultRenderer(Object.class, cr);
        //jTable1.setDefaultRenderer(jTable1.getColumnClass(0), cr);
        //jTable1.getColumnModel().getColumn(4).setCellRenderer(new colorCelda());
        jTable1.setModel(tabla);
        tabla.addColumn("Cod. Producto");
        tabla.addColumn("Cod. Proveedor");
        tabla.addColumn("Cod. Almacen");
        tabla.addColumn("Nom. Producto");
        tabla.addColumn("Cant. Producto");
        tabla.addColumn("Precio C/U");
        consultaData();
        jLabel1.setText(String.valueOf(jSlider1.getValue()));
        setIconImage(getIconImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new imagenFondoPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(354, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsProducto/hogar (1).png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setPreferredSize(new java.awt.Dimension(65, 40));
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsProducto/hogar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsProducto/mas-informacion (1).png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.setPreferredSize(new java.awt.Dimension(65, 40));
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsProducto/mas-informacion.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsProducto/asce.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        jCheckBox1.setText("Productos estandar");
        jCheckBox1.setContentAreaFilled(false);
        jCheckBox1.setFocusable(false);
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 10)); // NOI18N
        jCheckBox2.setText("Productos medicos");
        jCheckBox2.setFocusable(false);
        jCheckBox2.setOpaque(false);
        jCheckBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox2MouseClicked(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsProducto/carrito-de-compras.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.setPreferredSize(new java.awt.Dimension(65, 40));
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsProducto/carrito-de-compras (1).png"))); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsProducto/comprar.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setPreferredSize(new java.awt.Dimension(65, 40));
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsProducto/comprarrr.png"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSlider1.setBackground(new java.awt.Color(255, 51, 51));
        jSlider1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jSlider1.setForeground(new java.awt.Color(0, 0, 0));
        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(150);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(1);
        jSlider1.setFocusable(false);
        jSlider1.setOpaque(false);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 8)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox2)))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 0));

        jPanel6.setOpaque(false);

        jTable1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionForeground(java.awt.SystemColor.control);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTable1MouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -60, 750, 270));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //ordenar de mayor a menor
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ("asc".equals(orden)) {
            jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsProducto/asce.png")));
            orden = "desc";
            limpiaTabla(tabla);
            try {
                stmt = BaseDatosAlmacenamiento.conectar().createStatement();
                String consulta = "SELECT P.COD_PRODUCTO,P.COD_PROVE,P.COD_ALMACEN,P.NOM_PRODUCTO,P.CANTIDAD_PRODUCTO,P.PRECIOUNI_PRODUCTO\n"
                        + " FROM TB_PRODUCTO P WITH (INDEX(IDX_ASCEN)) INNER JOIN TB_DETALLE_PRODUCTO DP ON P.COD_PRODUCTO = DP.COD_PRODUCTO";
                rs = stmt.executeQuery(consulta);
                while (rs.next()) {
                    Object fila[] = {rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)};
                    tabla.addRow(fila);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsProducto/desc.png")));
            orden = "asc";
            limpiaTabla(tabla);
            try {
                stmt = BaseDatosAlmacenamiento.conectar().createStatement();
                String consulta = "SELECT P.COD_PRODUCTO,P.COD_PROVE,P.COD_ALMACEN,P.NOM_PRODUCTO,P.CANTIDAD_PRODUCTO,P.PRECIOUNI_PRODUCTO\n"
                        + " FROM TB_PRODUCTO P WITH (INDEX(IDX_DESCEN)) INNER JOIN TB_DETALLE_PRODUCTO DP ON P.COD_PRODUCTO = DP.COD_PRODUCTO";
                rs = stmt.executeQuery(consulta);
                while (rs.next()) {
                    Object fila[] = {rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)};
                    tabla.addRow(fila);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //volver al principal
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Principal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
  
    //usar
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int cantidadUsada = Integer.parseInt(String.valueOf(jSlider1.getValue()));
        
        int ventanaYesNotCancel = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO QUE DESEA USAR " + cantidadUsada + " " + pro + "?", "INFORMACION", JOptionPane.YES_NO_OPTION, 3);
        //0=yes, 1=no, 2=cancel
        switch (ventanaYesNotCancel) {
            case 0:
                   if(cantidadUsada>cantidadPro){
                        JOptionPane.showMessageDialog(null, "EL STOCK ACTUAL ES MENOR AL QUE QUIERE MANDAR A USAR, LE RECOMENDAMOS QUE COMPRE MAS PRODUCTOS "+pro , "ERROR", 0);       
                   }else{
                       try {
                            stmt = BaseDatosAlmacenamiento.conectar().createStatement();
                            String consulta = "EXEC SP_RestarExistencia '" + codProSelect + "'," + cantidadUsada + "";
                            stmt.execute(consulta);
                            JOptionPane.showMessageDialog(null, cantidadUsada + " " + pro + " mandado(s) a usar", "USO", 2);
                            limpiaTabla(tabla);
                            metodosCheck(); 
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }
                   }
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "OPERACION CANCELADA", "CANCELADO", 0);
                break;
            default:
                break;
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    //info del producto mas detallado
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new DetalleProducto().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int filaSelec = jTable1.getSelectedRow();
        codProSelect = (String) jTable1.getValueAt(filaSelec, 0);
        pro = (String) jTable1.getValueAt(filaSelec, 3);
        pcu = Float.parseFloat(jTable1.getValueAt(filaSelec, 5).toString());
        pcu = Float.parseFloat(formato.format(pcu));
        
        cantidadPro = Integer.parseInt((String) jTable1.getValueAt(filaSelec, 4));
        //System.out.print(formato.format(pcu));
        //System.out.print(cantidadPro);
    }//GEN-LAST:event_jTable1MouseClicked

    void metodosCheck() {
        if (jCheckBox1.isSelected() && jCheckBox2.isSelected()) {
            limpiaTabla(tabla);
            consultaData();
        } else if (jCheckBox2.isSelected()) {
            limpiaTabla(tabla);
            try {
                stmt = BaseDatosAlmacenamiento.conectar().createStatement();

                String consulta = "SELECT P.COD_PRODUCTO,P.COD_PROVE,P.COD_ALMACEN,P.NOM_PRODUCTO,"
                        + "P.CANTIDAD_PRODUCTO,P.PRECIOUNI_PRODUCTO FROM TB_PRODUCTO P INNER JOIN TB_DETALLE_PRODUCTO DP "
                        + "ON P.COD_PRODUCTO = DP.COD_PRODUCTO WHERE COD_ALMACEN='AL01'";
                rs = stmt.executeQuery(consulta);

                while (rs.next()) {
                    Object fila[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), formato.format(Float.parseFloat(rs.getString(6)))};
                    tabla.addRow(fila);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (jCheckBox1.isSelected()) {
            limpiaTabla(tabla);
            try {
                stmt = BaseDatosAlmacenamiento.conectar().createStatement();

                String consulta = "SELECT P.COD_PRODUCTO,P.COD_PROVE,P.COD_ALMACEN,P.NOM_PRODUCTO,"
                        + "P.CANTIDAD_PRODUCTO,P.PRECIOUNI_PRODUCTO FROM TB_PRODUCTO P INNER JOIN TB_DETALLE_PRODUCTO DP "
                        + "ON P.COD_PRODUCTO = DP.COD_PRODUCTO WHERE COD_ALMACEN='AL02'";
                rs = stmt.executeQuery(consulta);

                while (rs.next()) {
                    Object fila[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), formato.format(Float.parseFloat(rs.getString(6)))};
                    tabla.addRow(fila);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            limpiaTabla(tabla);
            consultaData();
        }
    }


    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        metodosCheck();
    }//GEN-LAST:event_jCheckBox1MouseClicked

    private void jCheckBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox2MouseClicked
        metodosCheck();
    }//GEN-LAST:event_jCheckBox2MouseClicked

    //comprar mas stock
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        float pagoNeto;
        int cantidadCompra = Integer.parseInt(String.valueOf(jSlider1.getValue()));
        pagoNeto = pcu * cantidadCompra;
        int ventanaYesNotCancel = JOptionPane.showConfirmDialog(null, "TOTAL A PAGAR POR " + cantidadCompra + " " + pro + " es de: S/." + pagoNeto, "INFORMACION", JOptionPane.YES_NO_OPTION, 3);
        //0=yes, 1=no, 2=cancel
        switch (ventanaYesNotCancel) {
            case 0:
                    try {
                stmt = BaseDatosAlmacenamiento.conectar().createStatement();
                String consulta = "EXEC SP_SumarExistencia '" + codProSelect + "'," + cantidadCompra + "";
                stmt.execute(consulta);
                JOptionPane.showMessageDialog(null, "ESPERE A LA ENTREGA DEL PROVEEDOR POR EL PRODUCTO " + pro, "ESPERA", 2);
                JOptionPane.showMessageDialog(null, "STOCK AUMENTADO PARA EL PRODUCTO " + pro, pro, 1);
                limpiaTabla(tabla);
                metodosCheck(); 
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            break;
            case 1:
                JOptionPane.showMessageDialog(null, "OPERACION CANCELADA", "CANCELADO", 0);
                break;
            default:
                break;
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        if (!"abajo".equals(estado)) {
            Arriba(jPanel3, 10, 4, 0);
            estado = "abajo";
        }
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTable1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseExited
        if ("abajo".equals(estado)) {
            Abajo(jPanel3, 10, 4, 60);
            estado = "arriba";
        }
    }//GEN-LAST:event_jTable1MouseExited

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        jLabel1.setText(String.valueOf(jSlider1.getValue()));
    }//GEN-LAST:event_jSlider1StateChanged

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        jLabel2.setText("COMPRAR");
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        jLabel2.setText("");
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jLabel2.setText("USAR");
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jLabel2.setText("");
    }//GEN-LAST:event_jButton3MouseExited

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaseDatosAlmacenamiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    class imagenFondoPanel extends JPanel {

        private Image imagen;

        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("fondos/cds.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);//para que la imagen no sea transparente
            super.paint(g);
        }
    }
}
