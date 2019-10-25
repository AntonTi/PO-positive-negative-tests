package test.java.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    Logger logger = LogManager.getLogger(this.getClass());
    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        logger.info("Initialize waiter");
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

}
