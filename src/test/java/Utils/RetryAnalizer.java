package test.java.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalizer implements IRetryAnalyzer {
    int count = 1;
    int maxRetry = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
     if(count < maxRetry){
         count++;
         return true;
     }
     else return false;

    }
}
