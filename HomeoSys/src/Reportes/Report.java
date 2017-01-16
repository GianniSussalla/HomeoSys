/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Matud
 */
public class Report {
       private Report() {
    }
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String RUTA = "jdbc:mysql://localhost/homeosys";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static Connection CONEXION;

   

  
public static void reportEstadiaEntreDosFechas(int ci, java.util.Date fecha) {

                //java.sql.Timestamp f1 = new java.sql.Timestamp(fecha1.getTime());
                //java.sql.Timestamp f2 = new java.sql.Timestamp(fecha2.getTime());

        try {
            Class.forName(DRIVER);
            CONEXION = DriverManager.getConnection(RUTA, USER, PASSWORD);
            javax.swing.JOptionPane.showMessageDialog(null, "Conexion establecida");


            Map parametro = new HashMap();
           
            parametro.put("ci", ci);
            parametro.put("fecha",fecha);
            JasperReport reporte = JasperCompileManager.compileReport("C:\\Users\\Matud\\Documents\\HomeoSys\\HomeoSys\\src\\Reportes\\consultas.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, CONEXION);
            JFrame f = new JFrame();
            JRViewer visor = new JRViewer(print);
            f.setContentPane(visor);
            f.setVisible(true);
            f.setSize(800, 600);
            // JasperReport reporte = JasperCompileManager.compileReport("ReporteMaquinasGarantiaVencida.jrxml");



        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e);

        }
    }
    
}
