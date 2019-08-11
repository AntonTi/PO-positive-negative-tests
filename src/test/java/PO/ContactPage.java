package test.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    By contactPageHeader = By.xpath("//h1[contains(text(), 'Контакты')]");
    By full_name = By.id("b-contacte__full-name");
    By phone = By.id("b-contacte-phone-tel");
    By submit = By.xpath("//input[@value='Отправить']");
    By message = By.xpath("//div[@class='b-header-contacte-phone-thank']");

    public ContactPage isShown() {
        logger.info("Open Contact Page");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(contactPageHeader));
        return this;
    }

    public ContactPage sendFillForm() {
        logger.info("Send Fill Form");
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
        logger.info("Get Form Message");
        String message_form = driver.findElement(message).getText();
        return message_form;
    }

    public ContactPage sendEmptyForm() {
        logger.info("Send Empty Form");
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        driver.findElement(submit).click();
        return this;
    }

    public String getFormEmptyMessage() {
        logger.info("Get Form Empty Message");
        String style = driver.findElement(full_name).getAttribute("style");
        return style;
    }

    public ContactPage Close() {
        logger.warn("Close Contact Page");
        driver.close();
        return this;
    }

}

