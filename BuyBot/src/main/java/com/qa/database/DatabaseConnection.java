package com.qa.database;

import com.qa.base.TestBase;
import com.qa.configuration.ConfigManager;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection extends TestBase {

    private static Connection connection = null;

    private void dbConnection() {
        System.out.println("-------- DB2 "
                + "JDBC Connection Testing ------------");

        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            System.out.println("DB2 JDBC Driver Registered!");
            connection = DriverManager.getConnection(
                    "jdbc:db2://172.16.2.197:60000/RADB_UAT",
                    "db2inst1",
                    "Db2inst1");

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
                ResultSet rs = stmt.executeQuery("SELECT AUCTIONNOTICE_ID FROM EPS.AUCTIONNOTICE WHERE RFQNO = '1_Auto'");
                while (rs.next()) {
                    //System.out.println(rs.getLong(1) + "   " + rs.getLong(2));
                    String s = rs.getString(1);
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
