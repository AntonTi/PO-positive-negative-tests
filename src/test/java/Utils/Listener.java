package test.java.Utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("on Test Start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("on Test Success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("webDriver");
        ScreenShot screenshot = new ScreenShot(driver);
        screenshot.makeScreenShot(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
