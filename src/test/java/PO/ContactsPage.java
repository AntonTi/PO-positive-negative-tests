package test.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ContactsPage extends BasePage {

    By contactsPageHeader = By.xpath("//h1[contains(text(), 'Контакты')]");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public ContactsPage isShown() {
        logger.info("Contact Page is Shown");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(contactsPageHeader));
        return this;
    }

    public ContactsPage Close() {
        logger.warn("Close Contact Page");
        driver.close();
        return this;
    }
}

