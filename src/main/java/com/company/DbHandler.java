package com.company;

//import org.h2.jdbcx.JdbcConnectionPool;

import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.*;

import static com.company.ConnectionsDbH2.getConnectionPool;

public class DbHandler {
    public void initialize() throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection connection = jdbcConnectionPool.getConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();

            if (stmt != null) {
                System.out.println("You connected to DB");
            }
        } catch (Exception e) {
            System.out.println("Connection Failed :");
            e.printStackTrace();
        }
    }

    ;

    public void insertDB(String equation, int answer, String timeStart, String timeEnd, int x) throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        String Query = "INSERT INTO EQUATION (equationName, answer,timeStart,timeEnd,x) values (?,?,?,?,?)";
        try (Connection connection = jdbcConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Query)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, equation);
            preparedStatement.setInt(2, answer);
            preparedStatement.setString(3, timeStart);
            preparedStatement.setString(4, timeEnd);
            preparedStatement.setInt(5, x);
            preparedStatement.execute();
            connection.commit();
        } catch (BatchUpdateException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            jdbcConnectionPool.dispose();
        }
    }

    public void createTable() throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection connection = jdbcConnectionPool.getConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE EQUATION ( equationName varchar(255), answer int, timestart varchar(255) ,timeend varchar(255), x int)");
            connection.commit();
        } catch (BatchUpdateException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            connection.close();
            jdbcConnectionPool.dispose();
        }
    }

    public void dropTable() throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection connection = jdbcConnectionPool.getConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("drop TABLE EQUATION");
            connection.commit();
        } catch (BatchUpdateException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            connection.close();
            jdbcConnectionPool.dispose();
        }
    }
}