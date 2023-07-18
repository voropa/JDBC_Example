package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTests {

    DBConnector dbConnector;

    @BeforeClass
    public void initialize() {
        dbConnector = new DBConnector();
        dbConnector.connect();
    }

    @Test
    public void simpleTest() throws SQLException {
       ResultSet resultSet =  dbConnector.selectFrom("Students");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            //werwerr
            //werwerere
            //jkljklkjljljklkjl
            //dsfdsgfdggfg
            //dfgdfgfdgdg
            System.out.printf("ID: %s, Name: %s\n", id, name);
            // dhjgjdfhjhdfg
        }
    }

    @AfterClass
    public void tearDown() {
        dbConnector.close();
    }

    public String test2() {
        //dfgdffgdfgdg
        //dfgfdggfdg
        //dfgdfg
        return "qwe";
    }

    public void qwe() {
        //dgdfgdg
        //dfgdfgfdgdfg
        //dfgdfgfdgg
        //dfgdfgdfg
        //dfgdfgdfgfdg
        ///dfgdfgg
    }

}
