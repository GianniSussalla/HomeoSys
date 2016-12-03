/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Matud
 */

  import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbOperation {
       String url = "jdbc:mysql://localhost:3306/homeosys";
       String username = "roote";
       String password = "root";
       Connection con = null;
       PreparedStatement pst = null;
       ResultSet rs = null;

       public Connection backupDB(){
              try{
                  con=DriverManager.getConnection(url, username, password);
              }catch(SQLException e){
                  System.out.println(e.getMessage());
              }
       return con;
      }
}

