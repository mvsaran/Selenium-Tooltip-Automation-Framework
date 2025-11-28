package com.practice.tests;

import com.practice.base.BaseTest;
import com.practice.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(">>> onTestFailure called for: " + result.getMethod().getMethodName());

        Object testInstance = result.getInstance();

        if (testInstance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testInstance).getDriver();   // using getter
            String testName = result.getMethod().getMethodName();
            ScreenshotUtil.takeScreenshot(driver, testName);
        } else {
            System.out.println(">>> Test instance is not BaseTest, screenshot skipped");
        }
    }

    // All other ITestListener methods can stay empty
}
