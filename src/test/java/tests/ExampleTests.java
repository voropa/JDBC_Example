package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class ExampleTests{

    @BeforeMethod(alwaysRun = true)
    public void before() {
        System.out.println("Before runs always");
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        System.out.println("After runs always");
    }

    @BeforeMethod(onlyForGroups = {"AnotherGroupName"})
    public void setUp() {
        System.out.println("Runs only before AnotherGroupName tests");
    }

    @AfterMethod(onlyForGroups = {"AnotherGroupName"})
    public void tearDown() {
        System.out.println("Runs only after AnotherGroupName tests");
    }

    @Test (groups = {"Smoke", "AnotherGroupName"})
    public void test1() {
        System.out.println("test1");
    }

    @Test (groups = {"Smoke"})
    public void test2() {
        System.out.println("test2");
    }
}
