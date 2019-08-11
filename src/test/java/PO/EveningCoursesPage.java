package test.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class EveningCoursesPage extends BasePage {
    public EveningCoursesPage(WebDriver driver) {
        super(driver);
    }

    By eveningCoursesPageHeader = By.xpath("//h1[contains(text(), 'Вечерние курсы')]");

    public EveningCoursesPage isShown() {
        logger.info("Open Evening Courses Page");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(eveningCoursesPageHeader));
        return this;
    }

    public boolean checkEveningCoursesArePresent() {
        logger.info("Check Evening Courses Are Present");
        String arr[] = {
                "Тестирование",
                "Frontend development",
                "JS development",
                "Веб-дизайн",
                "PHP",
                "Программирование под IOS",
                "Программирование под Android",
                "Java programming",
                "Python",
                "Data Science/Machine Learning",
                "C# /.NET development",
                "C++",
                "Game Development",
                "DEVOPS",
                "Digital Marketing",
                "Управление персоналом",
                "Управление проектами",
                "Менеджмент",
                "Кибербезопасность",
                "Mobile development",
                "Видеомонтаж",
                "Cisco",
                "Go development"
        };
        List<String> courses = Arrays.asList(arr);
        List<WebElement> list = driver.findElements(By.xpath("//h2"));
        for (WebElement el : list) {
            if (!courses.contains(el.getText())) {
                System.out.println(String.format("Expected courses to contain '%s'.", el.getText()));
                logger.error("Evening courses mismatch on the site");
                return false;
            }
        }
        return true;
    }

    public EveningCoursesPage Close() {
        logger.warn("Close Evening Courses Page");
        driver.close();
        return this;
    }

}
