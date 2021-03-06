/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.Consulta;
import Logica.PConsulta;
import Logica.PPaciente;
import Reportes.Reportes;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.stage.FileChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 *
 * @author Matud
 */
public class frmMenu extends javax.swing.JFrame {

    /**
     * Creates new form frmConsulta
     */
    public frmMenu() {
        initComponents();
        pnlListaPacientes.setVisible(true);
        pnlNuevaConsulta.setVisible(false);
    }
    
     private String accion="guardar";
    
     void mostrar(String buscar)
    {
        try {
            DefaultTableModel modelo;
            PPaciente func = new PPaciente();
            modelo= func.mostrar(buscar);
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    public void guardarConsulta()
    {
         if(txtCiConsulta.getText().length()==0)
        {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar cedula de identidad");
            txtCiConsulta.requestFocus();
            return;
        }
         
         if(txtNombreConsulta.getText().length()==0)
        {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un nombre de consulta");
            txtNombreConsulta.requestFocus();
            return;
        }
         
         Consulta c = new Consulta();
         PConsulta func = new PConsulta();
         c.setFecha(dpfechaConsulta.getDate());
         c.setNombre(txtNombreConsulta.getText());
         c.setEdad(Integer.parseInt(txtEdadConsulta.getText()));
         c.setCedula(Integer.parseInt(txtCiConsulta.getText()));
         c.setObservaciones(txtConsulta.getText());
         
         
         
          if(accion.equals("guardar")){
            if(func.insetar(c))
            {
                JOptionPane.showMessageDialog(rootPane,"La consulta se guardo correctamente");
                mostrar("");
                try {
                    Reportes.reportConsulta(c.getNombre());
                } catch (Exception e) {
                    System.out.print(e.toString());
                }
                
            }
        }   
    }





      public void buscarConsulta()
    {
        
       Consulta consulta = new Consulta();
       PConsulta func = new PConsulta();
        try
        {
            consulta =func.buscarConsulta(Integer.parseInt(txtCiConsulta.getText()));
           
           if(func!=null)
           {
               
               txtNombreConsulta.setText(consulta.getNombre());
               dpfechaConsulta.setDate(consulta.getFecha());
               txtEdadConsulta.setText(String.valueOf(consulta.getEdad()));
               txtConsulta.setText(consulta.getObservaciones());
               
               
           }     
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"No se encontro el registro"+e);
        }    
    }

    boolean respaldarBD() {
        boolean status = false;
        try {
            Process p = null;

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();
            String database = "homeosys";
            String host = "localhost";
            String filepath = "backup-" + database + "-" + host + "-(" + dateFormat.format(date) + ").sql";

            String batchCommand = "";
            String password = "root";
            String port = "3306";
            String backupPath = "";
            String dumpExePath = "C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqldump";
            String user = "root";

            fileChooser.setSelectedFile(new File(filepath));
            fileChooser.setVisible(true);

            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                filepath = fileChooser.getSelectedFile().toString();
                if (password != "") {
                    batchCommand = dumpExePath + " -h " + host + " --port " + port + " -u " + user + " --password=" + password + " " + database + " -r \"" + backupPath + "" + filepath + "\"";
                } else {
                    batchCommand = dumpExePath + " -h " + host + " --port " + port + " -u " + user + " " + database + " -r \"" + backupPath + "" + filepath + "\"";
                }

                Runtime runtime = Runtime.getRuntime();
                p = runtime.exec(batchCommand);
                int processComplete = p.waitFor();

                if (processComplete == 0) {
                    status = true;
                } else {
                    status = false;
                }
            }

        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
    
    public boolean restaaurarBD(){
        String dbPassword = "root";
        String dbUserName = "root";
        String source = null;
        fileChooser.setVisible(true);

            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                source = fileChooser.getSelectedFile().toString();
                String[] executeCmd = new String[]{"C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysql",  "--user=" + dbUserName, "--password=" + dbPassword, "-e", "source " + source};

                Process runtimeProcess;
                try {
                    runtimeProcess = Runtime.getRuntime().exec(executeCmd);
                    int processComplete = runtimeProcess.waitFor();

                    if (processComplete == 0) {
                        return true;
                    } else {
                    }
                } catch (Exception ex) {
                    System.err.println(ex);
        }
            }else{
                
            }
        return false;
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        pnlListaPacientes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablepacientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblSearchPaciente = new javax.swing.JLabel();
        lblNuevoPaciente = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lblListaPacientes = new javax.swing.JLabel();
        lblNuevaConsulta = new javax.swing.JLabel();
        pnlNuevaConsulta = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtEdadConsulta = new javax.swing.JTextField();
        lblSearchConsulta = new javax.swing.JLabel();
        txtCiConsulta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtConsulta = new javax.swing.JTextArea();
        txtNombreConsulta = new javax.swing.JTextField();
        btnHomeopatia = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnNuevaConsulta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnGuardarConsulta = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        dpfechaConsulta = new org.jdesktop.swingx.JXDatePicker();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(40, 56, 73));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlListaPacientes.setBackground(new java.awt.Color(255, 255, 255));

        jTablepacientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTablepacientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTablepacientes.setForeground(new java.awt.Color(51, 51, 51));
        jTablepacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"pepe", "13214", "122", "bella union"},
                {"roberto", "121245", "11", null},
                {null, null, null, null},
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
                "Nombre", "CI", "Edad", "Localidad"
            }
        ));
        jTablepacientes.setGridColor(new java.awt.Color(255, 69, 3));
        jTablepacientes.setRowHeight(30);
        jTablepacientes.setSelectionBackground(new java.awt.Color(255, 221, 155));
        jTablepacientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTablepacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablepacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablepacientes);
        jTablepacientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.setBorderPainted(false);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Ver consultas");
        jButton2.setBorderPainted(false);

        lblSearchPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_search-icon-light-grey-hi_1 (1).png"))); // NOI18N
        lblSearchPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSearchPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSearchPacienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSearchPacienteMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblSearchPacienteMouseReleased(evt);
            }
        });

        lblNuevoPaciente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNuevoPaciente.setForeground(new java.awt.Color(0, 114, 7));
        lblNuevoPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/nuevo.png"))); // NOI18N
        lblNuevoPaciente.setText("Nuevo");
        lblNuevoPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNuevoPacienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNuevoPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNuevoPacienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblNuevoPacienteMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblNuevoPacienteMouseReleased(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setText("Paciente..");

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Editar Seleccionado");
        jButton3.setBorderPainted(false);

        javax.swing.GroupLayout pnlListaPacientesLayout = new javax.swing.GroupLayout(pnlListaPacientes);
        pnlListaPacientes.setLayout(pnlListaPacientesLayout);
        pnlListaPacientesLayout.setHorizontalGroup(
            pnlListaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaPacientesLayout.createSequentialGroup()
                .addGroup(pnlListaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaPacientesLayout.createSequentialGroup()
                        .addContainerGap(53, Short.MAX_VALUE)
                        .addGroup(pnlListaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlListaPacientesLayout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSearchPaciente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNuevoPaciente))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaPacientesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(53, 53, 53))
        );
        pnlListaPacientesLayout.setVerticalGroup(
            pnlListaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaPacientesLayout.createSequentialGroup()
                .addGroup(pnlListaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlListaPacientesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNuevoPaciente)
                        .addGap(68, 68, 68))
                    .addGroup(pnlListaPacientesLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(pnlListaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSearchPaciente)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(389, 389, 389)
                .addGroup(pnlListaPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(22, 22, 22))
        );

        jPanel1.add(pnlListaPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 990, 470));

        jPanel3.setBackground(new java.awt.Color(255, 69, 3));

        lblTitle.setBackground(new java.awt.Color(252, 252, 252));
        lblTitle.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Lista de Pacientes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(317, 317, 317))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 570, 90));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("HomeoManager v. beta 1.2");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 600, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 160, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 160, 20));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 160, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_21logo.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblListaPacientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblListaPacientes.setForeground(new java.awt.Color(153, 153, 153));
        lblListaPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_list-xxl.png"))); // NOI18N
        lblListaPacientes.setText("Lista de pacientes");
        lblListaPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblListaPacientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblListaPacientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblListaPacientesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblListaPacientesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblListaPacientesMouseReleased(evt);
            }
        });
        jPanel1.add(lblListaPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        lblNuevaConsulta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNuevaConsulta.setForeground(new java.awt.Color(153, 153, 153));
        lblNuevaConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/nuevogris.png"))); // NOI18N
        lblNuevaConsulta.setText("Nueva consulta");
        lblNuevaConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNuevaConsultaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNuevaConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNuevaConsultaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblNuevaConsultaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblNuevaConsultaMouseReleased(evt);
            }
        });
        jPanel1.add(lblNuevaConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        pnlNuevaConsulta.setBackground(new java.awt.Color(255, 255, 255));
        pnlNuevaConsulta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Fecha");
        pnlNuevaConsulta.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 36, 62, -1));

        txtEdadConsulta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEdadConsulta.setNextFocusableComponent(txtConsulta);
        pnlNuevaConsulta.add(txtEdadConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, 50, 40));

        lblSearchConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_search-icon-light-grey-hi_1 (1).png"))); // NOI18N
        lblSearchConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchConsultaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSearchConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSearchConsultaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSearchConsultaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblSearchConsultaMouseReleased(evt);
            }
        });
        pnlNuevaConsulta.add(lblSearchConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        txtCiConsulta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCiConsulta.setNextFocusableComponent(txtEdadConsulta);
        pnlNuevaConsulta.add(txtCiConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 230, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("CI.");
        pnlNuevaConsulta.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 62, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Nombre");
        pnlNuevaConsulta.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 90, -1));

        txtConsulta.setColumns(20);
        txtConsulta.setRows(5);
        jScrollPane2.setViewportView(txtConsulta);

        pnlNuevaConsulta.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 690, 240));

        txtNombreConsulta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreConsulta.setNextFocusableComponent(txtCiConsulta);
        pnlNuevaConsulta.add(txtNombreConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 230, 40));

        btnHomeopatia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHomeopatia.setText("Homeopatía");
        btnHomeopatia.setBorderPainted(false);
        btnHomeopatia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeopatiaActionPerformed(evt);
            }
        });
        pnlNuevaConsulta.add(btnHomeopatia, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, -1, -1));

        btnImprimir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_printicon_grey11.png"))); // NOI18N
        btnImprimir.setBorderPainted(false);
        pnlNuevaConsulta.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 360, 80, 70));

        btnNuevaConsulta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevaConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_plus-icon (1).png"))); // NOI18N
        btnNuevaConsulta.setBorderPainted(false);
        pnlNuevaConsulta.add(btnNuevaConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 280, 80, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ver Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_next.png"))); // NOI18N
        btnSiguiente.setBorderPainted(false);
        jPanel2.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 50, 50));

        btnAnterior.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_arrow-left-01-128.png"))); // NOI18N
        btnAnterior.setBorderPainted(false);
        jPanel2.add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, 50));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Siguiente");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 90, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Anterior");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 90, -1));

        pnlNuevaConsulta.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 180, 260));

        btnGuardarConsulta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_save-xxl.png"))); // NOI18N
        btnGuardarConsulta.setBorderPainted(false);
        btnGuardarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarConsultaActionPerformed(evt);
            }
        });
        pnlNuevaConsulta.add(btnGuardarConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 200, 80, 70));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Edad");
        pnlNuevaConsulta.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 90, -1));
        pnlNuevaConsulta.add(dpfechaConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 160, 40));

        jPanel1.add(pnlNuevaConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 990, 470));

        jPanel4.setBackground(new java.awt.Color(255, 69, 3));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_database.png"))); // NOI18N
        jLabel1.setText("Base de Datos");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 220, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablepacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablepacientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablepacientesMouseClicked

    private void lblNuevoPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevoPacienteMouseClicked
        frmNuevoPaciente dialog = new frmNuevoPaciente();
        dialog.setVisible(true);
    }//GEN-LAST:event_lblNuevoPacienteMouseClicked

    private void lblNuevaConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevaConsultaMouseClicked
        pnlNuevaConsulta.setVisible(true);
        pnlListaPacientes.setVisible(false);
        lblTitle.setText("Nueva Consulta");

    }//GEN-LAST:event_lblNuevaConsultaMouseClicked

    private void lblNuevoPacienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevoPacienteMouseReleased
        lblNuevoPaciente.setBorder(null);
    }//GEN-LAST:event_lblNuevoPacienteMouseReleased

    private void lblNuevoPacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevoPacienteMousePressed
        Border border = LineBorder.createGrayLineBorder();
        lblNuevoPaciente.setBorder(border);
    }//GEN-LAST:event_lblNuevoPacienteMousePressed

    private void lblListaPacientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListaPacientesMousePressed
        Border border = LineBorder.createGrayLineBorder();
        lblListaPacientes.setBorder(border);        // TODO add your handling code here:
    }//GEN-LAST:event_lblListaPacientesMousePressed

    private void lblListaPacientesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListaPacientesMouseReleased
        lblListaPacientes.setBorder(null);
    }//GEN-LAST:event_lblListaPacientesMouseReleased

    private void lblListaPacientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListaPacientesMouseEntered
        Border border = LineBorder.createGrayLineBorder();
        lblListaPacientes.setBorder(border);
    }//GEN-LAST:event_lblListaPacientesMouseEntered

    private void lblListaPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListaPacientesMouseClicked
        pnlNuevaConsulta.setVisible(false);
        pnlListaPacientes.setVisible(true);
        lblTitle.setText("Lista de Pacientes");
    }//GEN-LAST:event_lblListaPacientesMouseClicked

    private void lblListaPacientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListaPacientesMouseExited
        lblListaPacientes.setBorder(null);
    }//GEN-LAST:event_lblListaPacientesMouseExited

    private void lblNuevaConsultaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevaConsultaMousePressed
        Border border = LineBorder.createGrayLineBorder();
        lblNuevaConsulta.setBorder(border);        }//GEN-LAST:event_lblNuevaConsultaMousePressed

    private void lblNuevaConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevaConsultaMouseEntered
        Border border = LineBorder.createGrayLineBorder();
        lblNuevaConsulta.setBorder(border);
    }//GEN-LAST:event_lblNuevaConsultaMouseEntered

    private void lblNuevaConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevaConsultaMouseExited
        lblNuevaConsulta.setBorder(null);
    }//GEN-LAST:event_lblNuevaConsultaMouseExited

    private void lblNuevaConsultaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevaConsultaMouseReleased
        lblNuevaConsulta.setBorder(null);
    }//GEN-LAST:event_lblNuevaConsultaMouseReleased

    private void btnHomeopatiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeopatiaActionPerformed
        frmHomeopatia p = new frmHomeopatia();
        p.setVisible(true);
    }//GEN-LAST:event_btnHomeopatiaActionPerformed

    private void dpFechaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpFechaConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dpFechaConsultaActionPerformed

    private void lblSearchPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchPacienteMouseEntered
        Border border = LineBorder.createGrayLineBorder();

        lblSearchPaciente.setBorder(border);
    }//GEN-LAST:event_lblSearchPacienteMouseEntered

    private void lblNuevoPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevoPacienteMouseEntered
        Border border = LineBorder.createGrayLineBorder();
        lblNuevoPaciente.setBorder(border);
    }//GEN-LAST:event_lblNuevoPacienteMouseEntered

    private void lblSearchConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchConsultaMouseEntered
        Border border = LineBorder.createGrayLineBorder();
        lblSearchConsulta.setBorder(border);
    }//GEN-LAST:event_lblSearchConsultaMouseEntered

    private void lblSearchConsultaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchConsultaMousePressed
        Border border = LineBorder.createGrayLineBorder();
        lblSearchConsulta.setBorder(border);
    }//GEN-LAST:event_lblSearchConsultaMousePressed

    private void lblSearchPacienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchPacienteMousePressed
        Border border = LineBorder.createGrayLineBorder();
        lblSearchPaciente.setBorder(border);
    }//GEN-LAST:event_lblSearchPacienteMousePressed

    private void lblNuevoPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevoPacienteMouseExited
        lblNuevoPaciente.setBorder(null);
    }//GEN-LAST:event_lblNuevoPacienteMouseExited

    private void lblSearchPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchPacienteMouseExited
        lblSearchPaciente.setBorder(null);
    }//GEN-LAST:event_lblSearchPacienteMouseExited

    private void lblSearchPacienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchPacienteMouseReleased
        lblSearchPaciente.setBorder(null);
    }//GEN-LAST:event_lblSearchPacienteMouseReleased

    private void lblSearchConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchConsultaMouseExited
        lblSearchConsulta.setBorder(null);
    }//GEN-LAST:event_lblSearchConsultaMouseExited

    private void lblSearchConsultaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchConsultaMouseReleased
        lblSearchConsulta.setBorder(null);
    }//GEN-LAST:event_lblSearchConsultaMouseReleased

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        String[] list = {"Restaurar", "Respaldar"};
        JComboBox jcb = new JComboBox(list);
        jcb.setEditable(true);
        int option = JOptionPane.showConfirmDialog(null, jcb, "Elija la opción deseada", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            if (jcb.getSelectedItem().equals("Respaldar")) {
                respaldarBD();
            } else {
                restaaurarBD();
            }
        } else {
            System.out.println("No");
        }


    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnGuardarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarConsultaActionPerformed
        guardarConsulta();
    }//GEN-LAST:event_btnGuardarConsultaActionPerformed

    private void lblSearchConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchConsultaMouseClicked
        buscarConsulta();
    }//GEN-LAST:event_lblSearchConsultaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnGuardarConsulta;
    private javax.swing.JButton btnHomeopatia;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNuevaConsulta;
    private javax.swing.JButton btnSiguiente;
    private org.jdesktop.swingx.JXDatePicker dpfechaConsulta;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTablepacientes;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblListaPacientes;
    private javax.swing.JLabel lblNuevaConsulta;
    private javax.swing.JLabel lblNuevoPaciente;
    private javax.swing.JLabel lblSearchConsulta;
    private javax.swing.JLabel lblSearchPaciente;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlListaPacientes;
    private javax.swing.JPanel pnlNuevaConsulta;
    private javax.swing.JTextField txtCiConsulta;
    private javax.swing.JTextArea txtConsulta;
    private javax.swing.JTextField txtEdadConsulta;
    private javax.swing.JTextField txtNombreConsulta;
    // End of variables declaration//GEN-END:variables
}
