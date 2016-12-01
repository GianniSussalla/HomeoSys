/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Localidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grfc
 */
public class LLocalidad {
    
    private static LLocalidad instancia = null;
    public static LLocalidad getInstancia() {
        if (instancia == null) {
            instancia = new LLocalidad();
        }
        return instancia;
    }
    private conexion mysql = new conexion();
    private Connection cmd =mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
      public DefaultTableModel mostrar(String buscar)
    {
        DefaultTableModel modelo;
        
        String [] titulos= {"codigo","descripcion"};
        
        String[] registro= new String[8];
        
        totalregistros=0;
        modelo =new DefaultTableModel(null,titulos);
        
        sSQL = "select * from localidad where descripcion like '%"+buscar+"%' order by codigo ";
        try
        {
            Statement st = cmd.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next())
            {
                registro[0]=rs.getString("codigo");
                registro[1]=rs.getString("descripcion");
                
                
                totalregistros = totalregistros+1;
                modelo.addRow(registro);
            }
            return  modelo;
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }       
    public boolean insetar(Localidad dts)
    { 
            
        sSQL ="insert into localidad(codigo,descripcion)"+
                "values(?,?)";
        try 
        {
            PreparedStatement pst=cmd.prepareStatement(sSQL);
            pst.setString(1, dts.getCodigo());
            pst.setString(2, dts.getDescripcion());
          
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
     public boolean editar(Localidad dts)
    { 
        sSQL ="update localidad set codigo=?,descripcion=?"+
                "where codigo=?";
        try 
        {
            PreparedStatement pst=cmd.prepareStatement(sSQL);
            
            pst.setString(1, dts.getCodigo());
            pst.setString(2, dts.getDescripcion());
            
            
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
            return false;
        }
    }
    
     public List<Localidad> getLocalidad() {
        List<Localidad> lista = new ArrayList<Localidad>();
        Localidad l = null;
        try {
            Connection conex = conexion.getInstancia().getConexion();
            PreparedStatement pst=cmd.prepareStatement(sSQL);
            ResultSet res = pst.executeQuery("select * from localidad");
            while (res.next()) {
                l = new Localidad();
              l.setCodigo(res.getString("codigo"));
              l.setDescripcion(res.getString("descripcion"));
              
                lista.add(l);
                
            
            }
            res.close();
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return lista;
    }
   
}
