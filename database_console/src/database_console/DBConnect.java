/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_console;

//connection
//http://www.homeandlearn.co.uk/java/connect_to_a_database_using_java_code.html

/**
 *
 * @author jhovarie
 */

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //System.out.println("Connected");
            String host = "jdbc:derby://localhost:1527/Employees";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(host, username, password);
            
            Statement stmt = con.createStatement();
            stmt.executeUpdate("");
            //Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE );
            String SQL = "SELECT * FROM Workers";
            ResultSet rs = stmt.executeQuery(SQL);
            
            while(rs.next()) {
                int id_col = rs.getInt("ID");
                String first_name = rs.getString("First_Name");
                String last_name = rs.getString("Last_Name");
                String job = rs.getString("Job_Title");
                System.out.println( id_col + " " + first_name + " " + last_name + " " + job );
            }
            
        } catch (SQLException err) {
            System.out.println("You need to add derbyclient.jar as library");
            System.out.println(err.getMessage());
        }
    }
}
