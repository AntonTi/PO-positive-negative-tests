package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ContactsPage extends BasePage {

    By contactsPageHeader = By.xpath("//h1[contains(text(), 'Контакты')]");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Contacts Page is shown")
    public ContactsPage isShown() {
        logger.info("Contacts Page is shown");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(contactsPageHeader));
        return this;
    }

    @Step("get Contacts Page Title")
    public String getTitle() {
        logger.info("get Contacts Page Title");
        String title = driver.getTitle();
        return title;
    }

    @Step("close Contacts Page")
    public ContactsPage Close() {
        logger.warn("close Contacts Page");
        driver.close();
        return this;
    }
}

