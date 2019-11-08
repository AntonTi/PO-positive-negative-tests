package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.java.Utils.PropertyLoader;

public class HomePage extends BasePage {

    By homePageHeader = By.xpath("(//h1[contains(text(), 'Мы - ITEA')])[1]");
    By eveningCoursesBtn = By.xpath("(//a[contains(text(), 'Вечерние курсы')])[1]");
    By eveningCoursesItem = By.xpath("(//a[contains(text(), 'Курсы')])[1]");
    By dayCoursesBtn = By.xpath("(//a[contains(text(), 'Дневное обучение')])[1]");
    By daycoursesItem = By.xpath("(//a[contains(text(), 'Курсы')])[2]");
    By contactsBtn = By.xpath("(//a[contains(text(), 'Контакты')])[1]");
    By footerID = By.xpath("//*[@id='footer']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Home Page is shown")
    public HomePage isShown() {
        logger.info("Home Page is shown");
        driver.manage().window().maximize();
        driver.get(PropertyLoader.getProperty("url"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homePageHeader));
        return this;
    }

    @Step("get Home Page Title")
    public String getTitle() {
        logger.info("get Home Page Title");
        String title = driver.getTitle();
        return title;
    }

    @Step("open Evening Courses Page")
    public HomePage openEveningCoursesPage() {
        logger.info("open Evening Courses Page");
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(eveningCoursesBtn));
        action.moveToElement(driver.findElement(eveningCoursesBtn)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(eveningCoursesItem));
        driver.findElement(eveningCoursesItem).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(footerID));
        return this;
    }

    @Step("open Day Courses Page")
    public HomePage openDayCoursesPage() {
        logger.info("open Day Courses Page");
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dayCoursesBtn));
        action.moveToElement(driver.findElement(dayCoursesBtn)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(daycoursesItem));
        driver.findElement(daycoursesItem).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(footerID));
        return this;
    }

    @Step("open Contacts Page")
    public HomePage openContactsPage() {
        logger.info("open Contacts Page");
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactsBtn));
        action.moveToElement(driver.findElement(contactsBtn)).click().build().perform();
        return this;
    }

    @Step("close Home Page")
    public HomePage Close() {
        logger.warn("close Home Page");
        driver.close();
        return this;
    }

}

