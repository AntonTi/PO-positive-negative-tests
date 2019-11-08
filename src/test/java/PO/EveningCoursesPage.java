package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class EveningCoursesPage extends BasePage {

    By eveningCoursesPageHeader = By.xpath("//h1[contains(text(), 'Вечерние курсы')]");
    By priceHolder = By.xpath("//li[@class='r-total-price-wrapper']//span");

    public EveningCoursesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Evening Courses Page is shown")
    public EveningCoursesPage isShown() {
        logger.info("Evening Courses Page is shown");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(eveningCoursesPageHeader));
        return this;
    }

    @Step("get Evening Courses Title")
    public String getTitle() {
        logger.info("get Evening Courses Title");
        String title = driver.getTitle();
        return title;
    }

    @Step("check Evening Courses are present")
    public boolean checkEveningCoursesArePresent() {
        logger.info("check Evening Courses are present");
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

    @Step("open course {name}")
    public EveningCoursesPage openCourse(String name) {
        logger.info(String.format("open course '%s'", name));
        By course = By.xpath(String.format("//h2[text()='%s']/..//a[text()='Просмотреть']", name));
        wait.until(ExpectedConditions.elementToBeClickable(course));
        driver.findElement(course).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-filter='.course-list']")));
        return this;
    }

    @Step("get Evening Course Price")
    public int getCoursePrice() {
        logger.info("get Evening Course Price");
        wait.until(ExpectedConditions.presenceOfElementLocated(priceHolder));
        String rawPrice = driver.findElement(priceHolder).getText();
        int price = Integer.parseInt(rawPrice.substring(0, rawPrice.indexOf(" ")));
        return price;
    }

    @Step("close Evening Courses Page")
    public EveningCoursesPage Close() {
        logger.warn("close Evening Courses Page");
        driver.close();
        return this;
    }

}
