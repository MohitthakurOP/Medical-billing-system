package com.billing.MedcialBillingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn{
    private Connection connection;
    private Statement statement;

    public Conn() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3305/medical_billing_system", "root", "admin@123");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database", e);

        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {

        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement prepareStatement(String query) {
        try {
            return connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // or handle the exception as appropriate for your application
        }
    }

	public Statement createStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
