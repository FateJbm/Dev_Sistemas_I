/*
 * Juliano Bernardi - Todos os direitos reservados
 */
package util;
import java.sql.*;
import java.net.*;

/**
 * Trabalho de Desenvolvimento de Sistemas 1
 * @author Juliano Bernardi
 */

/**
* Realiza a conexão com o banco de dados MySQL

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
// @return Connection - Com o fonte ou externa de acordo com o setado
        return DriverManager.getConnection(fonte);
    }
    
}
