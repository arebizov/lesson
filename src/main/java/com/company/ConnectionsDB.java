package com.company;

import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.DeleteDbFiles;
//
import java.sql.*;

public class ConnectionsDB {

        private static final String DB_DRIVER = "org.h2.Driver";
        private static final String DB_CONNECTION = "jdbc:h2:~/test";
        private static final String DB_USER = "sa";
        private static final String DB_PASSWORD = "12345";

        // Create H2 JdbcConnectionPool
        public static JdbcConnectionPool getConnectionPool() {
            JdbcConnectionPool cp = null;
            try {
                Class.forName(DB_DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            cp = JdbcConnectionPool.create(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return cp;
        }
    }
