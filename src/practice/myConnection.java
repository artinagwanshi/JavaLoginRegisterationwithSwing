/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;
import java.sql.*;
/**
 *
 * @author user1
 */
public class myConnection {
    public static Connection getConnection()
    {
        Connection con = null;
        
        try{        
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","root"); 
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return con;
    }
}