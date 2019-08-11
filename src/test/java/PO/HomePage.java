package test.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.Utils.PropertyLoader;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By homePageHeader = By.xpath("//h1");
    By eveningCoursesBtn = By.id("menu-item-411");
    By eveningCoursesItem = By.id("menu-item-7880");
    By dayCoursesBtn = By.id("menu-item-7901");
    By daycoursesItem = By.id("menu-item-412");

    public HomePage isShown() {
        logger.info("Open Home Page");
        /*logger.debug("debug message");
        logger.warn("warn message");
        logger.error("error message");
        logger.fatal("fatal message");*/
        driver.manage().window().maximize();
        driver.get(PropertyLoader.getProperty("url"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homePageHeader));
        return this;
    }

    public HomePage openContactPage() {
        logger.info("Open Contact Page");
        wait.until(ExpectedConditions.elementToBeClickable(contactsBtn));
        driver.findElement(contactsBtn).click();
        return this;
    }

    public HomePage openEveningCoursesPage() {
        logger.info("open Evening Courses Page");
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(eveningCoursesBtn));
        action.moveToElement(driver.findElement(eveningCoursesBtn)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(eveningCoursesItem));
        driver.findElement(eveningCoursesItem).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//h2)[23]")));
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#course h2")));
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"course\"]/div//h2")));
        return this;
    }

    public HomePage openDayCoursesPage() {
        logger.info("Open Day Courses Page");
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dayCoursesBtn));
        action.moveToElement(driver.findElement(dayCoursesBtn)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(daycoursesItem));
        driver.findElement(daycoursesItem).click();
        return this;
    }

    public HomePage Close() {
        logger.warn("Close Home Page");
        driver.close();
        return this;
    }


}

