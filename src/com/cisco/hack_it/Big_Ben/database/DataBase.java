package com.cisco.hack_it.Big_Ben.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    
    public static Connection getConnection() throws SQLException, 
            java.lang.ClassNotFoundException 
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://10.140.43.114:1111/hack_it";        
        String username = "zhenjuzh";
        String password = "cisco123";
        Connection con = DriverManager.getConnection(url, username, password);        
        return con;        
    }
    
    
    public static void main(String args[]) {
        try
        {
            Connection con = getConnection();            
            Statement sql_statement = con.createStatement();
            String query = "";            
            ResultSet result = sql_statement.executeQuery(query);
            System.out.println("data:");
            while (result.next()) 
            {
                int number          = result.getInt("id");
                String name      = result.getString("name");
                String mathScore = result.getString("math");
                System.out.println(" " + number + " " + name + " " + mathScore);                
            }
            sql_statement.close();
            con.close();
            
        } catch(java.lang.ClassNotFoundException e) {

            System.err.print("ClassNotFoundException");

            System.err.println(e.getMessage());
        } catch (SQLException ex) {

            System.err.println("SQLException: " + ex.getMessage());
        }
    }

}