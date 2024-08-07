
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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

public class BaseDatosCliente extends javax.swing.JFrame {

    
    public int filaSelec;
    public static String dniCliSe;
    public static String dniEmSe;
    public static String solSe;
    public static String codMasSe;
    public static String codSerSe;
    public static String nomSerSe;

    public Object select[] = new Object[7];
    DefaultTableModel tabla = new DefaultTableModel();
    static Connection con = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    
    //icono de jframe
    @Override
    public Image getIconImage(){
                                                                         //nos permite cargar cargar recursos de nuestro poryecto
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconsRun/bdr.png"));
        return retValue;
    }
    
    //estilo de la tabla
    void estiloTable() {
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(32, 136, 203));
        jTable1.getTableHeader().setForeground(new Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setBackground(new Color(204,252,234));
        jScrollPane1.getVerticalScrollBar().setForeground(new Color(204,252,234));
        
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
            String consulta = "SELECT \n"
                    + "S.COD_SOLICITUD,S.FECHA_SOLICITUD,C.NOM_CLIENTE, C.DNI_CLIENTE,\n"
                    + "C.NUMCEL_CLIENTE,C.DIREC_CLIENTE,S.COD_SERVICIO, SE.NOM_SERVICIO,\n"
                    + "E.NOM_EMPLEADO,E.DNI_EMPLEADO,E.NUMCEL_EMPLEADO,M.COD_MASCOTA,M.NOM_MASCOTA \n"
                    + "FROM TB_CLIENTE C INNER JOIN TB_SOLICITUD S ON S.DNI_CLIENTE = C.DNI_CLIENTE\n"
                    + "				  INNER JOIN TB_EMPLEADO E ON E.DNI_EMPLEADO =S.DNI_EMPLEADO\n"
                    + "				  INNER JOIN TB_SERVICIO SE ON SE.COD_SERVICIO = S.COD_SERVICIO"
                    + "                           INNER JOIN TB_MASCOTA M ON M.COD_MASCOTA = S.COD_MASCOTA";
            rs = stmt.executeQuery(consulta);//ESCRITURA exevuteQuery

            while (rs.next()) {
                //aca tener cuidado con la cantidad de columnas de nuestra tabla sql
                Object fila[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                    rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)};
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

    public BaseDatosCliente() {

        initComponents();
        jTable1.setModel(tabla);
        estiloTable();
        tabla.addColumn("Cod. solicitud");
        tabla.addColumn("Fecha");
        tabla.addColumn("Nom. Cliente");
        tabla.addColumn("DNI cliente");
        tabla.addColumn("Num. Celular");
        tabla.addColumn("Direc. Cliente");
        tabla.addColumn("Cod. Servicio");
        tabla.addColumn("Nom. Servicio");
        tabla.addColumn("Nom. Empleado");
        tabla.addColumn("DNI empleado");
        tabla.addColumn("Num. Celular");
        tabla.addColumn("Cod. Mascota");
        tabla.addColumn("Nom. Mascota");

        //conectar();
        consultaData();
        setIconImage(getIconImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new  imagenFondoPanel();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 20, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/eliminar32.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/eliminar32.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/borrar32Pren.png"))); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 80, 50));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/actualizar32.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/actualizar32.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/actualizar32Pren.png"))); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 80, 50));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
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
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 80, 50));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/informacion16.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/Imagen6.png"))); // NOI18N
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/Imagen4.png"))); // NOI18N
        jButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/Imagen6.png"))); // NOI18N
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, -1));

        jScrollPane1.setFocusable(false);
        jScrollPane1.setOpaque(false);

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13"
            }
        ));
        jTable1.setAutoscrolls(false);
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(102, 204, 0));
        jTable1.setOpaque(false);
        jTable1.setSelectionBackground(new java.awt.Color(102, 255, 102));
        jTable1.setSelectionForeground(new java.awt.Color(255, 0, 0));
        jTable1.setShowGrid(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 1160, 170));

        jMenuBar1.setBackground(new java.awt.Color(0, 204, 204));
        jMenuBar1.setBorder(null);
        jMenuBar1.setBorderPainted(false);

        jMenu1.setText("volver");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu1MouseExited(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("|");
        jMenu2.setContentAreaFilled(false);
        jMenu2.setEnabled(false);
        jMenu2.setFocusable(false);
        jMenuBar1.add(jMenu2);

        jMenu3.setText("registrar");
        jMenu3.setFocusable(false);
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu3MouseExited(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("|");
        jMenu4.setContentAreaFilled(false);
        jMenu4.setEnabled(false);
        jMenu4.setFocusable(false);
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //AZTUALIZAR
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ActualizarCli acli = new ActualizarCli();
        acli.setVisible(true);
        // this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String msg = "";
        //control de excepciones: por si no se ingresa nada 
        try {
            msg = JOptionPane.showInputDialog(null,
                    "<html> 1: para obtener informacion de como actualizar la data.<br>"
                    + "2: para obtener informacion de como eliminar la data.<br>"
                    + "3: para obtener informacion de como buscar data.</html>", "INGRESE", 1
            );

            switch (msg) {
                case "1":
                    JOptionPane.showMessageDialog(null, "<html>1: Seleccione la fila que desea modificar.<br>2: Le aparecera una "
                            + "ventana con toda la información de la fila selecionada.<br>3: Podra modificar la mayoria de los campos.<br>4: No podra modificar el campo DNI <font color=#FF0000>(SE RECOMIENDA ELIMINAR).</font></html>", "COMO ACTUALIZAR", 1);
                    break;

                case "2":
                    JOptionPane.showMessageDialog(null, "<html>1: Seleccione la fila que desea eliminar.<br>2: Le aparecera una "
                            + "ventana de confirmación con la data seleccionada.<br>3: <font color=#FF0000> UNA VEZ ELIMINADO NO SE PODRA RECUPERAR.</font></html>", "COMO ELIMINAR", 1);
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "<html>1: Presione el icono de la lupa.<br>2: Le aparecera una "
                            + "ventana.<br>3: Debera ingresar la modalidad de busqueda.<br>4: Ingresa la data a buscar <font color=#FF0000>en base a la modalidad que elegiste.</font></html>", "COMO BUSCAR", 1);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "INGRESO INVALIDO", "ERROR", 0);
                    break;
            }
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "NADA POR CONSULTAR", "ERROR", 1);
            System.out.print(msg);
        }
        //el msg recuperara el valor ingresado de tipo string,
    }//GEN-LAST:event_jButton3ActionPerformed

    //BOTON DE ELIMINAR
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (select[1] != null) {
            int confirmar = JOptionPane.showConfirmDialog(null, "<html>¿ESTA SEGURO QUE DESEA ELIMINAR <br>"
                    + "LA SOLICITUD: <font color=#ff0000>" + select[0] + "</font>,"
                    + " DEL CLIENTE: <font color=#ff0000>" + select[1] + "</font> <br>"
                    + "IDENTIFICADO CON DNI:<font color=#ff0000>" + select[2] + "</font>?</html>",
                    "PRECAUCION", JOptionPane.YES_NO_OPTION, 3);

            if (confirmar == 0) {
                //DELETE FROM TB_SOLICITUD WHERE COD_SOLICITUD ='4'
                String ing = "DELETE FROM TB_SOLICITUD WHERE COD_SOLICITUD ='" + select[0] + "'";
                PreparedStatement pre = null;
                try {
                    pre = con.prepareStatement(ing);
                    pre.executeUpdate();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                limpiaTabla(tabla);
                consultaData();
            }

        } else {
            JOptionPane.showMessageDialog(null, "NO HAY FILA SELECCIONADA", "ERROR", 0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setText("actualizar");
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setText("");
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setText("buscar");
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setText("");
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setText("eliminar");
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setText("");
    }//GEN-LAST:event_jButton2MouseExited

    //PARA BUSCAR
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        boolean bd = false, pass = false;
        String b1 = null;
        String b2 = null;
        String b3 = null;
        String b4 = null;
        String msg;
        String cadenaBuscadora = null;

        while (bd == false) {

            msg = JOptionPane.showInputDialog(null,
                    "<html>"
                    + "1: PARA BUSCAR EN BASE Al DNI DEL CLIENTE.<br>"
                    + "2: PARA BUSCAR EN BASE AL CODIGO DE LA SOLICITUD.<br>"
                    + "3: PARA BUSCAR EN BASE AL CODIGO DEL SERVICIO.<br>"
                    + "4: PARA BUSCAR EN BASE AL DNI DEL EMPLEADO.<br>"
                    + "</html>",
                    "BUSCAR", 1
            );

            if (msg != null) {
                switch (msg) {
                    case "1":
                        b1 = JOptionPane.showInputDialog(null, "<html>Ingrese el <font color=#FF0000>DNI DEL CLIENTE</font> a buscar:</html> ", "BUSCAR CLIENTE", 3);
                        cadenaBuscadora = "C.DNI_CLIENTE='" + b1 + "'";
                        break;
                    case "2":
                        b2 = JOptionPane.showInputDialog(null, "<html>Ingrese el <font color=#FF0000>CODIGO DE LA SOLICITUD </font> a buscar:</html>", "BUSCAR SOLICITUD", 3);
                        cadenaBuscadora = "S.COD_SOLICITUD='" + b2 + "'";
                        break;
                    case "3":
                        b3 = JOptionPane.showInputDialog(null, "<html>Ingrese el <font color=#FF0000>CODIGO DEL SERVICIO</font> a buscar:</html>", "BUSCAR SERVICIO", 3);
                        cadenaBuscadora = "SE.COD_SERVICIO='" + b3 + "'";
                        break;
                    case "4":
                        b4 = JOptionPane.showInputDialog(null, "<html>Ingrese el <font color=#FF0000>DNI DEL EMPLEADO</font> a buscar:</html>", "BUSCAR EMPLEADO", 3);
                        cadenaBuscadora = "E.DNI_EMPLEADO='" + b4 + "'";
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "INGRESO INVALIDO", "ERROR", 0);
                        break;
                }
                if (b1 != null || b2 != null || b3 != null || b4 != null) {
                    bd = true;
                    pass = true;
                } else {
                    bd = false;
                }
            } else {
                bd = true;
            }
        }

        System.out.println(cadenaBuscadora);

        if (cadenaBuscadora != null && pass == true) {
            limpiaTabla(tabla);
            try {
                stmt = BaseDatosCliente.conectar().createStatement();
                String consulta = "SELECT \n"
                        + "S.COD_SOLICITUD,S.FECHA_SOLICITUD,C.NOM_CLIENTE, C.DNI_CLIENTE,\n"
                        + "C.NUMCEL_CLIENTE,C.DIREC_CLIENTE,S.COD_SERVICIO, SE.NOM_SERVICIO,\n"
                        + "E.NOM_EMPLEADO,E.DNI_EMPLEADO,E.NUMCEL_EMPLEADO,M.COD_MASCOTA,M.NOM_MASCOTA \n"
                        + "FROM TB_CLIENTE C INNER JOIN TB_SOLICITUD S ON S.DNI_CLIENTE = C.DNI_CLIENTE\n"
                        + "				  INNER JOIN TB_EMPLEADO E ON E.DNI_EMPLEADO =S.DNI_EMPLEADO\n"
                        + "				  INNER JOIN TB_SERVICIO SE ON SE.COD_SERVICIO = S.COD_SERVICIO\n"
                        + "                               INNER JOIN TB_MASCOTA M ON M.COD_MASCOTA = S.COD_MASCOTA "
                        + "				  WHERE " + cadenaBuscadora + "";

                System.out.println(consulta);
                rs = stmt.executeQuery(consulta);
                while (rs.next()) {

                    Object fila[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13)};
                    tabla.addRow(fila);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        Cliente cli = new Cliente();
        cli.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        RegistroCli rcli = new RegistroCli();
        rcli.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseEntered
        jMenu3.setForeground(new java.awt.Color(255, 51, 51));
    }//GEN-LAST:event_jMenu3MouseEntered

    private void jMenu3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseExited
        jMenu3.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jMenu3MouseExited

    private void jMenu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseEntered
        jMenu1.setForeground(new java.awt.Color(255, 51, 51));
    }//GEN-LAST:event_jMenu1MouseEntered

    private void jMenu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseExited
        jMenu1.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jMenu1MouseExited

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limpiaTabla(tabla);
        consultaData();
        select[1] = null;

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        filaSelec = jTable1.getSelectedRow();
        select[0] = jTable1.getValueAt(filaSelec, 0);
        select[1] = jTable1.getValueAt(filaSelec, 2);
        select[2] = jTable1.getValueAt(filaSelec, 3);

        select[3] = jTable1.getValueAt(filaSelec, 11);
        select[4] = jTable1.getValueAt(filaSelec, 9);
        select[5] = jTable1.getValueAt(filaSelec, 6);
        select[6] = jTable1.getValueAt(filaSelec, 7);

        solSe = String.valueOf(select[0]);
        dniCliSe = String.valueOf(select[2]);
        codMasSe = String.valueOf(select[3]);
        dniEmSe = String.valueOf(select[4]);
        codSerSe = String.valueOf(select[5]);
        nomSerSe = String.valueOf(select[6]);
        /*
        public static String dniCliSe;
        public static String dniEmSe;
        public static String solSe;
        public static String codMasSe;
        public static String codSerSe;
        public static String nomSerSe;
         */
    }//GEN-LAST:event_jTable1MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaseDatosCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

//Clases para fondo ajustado automatico
    //jframe
    class imagenFondoPanel extends JPanel {

        private Image imagen;

        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("fondos/az.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);//para que la imagen no sea transparente
            super.paint(g);
        }
    }
}
