package test.java.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.PO.ContactPage;
import test.java.PO.DayCoursesPage;
import test.java.PO.EveningCoursesPage;
import test.java.PO.HomePage;

import static org.testng.Assert.*;

public class GenTest {
    HomePage homePage;
    ContactPage contactPage;
    DayCoursesPage dayCoursesPage;
    EveningCoursesPage eveningCoursesPage;
    WebDriver driver;

    @BeforeMethod(description = "Initialize custom driver")
    public void init(ITestContext context) {
        System.setProperty("webdriver.chrome.driver"
                , "D:\\Download\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        context.setAttribute("webDriver", driver);
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
        dayCoursesPage = new DayCoursesPage(driver);
        eveningCoursesPage = new EveningCoursesPage(driver);
    }


    @Test(description = "positive test callback form")
    public void test1FormCheck() {
        homePage.isShown();
        homePage.openContactPage();
        contactPage.sendFillForm();

        assertEquals(contactPage.getFormMessage(),
                "Спасибо!\n" + "Наш менеджер свяжется с Вами.");
    }

    @Test(description = "negative callback test form")
    public void test2FormCheck() {
        homePage.isShown();
        homePage.openContactPage();
        contactPage.sendEmptyForm();

        assertEquals(contactPage.getFormEmptyMessage(),
                "border-color: red;");
    }

    @Test(description = "check evening courses are present")
    public void EveningCoursesCheck() {
        homePage.isShown();
        homePage.openEveningCoursesPage();

        assertTrue(eveningCoursesPage.checkEveningCoursesArePresent());
    }

    @Test(description = "check day courses are present")
    public void DayCoursesCheck() {
        homePage.isShown();
        homePage.openDayCoursesPage();

        assertTrue(dayCoursesPage.checkDayCoursesArePresent());
    }

    @Test(description = "debug test for fail result")
    public void test666() {
        homePage.isShown();
        fail();

    }


    @AfterMethod
    public void finilize()
    {
        driver.quit();
    }
}
