package test.java.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
    public void eveningCoursesCheck() {
        homePage.isShown();
        homePage.openEveningCoursesPage();

        assertTrue(eveningCoursesPage.checkEveningCoursesArePresent());
    }

    @Test(description = "check day courses are present")
    public void dayCoursesCheck() {
        homePage.isShown();
        homePage.openDayCoursesPage();

        assertTrue(dayCoursesPage.checkDayCoursesArePresent());
    }

    @Test(description = "Check courses price", dataProvider = "coursesProvider")
    public void checkCoursesPrice(String courseName, int expectedPrice) {
        homePage.isShown();
        homePage.openEveningCoursesPage();
        homePage.openCourse(courseName);
         //       .openNigthCourses()
          //      .openCourse(courseName);
        int actualPrice = homePage.getCoursePrice();
        assertEquals(actualPrice, expectedPrice, String.format("Expected price to be equals '%d' for '%s'", expectedPrice, courseName));
    }

    @DataProvider(name = "coursesProvider")
    public Object[][] coursesProvider() {
        return new Object[][] {
                {"Тестирование", 17300},
                {"Frontend development", 18100},
                {"JS development", 45200},
                {"Веб-дизайн", 27700},
                {"PHP", 16550},
                {"Программирование под IOS", 20350},
                {"Программирование под Android", 30200},
                {"Java programming", 25800},
                {"Python", 30600},
                {"Data Science/Machine Learning", 30350},
                {"C# /.NET development", 14050},
                {"C++", 15650},
                {"Game Development", 10300},
                {"DEVOPS", 16850},
                {"Digital Marketing", 28150},
                {"Управление персоналом", 10800},
                {"Управление проектами", 31050},
                {"Менеджмент", 5950},
                {"Кибербезопасность", 4000},
                {"Mobile development", 47500},
                {"Видеомонтаж", 4400},
                {"Cisco", 24000},
                {"Go development", 11700}
        };
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
