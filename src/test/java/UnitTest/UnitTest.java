package test.java.UnitTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UnitTest {

    Tasks tasks = new Tasks();

    @Test(dataProvider = "minValueData")
    public void checkMinValue(int actual, int expect) {
        assertEquals(actual, expect,
                String.format("Min value is incorrect. Expected '%d' - Actual '%d'\n", expect, actual));
    }

    @DataProvider
    public Object[][] minValueData() {
        return new Object[][]{
                {tasks.minValue(5, 2, 3), 2},
                {tasks.minValue(2, 5, 3), 2},
                {tasks.minValue(3, 2, 5), 2},
                {tasks.minValue(2, 3, 5), 2},
                {tasks.minValue(0, 2, 3), 0},
                {tasks.minValue(5, 0, -2), -2},
                {tasks.minValue(-5, -2, -3), -5}
        };
    }

    @Test(dataProvider = "validateAgeData")
    public void validateAge(int age, String expectedMessage) {
        String actualMessage = tasks.validateAge(age);
        assertEquals(actualMessage, expectedMessage,
                String.format("Expected with age '%d' should be message '%s'\n", age, expectedMessage));
    }

    @DataProvider
    public Object[][] validateAgeData() {
        return new Object[][]{
                {1, "Too young"},
                {10, "Too young"},
                {17, "Too young"},
                {18, "Welcome!"},
                {35, "Welcome!"},
                {89, "Welcome!"},
                {90, "Too old"},
                {100, "Too old"}
        };
    }

}
