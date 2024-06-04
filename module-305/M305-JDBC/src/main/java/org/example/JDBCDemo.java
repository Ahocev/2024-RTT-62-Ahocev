package org.example;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        String dburl = "jdbc:mysql://127.0.0.1:3306/classic_models";
        String user = "root";
        String password = "0Je5us01!";
        System.out.println("-------- MySQL JDBC Connection Demo ------------");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, user, password);

            System.out.println("Enter what you want to search for: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String lastnameInput = "Doe";
            int idInput = 1002;

            String selectSQL = "Select * FROM employees where firstname = ? or lastname = ? or id = ?";

            PreparedStatement stmt = connection.prepareStatement(selectSQL);
            stmt.setString(1, input);
            stmt.setString(2, lastnameInput);
            stmt.setInt(3, idInput);

            ResultSet result =  stmt.executeQuery();

            while(result.next())
            {
                String employeeID  = result.getString("id");
                String fname = result.getString("firstname");
                String lname  = result.getString("lastname");
                String email  = result.getString("email");
                String job_title  = result.getString("job_title");
                // Define the format string
                String format = "%-10s | %-15s | %-15s | %-35s | %-20s%n";
                // Use printf to format the output
                System.out.printf(format, employeeID, fname, lname, email, job_title);
            }
            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
