/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class PConsulta {
    
    private conexion mysql = new conexion();
    private Connection cmd =mysql.conectar();
    private String sSQL="";
    
    
     public boolean insetar(Consulta dts)
    { 
       
        sSQL =" insert into consulta (idConsulta,fecha,nombre,cedula,edad,observaciones)"+
                "values(?,?,?,?,?,?)";
       
        try 
        {
            PreparedStatement pst=cmd.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdConsulta());
            
            java.util.Date fecha = null;
            fecha = (dts.getFecha());
                java.sql.Date fechaP= new java.sql.Date(fecha.getTime());
                pst.setDate(2, fechaP);
                
            pst.setString(3, dts.getNombre());
            pst.setInt(5, dts.getEdad());
            pst.setInt(4, dts.getCedula());
            pst.setString(6, dts.getObservaciones());
            
            
            
            int n = pst.executeUpdate();
            
            if(n!=0)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            System.out.println(e.toString());
            return false;
        }
    }
     /*
     public Mozo buscarMozo(int cedula) {
        Mozo mozo = null;
        Connection conex1 = conectar.getInstancia().getConexion();


        try {
            PreparedStatement pst1 = conex1.prepareStatement("SELECT * FROM mozo WHERE cedula=? and borrado=?");

            pst1.setString(1, String.valueOf(cedula));
            pst1.setBoolean(2, false);
            ResultSet res = pst1.executeQuery();


            if (res.next()) {
                mozo = new Mozo();
                mozo.setCedula(cedula);
                mozo.setNombre(res.getString("nombre"));
                mozo.setApellido(res.getString("apellido"));
                mozo.setTelefono(Integer.parseInt(res.getString("telefono")));
                mozo.setBorrado(res.getBoolean("borrado"));


            }




        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaPlatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }


        return mozo;
    }
     */
    public Consulta buscarConsulta(int cedula)
     {
         sSQL = "select * from consulta where cedula like ?";
         Consulta c = null;

         try
         {
             PreparedStatement pst=cmd.prepareStatement(sSQL);
             pst.setString(1, String.valueOf(cedula));
             
              ResultSet res = pst.executeQuery();
              while(res.next())
              {
                  c= new Consulta();
                  c.setIdConsulta(res.getInt("idConsulta"));
                  c.setFecha(res.getDate("fecha"));
                  c.setNombre(res.getString("nombre"));
                  c.setEdad(res.getInt("edad"));
                  c.setObservaciones(res.getString("observaciones"));
              }
              res.close();      
         }
         catch(Exception e)
         {
             javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
         }
        
         return c;
         
     }
}
