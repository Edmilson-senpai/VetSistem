
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class RegistroCli extends javax.swing.JFrame {

    BaseDatosClienteExis cliexi = new BaseDatosClienteExis();
    BaseDatosServicios bdSe = new BaseDatosServicios();
    int bdGene = 0;

    static Statement stmt = null;
    static ResultSet rs = null;
    static Connection con = null;
    //imagenFondo background = new imagenFondo();//instanciamos el tributo
    
    //icono de jframe
    @Override
    public Image getIconImage(){
                                                                         //nos permite cargar cargar recursos de nuestro poryecto
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconsRun/agregar-usuario.png"));
        return retValue;
    }
    
    //METODOS
    public static Connection conectar() {
        String conexionUrl = "jdbc:sqlserver://localhost:1433"
                + ";databaseName=VETERINARIA3;"
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

    public RegistroCli() {
        //this.setContentPane(background);//establecemos el atritubo
        initComponents();
        setIconImage(getIconImage());
        conectar();
        jTextField13.setText("seleccione un servicio");
        jTextField14.setText("---------------------------");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 253, 250));

        jLabel1.setText("NOMBRE CLIENTE:");

        jTextField1.setBackground(new java.awt.Color(204, 222, 229));
        jTextField1.setBorder(null);
        jTextField1.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jTextField1.setSelectionColor(new java.awt.Color(0, 102, 204));

        jLabel2.setText("DNI:");

        jTextField2.setBackground(new java.awt.Color(204, 222, 229));
        jTextField2.setBorder(null);
        jTextField2.setDisabledTextColor(new java.awt.Color(255, 0, 51));

        jLabel3.setText("APELLIDO PATERNO:");

        jLabel4.setText("APELLIDO MATERNO:");

        jTextField3.setBackground(new java.awt.Color(204, 222, 229));
        jTextField3.setBorder(null);
        jTextField3.setDisabledTextColor(new java.awt.Color(255, 0, 51));

        jTextField4.setBackground(new java.awt.Color(204, 222, 229));
        jTextField4.setBorder(null);
        jTextField4.setDisabledTextColor(new java.awt.Color(255, 0, 51));

        jLabel5.setText("NUMERO CEL.:");

        jTextField5.setBackground(new java.awt.Color(204, 222, 229));
        jTextField5.setBorder(null);
        jTextField5.setDisabledTextColor(new java.awt.Color(255, 0, 51));

        jLabel6.setText("EMAIL:");

        jTextField6.setBackground(new java.awt.Color(204, 222, 229));
        jTextField6.setBorder(null);
        jTextField6.setDisabledTextColor(new java.awt.Color(255, 0, 51));

        jLabel7.setText("DIRECCION:");

        jTextField7.setBackground(new java.awt.Color(204, 222, 229));
        jTextField7.setBorder(null);
        jTextField7.setDisabledTextColor(new java.awt.Color(255, 0, 51));

        jLabel8.setText("NOMBRE MASCOTA:");

        jTextField8.setBackground(new java.awt.Color(204, 222, 229));
        jTextField8.setBorder(null);
        jTextField8.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        jTextField8.setSelectionColor(new java.awt.Color(0, 102, 204));

        jLabel11.setText("COLOR:");

        jTextField10.setBackground(new java.awt.Color(204, 222, 229));
        jTextField10.setBorder(null);

        jLabel12.setText("RAZA:");

        jTextField11.setBackground(new java.awt.Color(204, 222, 229));
        jTextField11.setBorder(null);

        jLabel13.setText("ESTADO:");

        jTextField12.setBackground(new java.awt.Color(204, 222, 229));
        jTextField12.setBorder(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/SaveApg.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/Save_37110.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/saveEnc.png"))); // NOI18N
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
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

        jButton2.setBackground(new java.awt.Color(204, 222, 229));
        jButton2.setFont(new java.awt.Font("Zilla Slab SemiBold", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 153, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/pc2ch.gif"))); // NOI18N
        jButton2.setText("<html><p>CONSULTAR</p><center>SERVICIOS</center></html>");
        jButton2.setFocusable(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("SERVICIO SELECIONADO:");

        jLabel14.setText("CODIGO DE SERVICIO:");

        jTextField13.setBackground(new java.awt.Color(0, 0, 0));
        jTextField13.setForeground(new java.awt.Color(204, 0, 0));
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setBorder(null);
        jTextField13.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextField13.setEnabled(false);

        jTextField14.setBackground(new java.awt.Color(0, 0, 0));
        jTextField14.setForeground(new java.awt.Color(204, 0, 0));
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setBorder(null);
        jTextField14.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        jTextField14.setEnabled(false);

        jLabel15.setText("..........................................................................");

        jLabel16.setText("..........................................................................");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextField1)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField6)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel16)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel14))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel15))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGap(61, 61, 61)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel12))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                        .addComponent(jTextField8)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jMenuBar2.setBackground(new java.awt.Color(204, 222, 229));
        jMenuBar2.setBorderPainted(false);

        jMenu2.setText("regresar");
        jMenu2.setContentAreaFilled(false);
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu2MouseExited(evt);
            }
        });
        jMenuBar2.add(jMenu2);

        jMenu3.setText("|");
        jMenu3.setEnabled(false);
        jMenu3.setFocusable(false);
        jMenuBar2.add(jMenu3);

        jMenu4.setText("consultar data");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu4MouseExited(evt);
            }
        });
        jMenuBar2.add(jMenu4);

        jMenu5.setText("|");
        jMenu5.setEnabled(false);
        jMenu5.setFocusable(false);
        jMenuBar2.add(jMenu5);

        jMenu6.setText("pag. principal");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jMenu6MouseExited(evt);
            }
        });
        jMenuBar2.add(jMenu6);

        jMenu7.setText("|");
        jMenu7.setEnabled(false);
        jMenu7.setFocusable(false);
        jMenuBar2.add(jMenu7);

        jMenu1.setText("r. existente");
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
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem1.setText("actualizar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setText("GUARDAR");
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setText("");
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int bd2 = 0, bd3 = 0;

        //datos cliente
        String nomCli = jTextField1.getText();
        String dniCli = jTextField2.getText();
        String apepa = jTextField3.getText();
        String apema = jTextField4.getText();
        String numCel = jTextField5.getText();
        String email = jTextField6.getText();
        String direc = jTextField7.getText();

        //datos para la solicutud
        String codService = jTextField14.getText();
        String dniEm = bdSe.selecDniE;

        //datos de la mascota
        String nomMas = jTextField8.getText();
        String color = jTextField10.getText();
        String raza = jTextField11.getText();
        String esta = jTextField12.getText();

        //fecha de la solicitud
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String v = jTextField13.getText();
        int bd1 = 0;
        if (!"seleccione un servicio".equals(v)) {
            if (bdGene == 0) {

                //POST del cliente
                //INSERT INTO TB_CLIENTE VALUES('84756374','DANIEL','GUTIERREZ','CCALLASACA','985766475','DA@GMAIL.COM','ICA')
                String ingCli = "INSERT INTO TB_CLIENTE "
                        + "VALUES ('" + dniCli + "','" + nomCli + "','" + apepa + "','" + apema + "','" + numCel + "',"
                        + "'" + email + "','" + direc + "')";
                PreparedStatement pre1 = null;
                try {
                    bd1 = 0;
                    pre1 = con.prepareStatement(ingCli);
                    pre1.executeUpdate();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                    bd1 = 1;
                }
            }

            //POST de la mascota
            //INSERT INTO TB_MASCOTA VALUES('BOLTA','84756374','NEGRO CON CANELA','Pastor alemán','Presenta complicaciones para correr')
            if (bd1 == 0) {

                String ingMascota = "INSERT INTO TB_MASCOTA VALUES ('" + nomMas + "','" + dniCli + "','" + color + "','" + raza + "','" + esta + "')";
                PreparedStatement pre2 = null;
                try {
                    bd2 = 0;
                    pre2 = con.prepareStatement(ingMascota);
                    pre2.executeUpdate();

                } catch (SQLException ex) {
                    bd2 = 1;
                    JOptionPane.showMessageDialog(null, ex);
                }

                if (bd2 == 0) {
                    Object codMas[] = new Object[1];
                    try {
                        stmt = RegistroCli.conectar().createStatement();
                        String consulta = "SELECT * FROM TB_MASCOTA WHERE DNI_CLIENTE ='" + dniCli + "' AND NOM_MASCOTA='" + nomMas + "';";
                        rs = stmt.executeQuery(consulta);
                        while (rs.next()) {
                            codMas[0] = rs.getString(1);
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }

                    //POST de la solicitud
                    //INSERT INTO TB_SOLICITUD VALUES('44756345','84756374','1','20:03','S11')
                    String ingSoli = "INSERT INTO TB_SOLICITUD VALUES ('" + dniEm + "','" + dniCli + "','" + codMas[0] + "','" + date.format(new Date()) + "','" + codService + "')";
                    PreparedStatement pre3 = null;
                    try {
                        bd3 = 0;
                        pre3 = con.prepareStatement(ingSoli);
                        pre3.executeUpdate();

                    } catch (SQLException ex) {
                        bd3 = 1;
                        JOptionPane.showMessageDialog(null, ex);
                    }

                } else if (bd2 == 1 && bdGene == 0) {
                    String ing = "DELETE FROM TB_CLIENTE WHERE DNI_CLIENTE='" + dniCli + "';";
                    PreparedStatement pre = null;
                    try {
                        pre = con.prepareStatement(ing);
                        pre.executeUpdate();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }

            //bd1!=0 |
            if (bd1 == 0 && bd2 == 0 && bd3 == 0) {

                int ventanaYesNo = JOptionPane.showConfirmDialog(null, "<html>REGISTRADO CON EXITO:<br><center>¿Quieres seguir registrando al mismo cliente?</center></hmtl>", "Aviso", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                //0=si, 1=no
                System.out.print(ventanaYesNo);
                switch (ventanaYesNo) {
                    case 0:
                        jTextField1.setEnabled(false);
                        jTextField2.setEnabled(false);
                        jTextField3.setEnabled(false);
                        jTextField4.setEnabled(false);
                        jTextField5.setEnabled(false);
                        jTextField6.setEnabled(false);
                        jTextField7.setEnabled(false);
                        jTextField8.setText("");
                        jTextField10.setText("");
                        jTextField11.setText("");
                        jTextField12.setText("");
                        jTextField13.setText("seleccione un servicio");
                        jTextField14.setText("---------------------------");
                        bdGene = 1;
                        break;
                    case 1:
                        jTextField1.setText("");
                        jTextField2.setText("");
                        jTextField3.setText("");
                        jTextField4.setText("");
                        jTextField5.setText("");
                        jTextField6.setText("");
                        jTextField7.setText("");
                        jTextField8.setText("");
                        jTextField10.setText("");
                        jTextField11.setText("");
                        jTextField12.setText("");
                        jTextField13.setText("seleccione un servicio");
                        jTextField14.setText("---------------------------");
                        bdGene = 0;
                        break;
                    case 2:
                        Cliente pgc = new Cliente();
                        pgc.setVisible(true);
                        this.dispose();
                        break;
                    default:
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO SE INGRESO EL SERVICIO", "ERROR", 0);
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    private void jMenu2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseEntered
        jMenu2.setForeground(new java.awt.Color(255, 51, 51));
        //jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 14));
    }//GEN-LAST:event_jMenu2MouseEntered

    private void jMenu2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseExited
        jMenu2.setForeground(new java.awt.Color(0, 0, 0));
        //jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 8));
    }//GEN-LAST:event_jMenu2MouseExited

    private void jMenu4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseEntered
        jMenu4.setForeground(new java.awt.Color(255, 51, 51));
        //jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 14));
    }//GEN-LAST:event_jMenu4MouseEntered

    private void jMenu4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseExited
        jMenu4.setForeground(new java.awt.Color(0, 0, 0));
        //jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 8));
    }//GEN-LAST:event_jMenu4MouseExited

    private void jMenu6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseEntered
        jMenu6.setForeground(new java.awt.Color(255, 51, 51));
        //jMenu6.setFont(new java.awt.Font("Segoe UI", 0, 14));
    }//GEN-LAST:event_jMenu6MouseEntered

    private void jMenu6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseExited
        jMenu6.setForeground(new java.awt.Color(0, 0, 0));
        //jMenu6.setFont(new java.awt.Font("Segoe UI", 0, 8));
    }//GEN-LAST:event_jMenu6MouseExited

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        Cliente cli = new Cliente();
        cli.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        BaseDatosCliente bd = new BaseDatosCliente();
        bd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        Principal prin = new Principal();
        prin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        BaseDatosServicios bds = new BaseDatosServicios();
        bds.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        BaseDatosClienteExis bde = new BaseDatosClienteExis();
        bde.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseEntered
        jMenu1.setForeground(new java.awt.Color(255, 51, 51));
    }//GEN-LAST:event_jMenu1MouseEntered

    private void jMenu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseExited
        jMenu1.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jMenu1MouseExited

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        try {
            stmt = RegistroCli.conectar().createStatement();
            String consulta = "SELECT * FROM TB_CLIENTE WHERE DNI_CLIENTE='" + cliexi.dniCliSe + "'";
            rs = stmt.executeQuery(consulta);//ESCRITURA exevuteQuery
            while (rs.next()) {
                jTextField2.setText(rs.getString(1));
                jTextField1.setText(rs.getString(2));
                jTextField3.setText(rs.getString(3));
                jTextField4.setText(rs.getString(4));
                jTextField5.setText(rs.getString(5));
                jTextField6.setText(rs.getString(6));
                jTextField7.setText(rs.getString(7));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField8.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("seleccione un servicio");
        jTextField14.setText("---------------------------");
        bdGene = 1;

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroCli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    public static javax.swing.JTextField jTextField13;
    public static javax.swing.JTextField jTextField14;
    javax.swing.JTextField jTextField2;
    javax.swing.JTextField jTextField3;
    javax.swing.JTextField jTextField4;
    javax.swing.JTextField jTextField5;
    javax.swing.JTextField jTextField6;
    javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

}
