package Orangehrm.listners;

import Uttils.Apputils;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListenerClass implements ITestListener {


    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("<---Testcase started " + result.getMethod().getMethodName() + " ----->");
    }

    @Override
    public void onTestSuccess(ITestResult result) {


    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("<---- Test Execution" + result.getMethod().getMethodName() + "Failed---->");
        System.out.println(result.getMethod().getMethodName() + "Failed---->");

        Object testClass = result.getInstance();
        WebDriver driver = Apputils.getDriver();
        // Allure ScreenShot and SaveTestLog
        if (driver != null) {
            System.out.println("Screenshot captured for test case:" + result.getMethod().getMethodName());
            saveFailureScreenShot(driver);
        }
        saveTextLog(result.getMethod().getMethodName() + " failed and screenshot taken!");

    }

    @Attachment
    public byte[] saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("I am on the On Start method" + context.getName());
        context.setAttribute("WebDriver", Apputils.getDriver());
    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
