package com.company;
import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.tools.DeleteDbFiles;


import java.sql.*;
import java.util.Scanner;

import static com.company.ConnectionsDB.getConnectionPool;


// H2 Database ConnectionPool Example
public class H2DatabaseConnectionPoolExample{

 public static void main(String[] args) throws Exception {

        try {
            // delete the database named 'test' in the user home directory for initialization
            DeleteDbFiles.execute("~", "test", true);
           batchInsertWithStatement();
           batchInsertWithPreparedStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      public static void batchInsertWithPreparedStatement() throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection connection = jdbcConnectionPool.getConnection();
        PreparedStatement preparedStatement = null;
class Person {
    private  String  as = "sdfsdf";
    public Person(String as){
        this.as=as;
    }


}

        String Query = "INSERT INTO PERSON" + "(id, name) values" + "(?,?)";
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(Query);
            Scanner scanner = new Scanner(System.in);
            String s =scanner.nextLine();


            preparedStatement.setInt(1,3);
            preparedStatement.setString(2, s);
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "Jacky");
            preparedStatement.addBatch();

            int[] countWithoutException = preparedStatement.executeBatch();
            System.out.println("OK: countWithoutException = " + countWithoutException.length);
            connection.commit();
        } catch (BatchUpdateException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
            jdbcConnectionPool.dispose();
        }
    }

    private static void batchInsertWithStatement() throws SQLException {
        JdbcConnectionPool jdbcConnectionPool = getConnectionPool();
        Connection connection = jdbcConnectionPool.getConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE PERSON(id int primary key, name varchar(255))");
            //list.add(new Equations(str.toString(), input, timeStart.toString(), timeEnd.toString(), x));
            stmt.execute("CREATE TABLE Equations1 ( name varchar(255), input int, datestart varchar(255) ,dateend varchar(255), x int)");
            //stmt.addBatch("INSERT INTO PERSON(id, name) VALUES(1, 'A1')");
            //stmt.addBatch("INSERT INTO PERSON(id, name) VALUES(2, 'B')");
            //stmt.addBatch("INSERT INTO PERSON(id, name) VALUES(3, 'C')");

            int[] countWithoutException = stmt.executeBatch();
            System.out.println("OK: countWithoutException = " + countWithoutException.length);

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