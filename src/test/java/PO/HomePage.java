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

    By homePageHeader = By.xpath("(//h1[contains(text(), 'Мы - ITEA')])[1]");
    By eveningCoursesBtn = By.xpath("(//a[contains(text(), 'Вечерние курсы')])[1]");
    By eveningCoursesItem = By.xpath("(//a[contains(text(), 'Курсы')])[1]");
    By dayCoursesBtn = By.xpath("(//a[contains(text(), 'Дневное обучение')])[1]");
    By daycoursesItem = By.xpath("(//a[contains(text(), 'Курсы')])[2]");
    By footerID = By.xpath("//*[@id='footer']");
    By priceHolder = By.xpath("//li[@class='r-total-price-wrapper']//span");

    public HomePage isShown() {
        logger.info("Open Home Page");
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
        wait.until(ExpectedConditions.elementToBeClickable(eveningCoursesItem));
        driver.findElement(eveningCoursesItem).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(footerID));
        return this;
    }

    public HomePage openDayCoursesPage() {
        logger.info("Open Day Courses Page");
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dayCoursesBtn));
        action.moveToElement(driver.findElement(dayCoursesBtn)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(daycoursesItem));
        driver.findElement(daycoursesItem).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(footerID));
        return this;
    }

    public HomePage openCourse(String name) {
        logger.info(String.format("Open course '%s'", name));
        By course = By.xpath(String.format("//h2[text()='%s']/..//a[text()='Просмотреть']", name));
        wait.until(ExpectedConditions.elementToBeClickable(course));
        driver.findElement(course).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-filter='.course-list']")));
        return this;
    }

    public int getCoursePrice() {
        wait.until(ExpectedConditions.presenceOfElementLocated(priceHolder));
        String rawPrice = driver.findElement(priceHolder).getText();
        int price = Integer.parseInt(rawPrice.substring(0, rawPrice.indexOf(" ")));
        return price;
    }

    public HomePage Close() {
        logger.warn("Close Home Page");
        driver.close();
        return this;
    }


}

