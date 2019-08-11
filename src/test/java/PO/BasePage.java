package test.java.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    Logger logger = LogManager.getLogger(this.getClass());
    Logger loggerForBase = LogManager.getLogger(BasePage.class);
    WebDriver driver;
    WebDriverWait wait;
    By contactsBtn = By.cssSelector(".callback-btn");


    BasePage(WebDriver driver) {
        loggerForBase.info("Initialize waiter");
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
}
