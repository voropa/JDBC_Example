package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DBConnector;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTests {

    DBConnector dbConnector;
    int age;

    @BeforeClass
    public void initialize() {
       dbConnector = new DBConnector();
       dbConnector.connect();
    }

    @AfterClass
    public void tearDown() {
        dbConnector.close();
    }

    @Test
    public void test11() throws SQLException {
        ResultSet resultSet = dbConnector.select("SELECT Name, id FROM Students WHERE Name like 'A%'");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Name"));
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getInt(5));
        };
    }

    @Test
    public void test33() {
        dbConnector.updateStudent(4, "NewAlex");
    }

    @Test
    public void test1() throws SQLException {
        ResultSet result = dbConnector.select("SELECT * FROM Students WHERE StudentId =1");
        if(result.next()) {
            System.out.println(result.getString("FirstName"));
            System.out.println(result.getString("LastName"));
            System.out.println(result.getInt("Age"));
        }
        if(result.next()) {
            System.out.println(result.getInt("Age"));
        }
    }

    @Test
    public void test2() throws SQLException {
        ResultSet resultSet = dbConnector.selectFrom("Students");
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            int groupId = resultSet.getInt("group_id");
            int age = resultSet.getInt("Age");
            boolean married = resultSet.getBoolean("Married");
            System.out.printf("Id: %d, Fname: %s, LName: %s GroupId: %d, Married: %b, Age: %d\n", id, firstName,lastName, groupId, married, age);
        }
    }



    @Test
    public void simpleTest() throws SQLException {
        // boolean result = dbConnector.createStudent2("QWEWQE", "ASDSD", 1);
        ResultSet resultSet = dbConnector.selectFrom("Students");
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            int groupId = resultSet.getInt("group_id");
            int age = resultSet.getInt("Age");
            boolean married = resultSet.getBoolean("Married");
            System.out.printf("Id: %d, Fname: %s, LName: %s GroupId: %d, Married: %b, Age: %d\n", id, firstName,lastName, groupId, married, age);
        }
    }



}
