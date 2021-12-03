package com.company;

import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.*;


import static com.company.ConnectionsDB.getConnectionPool;

public class ExecuteDB {

    public void insertDB(String equation, int answer, String timeStart, String timeEnd, int x) throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection connection = jdbcConnectionPool.getConnection();
        PreparedStatement preparedStatement = null;

        String Query = "INSERT INTO EQUATION" + "(equationName, answer,timeStart,timeEnd,x) values (`" + equation+"`,"+answer+",`"+timeStart+"`,`"+timeEnd+"`,"+x+")";
        String Query1 = "INSERT INTO EQUATION" + "(equationName, answer,timeStart,timeEnd,x) values" + "(?,?,?,?,?)";
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(Query);

            preparedStatement.setString(1, equation);
            preparedStatement.setInt(2, answer);
            preparedStatement.setString(3, timeStart);
            preparedStatement.setString(4, timeEnd);
            preparedStatement.setInt(5, x);
            preparedStatement.addBatch();

            connection.commit();
        } catch (BatchUpdateException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        }
        {
            preparedStatement.close();
            connection.close();
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
            //stmt.execute("CREATE TABLE PERSON(id int primary key, name varchar(255))");
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
            //stmt.execute("drop TABLE PERSON");
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