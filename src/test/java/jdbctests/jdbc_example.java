package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;

public class jdbc_example {
    String dbUrl = "jdbc:oracle:thin:@54.145.68.211:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    private void CountNavigate() throws SQLException {

        //create connection
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        //create statement object
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //run query and get the result in result set object
        //ResultSet resultSet=statement.executeQuery("Select * from regions");
        // ResultSet resultSet=statement.executeQuery("Select first_name,last_name,salary from employees");

        ResultSet resultSet=statement.executeQuery("Select * from departments");

//        ResultSet Methods
//        next()—> move to next row
//        previous()—> move to previous row
//        beforeFirst()—> goes before the first row
//        afterLast()—>goes after last row
//        getRow()—> get the current row number
//        last()—> moves to last row
//        absolute() —> goes specific row
        //how to find how many rows we have for the query
        //go to the last row
        resultSet.last();
        System.out.println(resultSet.getRow());
        resultSet.beforeFirst();
        while (resultSet.next()){
            System.out.println(resultSet.getString(2));

        }

        System.out.println("----------------------------");

        resultSet=statement.executeQuery("Select * from regions");

        while (resultSet.next()){
            System.out.println(resultSet.getString(2));

        }


        //close all connections
        resultSet.close();
        statement.close();
        connection.close();

    }
    @Test
    private void MetaDataExample() throws SQLException {

        //create connection
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        //create statement object
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //run query and get the result in result set object
        //ResultSet resultSet=statement.executeQuery("Select * from regions");
        // ResultSet resultSet=statement.executeQuery("Select first_name,last_name,salary from employees");

        ResultSet resultSet=statement.executeQuery("Select * from employees");


        //get the database related data inside the dbMetadata object
        DatabaseMetaData dbMetadata = connection.getMetaData();

        System.out.println("User =" + dbMetadata.getUserName());
        System.out.println("Database Product Name = " + dbMetadata.getDatabaseProductName());
        System.out.println("Database Product Version = " + dbMetadata.getDatabaseProductVersion());
        System.out.println("Driver Name = " + dbMetadata.getDriverName());
        System.out.println("Driver Version = " + dbMetadata.getDriverVersion());

        //get the resultset object metadata
        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        //how many columns we have ?
        int colCount = rsMetadata.getColumnCount();
        System.out.println(colCount);

       // column names
        //System.out.println(rsMetadata.getColumnName(1));
       // System.out.println(rsMetadata.getColumnName(2));

        for (int i = 1; i <=rsMetadata.getColumnCount() ; i++) {
            System.out.println(rsMetadata.getColumnName(i));

        }



        //close all connections
        resultSet.close();
        statement.close();
        connection.close();

    }
}
