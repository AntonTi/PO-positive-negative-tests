package test.java.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.PO.*;

import static org.testng.Assert.*;

public class GenTest extends TestBaseSetup {

    TopLogoPanel topLogoPanel;
    HomePage homePage;
    ContactsPage contactsPage;
    DayCoursesPage dayCoursesPage;
    EveningCoursesPage eveningCoursesPage;

    @BeforeMethod(description = "Initialize Page factory")
    public void init2(ITestContext context) {
        topLogoPanel = new TopLogoPanel(driver);
        homePage = new HomePage(driver);
        dayCoursesPage = new DayCoursesPage(driver);
        eveningCoursesPage = new EveningCoursesPage(driver);
        contactsPage = new ContactsPage(driver);
    }

    @Test(description = "check Home Page title")
    @Severity(SeverityLevel.NORMAL)
    public void titleHomePageCheck() {
        homePage.isShown();

        assertEquals(homePage.getTitle(),
                "Курсы программирования и веб-дизайна в Киеве | ITEA");
    }

    @Test(description = "check Evening Courses Page title")
    @Severity(SeverityLevel.NORMAL)
    public void titleEveningCoursesPageCheck() {
        homePage.isShown();
        homePage.openEveningCoursesPage();
        eveningCoursesPage.isShown();

        assertEquals(eveningCoursesPage.getTitle(),
                "Обучение IT-специальностям: программирование, верстка, QA, дизайн");
    }

    @Test(description = "check Day Courses Page title")
    @Severity(SeverityLevel.NORMAL)
    public void titleDayCoursesPageCheck() {
        homePage.isShown();
        homePage.openDayCoursesPage();
        dayCoursesPage.isShown();

        assertEquals(dayCoursesPage.getTitle(),
                "Авторизованное и авторское обучение | ITEA");
    }

    @Test(description = "check Contacts Page title")
    @Severity(SeverityLevel.NORMAL)
    public void titleContactsPageCheck() {
        homePage.isShown();
        homePage.openContactsPage();
        contactsPage.isShown();

        assertEquals(contactsPage.getTitle(),
                "Контакты компании IT Education Academy | ITEA");
    }

    @Test(description = "check Callback test form(positive)")
    @Severity(SeverityLevel.CRITICAL)
    public void callbackFormCheckPos() {
        homePage.isShown();
        topLogoPanel.openCallbackForm();
        topLogoPanel.fillCallbackForm();
        topLogoPanel.sendCallbackForm();

        assertEquals(topLogoPanel.getMessageFromForm(),
                "Спасибо!\n" + "Наш менеджер свяжется с Вами.");

    }

    @Test(invocationCount = 1, description = "check Callback test form(negative)")
    @Severity(SeverityLevel.NORMAL)
    public void callbackFormCheckNeg() {
        homePage.isShown();
        topLogoPanel.openCallbackForm();
        topLogoPanel.fillEmptyCallbackForm();
        topLogoPanel.sendCallbackForm();

        assertEquals(topLogoPanel.getBorderRedFromForm(),
                "border-color: red;");
    }

    @Test(description = "check Evening Courses are present")
    @Severity(SeverityLevel.CRITICAL)
    public void eveningCoursesCheck() {
        homePage.isShown();
        homePage.openEveningCoursesPage();
        eveningCoursesPage.isShown();

        assertTrue(eveningCoursesPage.checkEveningCoursesArePresent());
    }

    @Test(description = "check Day Courses are present")
    @Severity(SeverityLevel.CRITICAL)
    public void dayCoursesCheck() {
        homePage.isShown();
        homePage.openDayCoursesPage();
        dayCoursesPage.isShown();

        assertTrue(dayCoursesPage.checkDayCoursesArePresent());
    }

    @Test(description = "check Evening Courses Price", dataProvider = "eveningCoursesProvider")
    @Severity(SeverityLevel.CRITICAL)
    public void eveningCoursesPriceCheck(String courseName, int expectedPrice) {
        homePage.isShown();
        homePage.openEveningCoursesPage();
        eveningCoursesPage.isShown();
        eveningCoursesPage.openCourse(courseName);
        int actualPrice = eveningCoursesPage.getCoursePrice();

        assertEquals(actualPrice, expectedPrice,
                String.format("Expected Price to be equals '%d' for '%s'",
                        expectedPrice, courseName));
    }

    @DataProvider(name = "eveningCoursesProvider")
    public Object[][] coursesProvider() {
        return new Object[][]{
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

    @Test(description = "debug Test for fail result")
    @Severity(SeverityLevel.TRIVIAL)
    public void testFail() {
        homePage.isShown();
        fail();
    }

}
