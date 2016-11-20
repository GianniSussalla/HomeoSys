/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class PPaciente {
    
    private conexion mysql = new conexion();
    private Connection cmd =mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar)
    {
        DefaultTableModel modelo;
        
        String [] titulos= {"cedula","nombre","direccion","localidad","telefono","celular","edad"};
        
        String[] registro= new String[8];
        
        totalregistros=0;
        modelo =new DefaultTableModel(null,titulos);
        
        sSQL = "select * from paciente where nombre like '%"+buscar+"%' order by cedula ";
        try
        {
            Statement st = cmd.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next())
            {
                registro[0]=rs.getString("cedula");
                registro[1]=rs.getString("nombre");
                registro[2]=rs.getString("direccion");
                registro[3]=rs.getString("localidad");
                registro[4]=rs.getString("telefono");
                registro[5]=rs.getString("celular");
                registro[6]=rs.getString("edad");
              //  registro[7]=rs.getString("fecha");
                
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
    public boolean insetar(Paciente dts)
    { 
            /*sSQL =" insert into paciente {cedula,nombre,direccion,localidad,telefono,celular,edad,fecha}"+
                "values{?,?,?,?,?,?,?,?}";*/
        sSQL =" insert into paciente (cedula,nombre,direccion,localidad,telefono,celular,edad)"+
                "values(?,?,?,?,?,?,?)";
        try 
        {
            PreparedStatement pst=cmd.prepareStatement(sSQL);
            pst.setInt(1, dts.getCedula());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getDireccion());
            pst.setString(4, dts.getLocalidad());
            pst.setInt(5, dts.getTelefono());
            pst.setInt(6, dts.getCelular());
            pst.setInt(7, dts.getEdad());
           // pst.setDate(8, dts.getFecha());
            
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
    
    public boolean editar(Paciente dts)
    { 
        sSQL ="update paciente set nombre=?,direccion=?,localidad=?,telefono=?,celular=?,edad=?"+
                "where cedula=?";
        try 
        {
            PreparedStatement pst=cmd.prepareStatement(sSQL);
            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getDireccion());
            pst.setString(3, dts.getLocalidad());
            pst.setInt(4, dts.getTelefono());
            pst.setInt(5, dts.getCelular());
            pst.setInt(6, dts.getEdad());
           // pst.setDate(7, dts.getFecha());
            pst.setInt(8, dts.getCedula());
            
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
    
    public boolean eliminar(Paciente dts)
    { 
        sSQL ="delete from paciente where cedula=?";
        try
        {
            PreparedStatement pst=cmd.prepareStatement(sSQL);
            pst.setInt(1, dts.getCedula());
            
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
            
}
