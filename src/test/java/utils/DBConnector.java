package utils;

import java.sql.*;

public class DBConnector {
    private final static String MYSQL_USERNAME = PropertyReader.getProperty("mysql.username");
    private final static String MYSQL_PASSWORD = PropertyReader.getProperty("mysql.password");
    private Connection connect = null;
    private Statement statement = null;

    public void connect() {
        try {
/*            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/qa14?user=&password=#&useSSL=true&serverTimezone=GMT");*/
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/QA19", MYSQL_USERNAME, MYSQL_PASSWORD);

            // Statements allow issuing SQL queries to the database
            statement = connect.createStatement();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public ResultSet selectFrom(String tableName) {
        try {
            return statement
                    .executeQuery(String.format("select * from %s", tableName));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet select(String query) {
        try {
            return statement
                    .executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void test() {}

    // You need to close the resultSet
    public void close() {
        try {

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception ignored) {
        }
    }
}
