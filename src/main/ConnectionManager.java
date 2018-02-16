package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager extends IOException {

     private static ConnectionManager instance = null;

     private String url = "Jdbc:mysql://localhost:3306/asm?autoReconnect=true&&useSSl=false";
     private String user = "root";
     private String password = "";

     private Connection conn = null;

     private ConnectionManager(){}

     public static ConnectionManager getInstance(){
         if(instance == null) {
              instance = new ConnectionManager();
              System.out.println("instance initialized");
         }
          System.out.println("instance already initialized");
         return instance;
     }

     public boolean openConnection() throws SQLException {
          try{
               Class.forName("com.mysql.jdbc.Driver");
               conn = DriverManager.getConnection(url, user, password);
               return true;
          }catch (SQLException e){
               System.err.println(e.getMessage());
          } catch (ClassNotFoundException e) {
               e.printStackTrace();
          }
          return false;
     }

     public Connection getConnection() throws SQLException {
          if (conn == null){
               if (openConnection()) {
                    System.out.println("Connection opened.");
                    return conn;
               }else {
                    System.out.println("Connection refused to open.");
                    return null;
               }
          }else {
               return this.conn;
          }
     }

     public void close() throws SQLException {
          if (conn != null)
               conn.close();
     }
}
