package com.company;

import java.sql.*;

import static com.company.JDBCPostgreSQL.getConnection;

public class DbHandlerDdl {

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

    }
