package test.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class DayCoursesPage extends BasePage {

    By dayCoursesPageHeader = By.xpath("//h1[contains(text(), 'Дневное обучение')]");

    public DayCoursesPage(WebDriver driver) {
        super(driver);
    }

    public DayCoursesPage isShown() {
        logger.info("Day Courses Page is Shown");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dayCoursesPageHeader));
        return this;
    }

    public boolean checkDayCoursesArePresent() {
        logger.info("Check Day Courses Are Present");
        String arr[] = {
                "Microsoft",
                "Cisco",
                "UNIX / Linux",
                "Oracle",
                "ITIL",
                "Программирование",
                "Управление проектами",
                "Пользовательские курсы",
                "Vmware",
                "Teradata",
                "EC-Council"
        };
        List<String> courses = Arrays.asList(arr);
        List<WebElement> list = driver.findElements(By.xpath("//h2"));
        for (WebElement el : list) {
            if (!courses.contains(el.getText())) {
                System.out.println(String.format("Expected courses to contain '%s'.", el.getText()));
                logger.error("Day courses mismatch on the site");
                return false;
            }
        }
        return true;
    }

    public DayCoursesPage Close() {
        logger.warn("Close Day Courses Page");
        driver.close();
        return this;
    }

}
