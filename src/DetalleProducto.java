
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class DetalleProducto extends javax.swing.JFrame {
    DecimalFormat formato = new DecimalFormat("#.00");
    BaseDatosAlmacenamiento bdal = new BaseDatosAlmacenamiento();
    
    String estado = "izq";
    
    static Connection con = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    
    
    //metodo para movimiento
    public static void Izq(JComponent componente, int milisegundos, int saltos, int parar) {
        (new Thread() {
            @Override
            public void run() {
                for (int i = componente.getWidth(); i >= parar; i -= saltos) {
                    try {
                        Thread.sleep(milisegundos);
                        componente.setPreferredSize(new Dimension(i, componente.getHeight()));
                        SwingUtilities.updateComponentTreeUI(componente);
                    } catch (InterruptedException e) {
                        System.out.println("Error Thread Interrumpido: " + e);
                    }
                }
            }
        }).start();
    }
    public static void Der(JComponent componente, int milisegundos, int saltos, int parar) {
        (new Thread() {
            @Override
            public void run() {
                for (int i = componente.getWidth(); i <= parar; i += saltos) {
                    try {
                        Thread.sleep(milisegundos);
                        componente.setPreferredSize(new Dimension(i, componente.getHeight()));
                        SwingUtilities.updateComponentTreeUI(componente);
                    } catch (InterruptedException e) {
                        System.out.println("Error Thread Interrumpido: " + e);
                    }
                }
            }
        }).start();
    }
    
    //metodos para bd
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
            stmt = DetalleProducto.conectar().createStatement();

            String consulta = "SELECT  P.COD_PRODUCTO, P.NOM_PRODUCTO, P.PRECIOUNI_PRODUCTO, DP.FECHA_ELABORACION,\n" +
"		DP.FECHA_VENCIMINETO, DP.LUGAR_ELABORACION,A.COD_ALMACEN,PRO.COD_PROVE,PRO.NOM_PROVE,PRO.EMAIL_PROVE,PRO.NUMCEL_PROVE,\n" +
"		AR.NOM_AREA, AR.COD_AREA FROM TB_PRODUCTO P INNER JOIN TB_DETALLE_PRODUCTO DP ON P.COD_PRODUCTO=DP.COD_PRODUCTO\n" +
"							INNER JOIN TB_PROVEEDOR PRO  ON PRO.COD_PROVE=P.COD_PROVE\n" +
"							INNER JOIN TB_ALMACEN A ON A.COD_ALMACEN = P.COD_ALMACEN\n" +
"							INNER JOIN TB_AREA AR ON AR.COD_AREA = A.COD_AREA\n" +
"							WHERE P.COD_PRODUCTO = '"+ bdal.codProSelect+"'";

            rs = stmt.executeQuery(consulta);

            while (rs.next()) {
                String n0="";
                String n1="";
                String n = rs.getString(2);
                
                for(int i=0;i<n.length();i++){
                    char e = n.charAt(i);
                    if(e==' '){
                        for(int i2=0;i2<i;i2++){
                            n0=n0+n.charAt(i2);
                        }
                        
                        for(int i3=i+1;i3<n.length();i3++){
                            n1=n1+n.charAt(i3);
                        }
                        break;
                    }
                }
                
                System.out.println(n1);

                System.out.println(n0);
                
                if(!"".equals(n0) && !"".equals(n1)){
                    jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 11));
                    jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 1, 11));
                    jLabel13.setText(n0);
                    jLabel21.setText(n1);
                }else{
                    jLabel13.setText(n);
                }
                
                jLabel14.setText(rs.getString(1));
                jLabel15.setText(formato.format(Float.parseFloat(rs.getString(3))));
                jLabel16.setText(rs.getString(4));
                jLabel17.setText(rs.getString(5));
                jLabel18.setText(rs.getString(6));
                jLabel19.setText(rs.getString(7));
                jLabel20.setText(rs.getString(12));
                jLabel27.setText(rs.getString(8));
                jLabel28.setText(rs.getString(9));
                jLabel29.setText(rs.getString(10));
                jLabel30.setText(rs.getString(11));
                        
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
    
    public DetalleProducto() {
        initComponents();
        consultaData();
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new imagenFondoPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(336, 341));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(335, 286));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("precio C/U");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 153));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 153));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 20));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("codigo de almacen");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("--------------------");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("lugar de elaboracion");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("fecha de producción");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("--------------------");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("codigo producto");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("--------------------");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("--------------------");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("--------------------");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("fecha de vencimiento");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("--------------------");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("--------------------");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("area");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        jLabel21.setBackground(new java.awt.Color(255, 255, 153));
        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 153));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 220, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 0, 102));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(51, 0, 102));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(131, 301));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/proveedor.png"))); // NOI18N
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setText("codigo proveedor");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 90, -1, -1));

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("nombre proveedor");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 143, -1, -1));

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("num. celular");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setText("email");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("--------------------");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 117, -1, -1));

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("--------------------");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 169, -1, -1));

        jLabel29.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 9)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("--------------------");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel30.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("--------------------");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
         if("izq".equals(estado)){
            Izq(jPanel1, 3, 3, 210);
            estado="der";
        }
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        if("der".equals(estado)){
            Der(jPanel1, 3, 3, 335);
            estado="izq";
        }  
    }//GEN-LAST:event_jPanel2MouseExited

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
         char p = evt.getKeyChar();
         if(p==''){
            this.dispose();
         }
    }//GEN-LAST:event_formKeyPressed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

//jpane
    class imagenFondoPanel extends JPanel {

        private Image imagen;

        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("fondos/degrhoriazu.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);//para que la imagen no sea transparente
            super.paint(g);
        }
    }


}
