package utils;

import java.sql.*;

public class DBConnector {
    private final static String MYSQL_USERNAME = PropertyReader.getProperty("mysql.username");
    private final static String MYSQL_PASSWORD = PropertyReader.getProperty("mysql.password");

    private Connection connect;
    private Statement statement;

    public void connect() {
        try {
/*            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/QA24?user=&password=&useSSL=true&serverTimezone=GMT");*/
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/QA24", MYSQL_USERNAME, MYSQL_PASSWORD);

            // Statements allow issuing SQL queries to the database
            statement = connect.createStatement();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public ResultSet select(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
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

    public boolean createStudent(String name, String groupId) {
        try {
            return statement.execute(
                    String.format("INSERT INTO Students(name, group_id) VALUES ('%s', '%s')", name, groupId));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean createStudent2(String Name, int Age, int groupId) {
        try {
            PreparedStatement preparedStatement =
                    connect.prepareStatement("UPDATE Students(Name, Age, GroupId) VALUES (?,?,?)");
            preparedStatement.setString(1, Name);
            preparedStatement.setInt(2, Age);
            preparedStatement.setInt(3, groupId);
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean updateStudent(int studentId, String newName) {
        try {
            PreparedStatement preparedStatement =
                    connect.prepareStatement("UPDATE Students SET Name = ? WHERE Id = ?");
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, studentId);
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

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