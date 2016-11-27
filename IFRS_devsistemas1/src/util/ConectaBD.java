/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.*;
import java.net.*;
/**
 *
 * @author Juliano
 */
public class ConectaBD {
    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");

        String fonte = "jdbc:mysql://127.0.0.1"  /*endereço do banco - conexao local*/
                 + ":" + "3306"       /*porta*/
                 + "/" + "devsistemas"        /*nome do banco*/
                 + "?user=" + "root"    /*usuario*/
                 + "&password=" + "FaTe160";    /*senha*/
        
        String externa = "jdbc:mysql:fatefatee.ddns.net"  /*endereço do banco - conexao ddns*/
                 + ":" + "1080"       /*porta*/
                 + "/" + "devsistemas"        /*nome do banco*/
                 + "?user=" + "root"
                 + "&password=" + "FaTe160";         
        /*javax.swing.JOptionPane.showMessageDialog(null, fonte);*/
        return DriverManager.getConnection(fonte);
    }
    
}
