package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Метод повертає з'єднання
    public static void getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Successfully connected.");
    }

    public static void main(String[] args) throws SQLException {
        getConnection();
    }
}
