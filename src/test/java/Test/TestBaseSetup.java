package test.java.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseSetup {

    WebDriver driver;

    @BeforeMethod(description = "Initialize custom driver")
    public void init(ITestContext context) {
        driver = new ChromeDriver();
        context.setAttribute("webDriver", driver);
    }

    @AfterMethod(description = "Finalize custom driver")
    public void finalize() {
        driver.quit();
    }

}
