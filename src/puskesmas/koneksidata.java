package puskesmas;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rizky
 */
public class koneksidata {
        
    public static Connection configDB(){
        Connection connection = null;
        String driver = "com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/puskesmas";
            String user="root";
            String pass="";
            if(connection == null){
        try{
            Class.forName(driver);
            
            connection=DriverManager.getConnection(url, user, pass);
        } catch (Exception e){
            System.exit(0);
        }
            }
        return connection;
    }
}
