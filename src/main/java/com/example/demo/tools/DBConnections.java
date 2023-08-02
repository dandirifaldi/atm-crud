package com.example.demo.tools;

import java.sql.Connection;
import java.sql.*;

public class DBConnections {
    static final String DB_URL = "jdbc:mysql://localhost:3306/db_atm";
    static final String USER = "root";
    static final String PASS = "password";
    private Connection conn;

    public Connection getConnection() {
        try {
            // String sql = "Create Dabatase db_testing";
            // stat.executeUpdate(sql);
            this.conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // Statement stat = conn.createStatement();
            System.out.println("Database Connected ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
