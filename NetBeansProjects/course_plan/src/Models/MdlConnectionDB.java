/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gurkay
 */
public class MdlConnectionDB {
    private final String url = "jdbc:postgresql://localhost:5432/course_plan";
    private final String user = "root";
    private final String password = "root";

    Connection conn;

    public Connection openConnection() throws ClassNotFoundException {
        try {
            
            conn = DriverManager.getConnection(url, user, password);
            
            System.out.println("Database connected to the database successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); 
        }
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }   
}
