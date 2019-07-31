package PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    By contactsBtn = By.cssSelector(".callback-btn");
    By full_name = By.id("b-contacte__full-name");
    By phone = By.id("b-contacte-phone-tel");
    By submit = By.xpath("//input[@value='Отправить']");
    By message = By.xpath("//div[@class='b-header-contacte-phone-thank']");

    public HomePage isShown() {
        driver.manage().window().maximize();
        driver.get("http://iteaua-develop.demo.gns-it.com/ru/");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(contactsBtn));
        return this;
    }

    public HomePage openContactPage() {
        wait.until(ExpectedConditions.elementToBeClickable(contactsBtn));
        driver.findElement(contactsBtn).click();
        return this;
    }

    public HomePage sendFillForm() {
        wait.until(ExpectedConditions.elementToBeClickable(phone));
        driver.findElement(full_name).sendKeys("testAnton");
        driver.findElement(phone).click();
        driver.findElement(phone).sendKeys("0501234567");
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        driver.findElement(submit).click();
        wait.until(ExpectedConditions.elementToBeClickable(message));
        return this;
    }

    public String getFormMessage() {
        String message_form = driver.findElement(message).getText();
        return message_form;
    }

    public HomePage sendEmptyForm() {
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        driver.findElement(submit).click();
        return this;
    }

    public String getFormEmptyMessage(){
        String style = driver.findElement(By.id("b-contacte__full-name")).getAttribute("style");
        return style;
    }


}

