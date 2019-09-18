package com.qa.database;

import com.qa.base.TestBase;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection extends TestBase {

    private static Connection connection = null;

    private void dbConnection() {
        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC Driver Registered!");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://172.16.36.39:6093/finmkt_d",
                    "finadmin",
                    "finadmin@321");

            if (connection != null) {
                System.out.println("You made it, take control your database now!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeQueries(){

            try {
                dbConnection();
                Statement stmt = connection.createStatement();

                /**
                 *  ExecuteQuery is use to fetch the data from database
                 *  and rs.next is count by row.
                 *
                 */
                ResultSet rs = stmt.executeQuery("Select * from fin.organization");
                while (rs.next()) {
                    //System.out.println(rs.getLong(1) + "   " + rs.getLong(2));
                    String s = rs.getString(7);
                    System.out.println(s);
                }
                connection.close();

                /**
                 *  ExecuteUpdate is use to update the data in database as well as delete
                 *
                 */
                // stmt.executeUpdate("");
            }catch (Exception e){
                e.printStackTrace();

        }


    }
}
