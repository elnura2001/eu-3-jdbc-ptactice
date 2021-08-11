package jdbctests;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@34.228.41.120:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

        //create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        //create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("select * from regions");
        // we can use also another sql type like: "select * from departments"

        //move pointer to first row
        resultSet.next();
        //getting information with column name
        //System.out.println(resultSet.getString("region_name"));

        //getting information with column index(starts from 1)
        //System.out.println(resultSet.getString(2));

        //System.out.println(resultSet.getInt(1) + "-" + resultSet.getInt("region_name"));

        //move pointer to second row
        //resultSet.next();
        //getting information with column name
        //System.out.println(resultSet.getString("region_name"));
        //getting information with column index(starts from 1)
        //System.out.println(resultSet.getString(2));
        //System.out.println(resultSet.getInt(1) + "-" + resultSet.getInt("region_name"));

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + "-" + resultSet.getInt("region_name"));

            //close all connections
            resultSet.close();
            statement.close();
            connection.close();
        }
    }
}

