/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.Paciente;
import Logica.PPaciente;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matud
 */
public class frmNuevoPaciente extends javax.swing.JFrame {

    /**
     * Creates new form frmNuevoPaciente
     */
    public frmNuevoPaciente() {
        initComponents();
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtcedula = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtlocalidad = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JTextField();
        txtedad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(40, 56, 73));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 69, 3));

        jLabel1.setBackground(new java.awt.Color(252, 252, 252));
        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevo Paciente");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(270, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 570, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_21logo.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcedula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtcedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaActionPerformed(evt);
            }
        });
        jPanel1.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 160, 30));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 150, 30));

        txtnombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 280, 30));

        txtlocalidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtlocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 280, 30));

        txttelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 150, 30));

        txtdireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 280, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Teléfono");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 80, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("ci");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 20, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Fecha");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 50, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Nombre");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 70, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Observaciones:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 130, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Dirección");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 80, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Celular");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 80, -1));

        txtcelular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtcelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 150, 30));

        txtedad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 40, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Edad");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 50, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Localidad");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 430, 90));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/rsz_save-xxl.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 130, 80));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 800, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaActionPerformed
        // TODO add your handling code  here:
    }//GEN-LAST:event_txtcedulaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(txtcedula.getText().length()==0)
        {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar cedula de identidad");
            txtcedula.requestFocus();
            return;
        }
        if(txtnombre.getText().length()==0)
        {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar cun nombre de paciente");
            txtnombre.requestFocus();
            return;
        }
        Paciente p = new Paciente();
        PPaciente func  = new PPaciente();

        p.setCedula(Integer.parseInt(txtcedula.getText()));
        p.setNombre(txtnombre.getText());
        p.setEdad(Integer.parseInt(txtedad.getText()));
        p.setDireccion(txtdireccion.getText());
        p.setLocalidad(txtlocalidad.getText());
        p.setTelefono(Integer.parseInt(txttelefono.getText()));
        p.setCelular(Integer.parseInt(txtcelular.getText()));

        Calendar cal;
        int d,m,a;

        if(accion.equals("guardar")){
            if(func.insetar(p))
            {
                JOptionPane.showMessageDialog(rootPane,"El paciente se guardo correctamente");
                mostrar("");
            }
        }
        else if(accion.equals("editar"))
        {
            p.setCedula(Integer.parseInt(txtcedula.getText()));

            if(func.editar(p))
            {
                JOptionPane.showMessageDialog(rootPane,"El paciente fue editado correctamente");
                mostrar("");
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(frmNuevoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNuevoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNuevoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNuevoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNuevoPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtlocalidad;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
