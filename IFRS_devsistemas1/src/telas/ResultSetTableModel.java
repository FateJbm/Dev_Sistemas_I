/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import util.ConectaBD;

// Linhas e colunas do ResultSet são contadas a partir de 1 e linhas e
// colunas JTable são contadas a partir de 0. Ao processar
// linhas ou colunas de ResultSet para utilização em uma JTable, é
// necessário adicionar 1 ao número de linha ou coluna para manipular
// a coluna apropriada de ResultSet (isto é, coluna 0 de JTable é a
// coluna de ResultSet 1 e a linha de JTable 0 é a linha de ResultSet 1).
public class ResultSetTableModel extends AbstractTableModel
{
   private Connection connection;
   private Statement statement;
   private ResultSet resultSet;
   private ResultSetMetaData metaData;
   private int numberOfRows;

   // monitora o status da conexão de banco de dados
   private boolean connectedToDatabase = false;
   
   // construtor inicializa resultSet e obtém seu objeto de metadados;
   // determina número de linhas
   public ResultSetTableModel( String query ) 
      throws SQLException, ClassNotFoundException
   {
      // conecta-se ao banco de dados
      connection = ConectaBD.getConnection();
      // cria Statement para consultar banco de dados
      statement = connection.createStatement(
         ResultSet.TYPE_SCROLL_INSENSITIVE,   
         ResultSet.CONCUR_READ_ONLY );        

      // atualiza status de conexão de banco de dados 
      connectedToDatabase = true;         

      // configura consulta e a executa
      setQuery( query );
   } // fim do construtor ResultSetTableModel 

   // obtém a classe que representa o tipo de coluna
   public Class getColumnClass( int column )throws IllegalStateException
   {
      // assegura que o banco de dados conexão está disponível
      if ( !connectedToDatabase )                                       
         throw new IllegalStateException( "Not Connected to Database" );

      // determina a classe Java de coluna
      try 
      {
         String className = metaData.getColumnClassName( column + 1 );
         
         // retorna objeto Class que representa className
         return Class.forName( className );              
      } // fim do try
      catch ( Exception exception ) 
      {
         exception.printStackTrace();
      } // fim do catch
      
      return Object.class; // se ocorrerem os problemas acima, assume tipo Object
   } // fim do método getColumnClass 

   // obtém número de colunas em ResultSet
   public int getColumnCount()throws IllegalStateException
   {   
      // assegura que o banco de dados conexão está disponível
      if ( !connectedToDatabase ) 
         throw new IllegalStateException( "Not Connected to Database" );

      // determina número de colunas
      try 
      {
         return metaData.getColumnCount(); 
      } // fim do try
      catch ( SQLException sqlException ) 
      {
         sqlException.printStackTrace();
      } // fim do catch
      
      return 0; // se ocorrerem os problemas acima, retorna 0 para o número de colunas
   } // fim do método getColumnCount 

   // obtém nome de uma coluna particular em ResultSet
   public String getColumnName( int column )throws IllegalStateException
   {    
      // assegura que o banco de dados conexão está disponível
      if ( !connectedToDatabase ) 
         throw new IllegalStateException( "Not Connected to Database" );

      // determina o nome de coluna
      try 
      {
         return metaData.getColumnName( column + 1 );  
      } // fim do try
      catch ( SQLException sqlException ) 
      {
         sqlException.printStackTrace();
      } // fim do catch
      
      return ""; // se ocorrerem problemas, retorna string vazia para nome de coluna
   } // fim do método getColumnName

   // retorna número de linhas em ResultSet
   public int getRowCount()throws IllegalStateException
   {      
      // assegura que o banco de dados conexão está disponível
      if ( !connectedToDatabase ) 
         throw new IllegalStateException( "Not Connected to Database" );
 
      return numberOfRows;
   } // fim do método getRowCount 

   // obtém valor na linha e coluna particular
   public Object getValueAt( int row, int column )
      throws IllegalStateException
   {
      // assegura que o banco de dados conexão está disponível
      if ( !connectedToDatabase ) 
         throw new IllegalStateException( "Not Connected to Database" );

      // obtém um valor na linha e coluna de ResultSet especificada 
      try 
      {
         resultSet.absolute( row + 1 );
         return resultSet.getObject( column + 1 );
      } // fim do try
      catch ( SQLException sqlException ) 
      {
         sqlException.printStackTrace();
      } // fim do catch
      
      return ""; // se ocorrerem problemas, retorna objeto string vazio
   } // fim do método getValueAt 
   
   // configura nova string de consulta de banco de dados
   public void setQuery( String query ) 
      throws SQLException, IllegalStateException 
   {
      // assegura que o banco de dados conexão está disponível
      if ( !connectedToDatabase ) 
         throw new IllegalStateException( "Not Connected to Database" );

      // especifica consulta e a executa
      resultSet = statement.executeQuery( query );

      // obtém metadados para ResultSet
      metaData = resultSet.getMetaData(); 

      // determina o número de linhas em ResultSet
      resultSet.last();                   // move para a última linha
      numberOfRows = resultSet.getRow();  // obtém número de linha
      //JOptionPane.showMessageDialog(null,"Linhas " + numberOfRows);
      // notifica a JTable de que modelo foi alterado
      fireTableStructureChanged();           
   } // fim do método setQuery 

   // fecha Statement e Connection
   public void disconnectFromDatabase()            
   {                                               
      if ( !connectedToDatabase )                  
         return;                                   
                                                   
      // fecha Statement e Connection
      try                                          
      {                                            
         statement.close();                        
         connection.close();                       
      } // fim do try
      catch ( SQLException sqlException )          
      {                                            
         sqlException.printStackTrace();           
      } // fim do catch
      finally  // atualiza status de conexão de banco de dados 
      {                                            
         connectedToDatabase = false;              
      } // fim do finally                            
   } // fim do método disconnectFromDatabase 
}  // fim da classe ResultSetTableModel 


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
    

