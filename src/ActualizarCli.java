
import java.awt.Graphics;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ActualizarCli extends javax.swing.JFrame {

    BaseDatosServiciosAc ba = new BaseDatosServiciosAc();
    BaseDatosCliente bdCli = new BaseDatosCliente();

    static Statement stmt = null;
    static ResultSet rs = null;
    static Connection con = null;

    String nomCliAn;
    String apepaAn;
    String apemaAn;
    String numCelAn;
    String emailAn;
    String direcAn;

    String nomMasAn;
    String colorAn;
    String razaAn;
    String estaAn;
    
    //icono de jframe
    @Override
    public Image getIconImage(){
                                                                         //nos permite cargar cargar recursos de nuestro poryecto
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconsRun/updateRu.png"));
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

    public void consultaData() {
        try {
            stmt = ActualizarCli.conectar().createStatement();
            //aca especificamos la tabla a la que queremos ir
            String consulta = "SELECT * FROM TB_CLIENTE WHERE DNI_CLIENTE='" + bdCli.dniCliSe + "'";
            rs = stmt.executeQuery(consulta);//ESCRITURA exevuteQuery

            while (rs.next()) {
                //aca tener cuidado con la cantidad de columnas de nuestra tabla sql
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

        try {
            stmt = ActualizarCli.conectar().createStatement();
            //aca especificamos la tabla a la que queremos ir
            String consulta = "SELECT * FROM TB_MASCOTA WHERE COD_MASCOTA='" + bdCli.codMasSe + "'";
            rs = stmt.executeQuery(consulta);//ESCRITURA exevuteQuery

            while (rs.next()) {
                //aca tener cuidado con la cantidad de columnas de nuestra tabla sql
                jTextField8.setText(rs.getString(2));
                jTextField9.setText(rs.getString(1));
                jTextField10.setText(rs.getString(4));
                jTextField11.setText(rs.getString(5));
                jTextField12.setText(rs.getString(6));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public ActualizarCli() {

        initComponents();
        consultaData();
        setIconImage(getIconImage());
        nomCliAn = jTextField1.getText();
        apepaAn = jTextField3.getText();
        apemaAn = jTextField4.getText();
        numCelAn = jTextField5.getText();
        emailAn = jTextField6.getText();
        direcAn = jTextField7.getText();

        nomMasAn = jTextField8.getText();
        colorAn = jTextField10.getText();
        razaAn = jTextField11.getText();
        estaAn = jTextField12.getText();

        jTextField13.setText("seleccione un servicio");
        jTextField14.setText("---------------------------");
        /*
           public static String dniCliSe;
    public static String dniEmSe;
    public static String solSe;
    public static String codMasSe;
        public static String codSerSe;
         */
        //jTextField1.setText(bdCli.dniCliSe);
        //System.out.print(bdCli.dniCliSe + " " + bdCli.solSe + "  " + bdCli.codMasSe + " " + bdCli.dniEmSe + " " + bdCli.codSerSe + " " + bdCli.nomSerSe);

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
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
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
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 253, 250));

        jLabel1.setText("NOMBRE CLIENTE:");

        jTextField1.setBackground(new java.awt.Color(204, 222, 229));
        jTextField1.setBorder(null);
        jTextField1.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jTextField1.setSelectionColor(new java.awt.Color(0, 102, 204));

        jLabel2.setText("DNI:");

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(204, 222, 229));
        jTextField2.setBorder(null);
        jTextField2.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jTextField2.setEnabled(false);

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

        jLabel10.setText("COD. MASCOTA:");

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(204, 222, 229));
        jTextField9.setBorder(null);
        jTextField9.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jTextField9.setEnabled(false);

        jLabel11.setText("COLOR:");

        jTextField10.setBackground(new java.awt.Color(204, 222, 229));
        jTextField10.setBorder(null);

        jLabel12.setText("RAZA:");

        jTextField11.setBackground(new java.awt.Color(204, 222, 229));
        jTextField11.setBorder(null);

        jLabel13.setText("ESTADO:");

        jTextField12.setBackground(new java.awt.Color(204, 222, 229));
        jTextField12.setBorder(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/reali98A.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/re96nor.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/re96Pren.png"))); // NOI18N
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

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/cancel96a.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/cancel96nor.png"))); // NOI18N
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosClientes/cancel96pren.png"))); // NOI18N
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
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
                            .addComponent(jLabel15))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setText("ACEPTAR");
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
        String dniEm = ba.selecDniE;

        //datos de la mascota
        String nomMas = jTextField8.getText();
        String color = jTextField10.getText();
        String raza = jTextField11.getText();
        String esta = jTextField12.getText();
        String codMas = jTextField9.getText();

        //fecha de la solicitud
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String v = jTextField13.getText();
        int bd1 = 0;

        if (!"seleccione un servicio".equals(v)) {

            /*
            UPDATE TB_CLIENTE
            SET NOM_CLIENTE='ACTUALIZADO',APEMA_CLIENTE='AZCUALIZADO',APEPA_CLIENTE='Nuñez',
            EMAIL_CLIENTE='AZTUALIZADO22@gmail.com',NUMCEL_CLIENTE='977795678',DIREC_CLIENTE='ICA' 
	    WHERE DNI_CLIENTE='23456789'
             */
            String ingCli = "UPDATE TB_CLIENTE SET NOM_CLIENTE='" + nomCli + "',APEMA_CLIENTE='" + apema + "',APEPA_CLIENTE='" + apepa + "',\n"
                    + "EMAIL_CLIENTE='" + email + "',NUMCEL_CLIENTE='" + numCel + "',DIREC_CLIENTE='" + direc + "' \n"
                    + "WHERE DNI_CLIENTE='" + dniCli + "'";
            PreparedStatement pre1 = null;
            try {
                bd1 = 0;
                pre1 = con.prepareStatement(ingCli);
                pre1.executeUpdate();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
                bd1 = 1;
            }

            if (bd1 == 0) {
                /*
                UPDATE TB_MASCOTA SET NOM_MASCOTA='MASCOTA ACTUALIZADA',RAZA='A',COLOR='A',ESTADO='AA'
		WHERE COD_MASCOTA = '2'
                 */
                String ingMascota = "UPDATE TB_MASCOTA SET NOM_MASCOTA='" + nomMas + "',RAZA='" + raza + "',COLOR='" + color + "',ESTADO='" + esta + "' \n"
                        + " WHERE COD_MASCOTA = '" + codMas + "'";
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

                    /*
      UPDATE TB_SOLICITUD SET DNI_EMPLEADO='56473845',COD_SERVICIO='S03',FECHA_SOLICITUD='22:50' WHERE COD_SOLICITUD='2'
                     */
                    String ingSoli = "UPDATE TB_SOLICITUD SET DNI_EMPLEADO='" + dniEm + "',COD_SERVICIO='" + codService + "',FECHA_SOLICITUD='" + date.format(new Date()) + "' WHERE COD_SOLICITUD='" + bdCli.solSe + "'";
                    PreparedStatement pre3 = null;
                    try {
                        bd3 = 0;
                        pre3 = con.prepareStatement(ingSoli);
                        pre3.executeUpdate();

                    } catch (SQLException ex) {
                        bd3 = 1;
                        JOptionPane.showMessageDialog(null, ex);
                    }

                } else if (bd2 == 1) {

                    String ingCliAn = "UPDATE TB_CLIENTE SET NOM_CLIENTE='" + nomCliAn + "',APEMA_CLIENTE='" + apemaAn + "',APEPA_CLIENTE='" + apepaAn + "',\n"
                            + "EMAIL_CLIENTE='" + emailAn + "',NUMCEL_CLIENTE='" + numCelAn + "',DIREC_CLIENTE='" + direcAn + "' \n"
                            + "WHERE DNI_CLIENTE='" + dniCli + "'";
                    PreparedStatement pre1An = null;
                    try {
                        pre1An = con.prepareStatement(ingCliAn);
                        pre1An.executeUpdate();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }

                    String ingMascotaAn = "UPDATE TB_MASCOTA SET NOM_MASCOTA='" + nomMasAn + "',RAZA='" + razaAn + "',COLOR='" + colorAn + "',ESTADO='" + estaAn + "' \n"
                            + " WHERE COD_MASCOTA = '" + codMas + "'";
                    PreparedStatement pre2An = null;
                    try {

                        pre2An = con.prepareStatement(ingMascota);
                        pre2An.executeUpdate();

                    } catch (SQLException ex) {

                        JOptionPane.showMessageDialog(null, ex);
                    }

                }

            }

            if (bd1 == 0 && bd2 == 0 && bd3 == 0) {
                JOptionPane.showMessageDialog(null, "ACTUALIZADO CORRECTAMENTE", "UPDATE", 1);
                this.dispose();
            }

        } else {
            JOptionPane.showMessageDialog(null, "NO SE INGRESO EL SERVICIO", "ERROR", 0);
        }


    }//GEN-LAST:event_jButton1ActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        BaseDatosServiciosAc bds = new BaseDatosServiciosAc();
        bds.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setText("CANCELAR");
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setText("");
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarCli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    public static javax.swing.JTextField jTextField13;
    public static javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

    //Clases para fondo ajustado automatico
    //jframe
    class imagenFondo extends JPanel {

        private Image imagen;

        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("fondos/backiee-106946.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);//para que la imagen no sea transparente
            super.paint(g);
        }
    }

    //jpane
    class imagenFondoPanel extends JPanel {

        private Image imagen;

        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("fondos/perritobt.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);//para que la imagen no sea transparente
            super.paint(g);
        }
    }

}
