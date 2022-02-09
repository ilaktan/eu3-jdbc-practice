package jdbctests;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@54.145.68.211:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

        //create connection
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        //create statement object
        Statement statement=connection.createStatement();

        //run query and get the result in result set object
        //ResultSet resultSet=statement.executeQuery("Select * from regions");
       // ResultSet resultSet=statement.executeQuery("Select first_name,last_name,salary from employees");

        ResultSet resultSet=statement.executeQuery("Select * from departments");


//
//        //move pointer to first row
//        resultSet.next();
//        //getting information with column name
//        System.out.println(resultSet.getString("region_name"));
//        //getting information with column index (starts from 1)
//        System.out.println(resultSet.getString(2));
//        System.out.println(resultSet.getInt(1)+" - "+resultSet.getString(2));
//
//
//        //move pointer to second row
//        resultSet.next();
//        System.out.println(resultSet.getString("region_name"));
//        System.out.println(resultSet.getString(2));
//        //task "1 - Europe"
//        //"2-Americas"
//
//        System.out.println(resultSet.getString(1)+" - "+resultSet.getString(2));
//
//        resultSet.next();
//        System.out.println(resultSet.getString(1)+" - "+resultSet.getString(2));


//        while (resultSet.next()){
//            System.out.println(resultSet.getString(1)+" - "+resultSet.getString(2));
//
//        }
//
//        while (resultSet.next()){
//            System.out.println(resultSet.getString(1)+" - "+resultSet.getString(2)+" - "+resultSet.getString(3));
//
//        }

        while (resultSet.next()){
            System.out.println(resultSet.getString(1)+" - "+resultSet.getString(2)+" - "+resultSet.getString(3)+" - "+resultSet.getString(4));

        }









        //close all connections
        resultSet.close();
        statement.close();
        connection.close();
    }
}
