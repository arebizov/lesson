package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCPostgreSQL {

    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "postgres";

    public  static Connection getConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection to Data Base");
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();

        }
        return connection;

        }
    }

