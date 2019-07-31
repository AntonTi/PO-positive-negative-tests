package Test;

import PO.ContactPage;
import PO.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GenTest {
    HomePage homePage;
    ContactPage contactPage;
    WebDriver driver;

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver"
                , "D:\\Download\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
    }


    @Test
    //positive test callback form
    public void test1FormCheck() {
        homePage.isShown();
        homePage.openContactPage();
        homePage.sendFillForm();

        assertEquals(homePage.getFormMessage(),
                "Спасибо!\n" + "Наш менеджер свяжется с Вами.");
    }

   @Test
    //negative callback test form
    public void test2FormCheck() {
        homePage.isShown();
        homePage.openContactPage();
        homePage.sendEmptyForm();

        assertEquals(homePage.getFormEmptyMessage(),
                "border-color: red;");
    }


    @AfterMethod
    public void finilize()
    {
        driver.quit();
    }
}
