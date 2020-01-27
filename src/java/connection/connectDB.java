/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author OTME
 */
public class connectDB {
   
    public static Connection getCon() throws Exception
    {
        Connection connection = null;
        try {

                connection = DriverManager.getConnection(
                                "jdbc:postgresql://127.0.0.1:5432/EvaluationFinal", "postgres",
                                "root");
                
        } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
        }
        return connection;
    }
}
