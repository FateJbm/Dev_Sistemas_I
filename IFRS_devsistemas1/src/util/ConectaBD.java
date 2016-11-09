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
 * @author ricardo
 */
public class ConectaBD {
    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");

        String fonte = "jdbc:mysql://192.168.2.19"  /*endereço do banco*/
                 + ":" + "3306"       /*porta*/
                 + "/" + "ifrs_dev_sistemas_1"        /*nome do banco*/
                 + "?user=" + "fate"
                 + "&password=" + "12345";
        
        String externa = "jdbc:mysql://200.132.7.1"  /*endereço do banco*/
                 + ":" + "1080"       /*porta*/
                 + "/" + "ads-db-03"        /*nome do banco*/
                 + "?user=" + "ads-db-03"
                 + "&password=" + "_aZ4y4";         
        /*javax.swing.JOptionPane.showMessageDialog(null, fonte);*/
        return DriverManager.getConnection(fonte);
    }
    
}
