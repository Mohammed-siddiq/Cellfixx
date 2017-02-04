/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellfixx.solutions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohammed Siddiq
 */
public class Dbc {
    
     Connection con=null;
    public static Connection connect_db() throws SQLException
    {
         try {
             Class.forName("org.sqlite.JDBC");
             Connection con=DriverManager.getConnection("jdbc:sqlite:cellfixx.sqlite");
            
             return con;
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, ex);
             
             return null;
         }
         
    }
    public static ResultSet fetch_shop(Connection con) throws SQLException
    {
        
        String sql="select * from Shop";
        PreparedStatement ps=con.prepareStatement(sql);
      
            ResultSet rs=ps.executeQuery();
            
            return rs;
       
    }
    public static int getrowcount(ResultSet rs) throws SQLException
    {
        rs.last();
        return rs.getRow();
    }
    
    
}
