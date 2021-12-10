package com.company;

import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.*;
import java.time.LocalDateTime;

import static com.company.ConnectionsDbH2.getConnectionPool;
import static com.company.JDBCPostgreSQL.getConnection;

public class DbHandlerDml {
    public void initialize() throws SQLException {
        Connection connection = getConnection();

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

    public void insertDB(String name, String equation, int answer, LocalDateTime timeStart, LocalDateTime timeEnd, double x) throws SQLException {
        Connection connection = getConnection();
        String Query = "insert into EQUATION (name, equationName, answer,timeStart,timeEnd,x) values (?,?,?,?,?,?)";
        Statement stmt = null;
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(Query)) {
            stmt = connection.createStatement();
            connection.setAutoCommit(false);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, equation);
            preparedStatement.setInt(3, answer);
            preparedStatement.setTimestamp(4, Timestamp.valueOf(timeStart));
            preparedStatement.setTimestamp(5, Timestamp.valueOf(timeEnd));
            preparedStatement.setInt(6, (int) x);
            preparedStatement.execute();
            connection.commit();

            if (stmt != null) {

            }
        } catch (Exception e) {
            System.out.println("Connection Failed :");
            e.printStackTrace();
        }

    }

    ;

    public void dropTable() throws SQLException {
        Connection connection = getConnection();
        String Query = "DROP TABLE  if exists EQUATION ";
        Statement stmt = null;
        connection.setAutoCommit(false);
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(Query)) {
            stmt = connection.createStatement();
            preparedStatement.execute();
            connection.commit();

            if (stmt != null) {
                System.out.println("You table is Dropped");
            }
        } catch (Exception e) {
            System.out.println("Connection Failed :");
            e.printStackTrace();
        }

    }

    ;

    public void createTable() throws SQLException {
        Connection connection = getConnection();
        String Query = "create table if not exists EQUATION (name varchar(255), equationName varchar(255), answer int, timestart timestamp,timeend timestamp, x int)";
        Statement stmt = null;
        connection.setAutoCommit(false);
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(Query)) {
            stmt = connection.createStatement();
            if (stmt != null) {
                System.out.println("Table Created");
            }
            preparedStatement.execute();
            connection.commit();
        } catch (Exception e) {
            System.out.println("Failed connect");

            ;

        }

    }

    ;

    public void selectEquation() throws SQLException {
        Connection connection = getConnection();
        String Query = "select * from EQUATION;";
        Statement stmt = null;
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(Query)) {
            stmt = connection.createStatement();
            connection.setAutoCommit(false);
            preparedStatement.execute();
            connection.commit();

            if (stmt != null) {

                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {

                    String name = rs.getString("name");
                    String equationName = rs.getString("equationName");
                    int answer = rs.getInt("answer");
                    String timeStart = rs.getString("timeStart");
                    String timeEnd = rs.getString("timeEnd");
                    int x = rs.getInt("x");


                    System.out.println(name + "," + equationName + "," + answer + "," + timeStart + "," + timeEnd + "," + x);
                }

            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    ;
}