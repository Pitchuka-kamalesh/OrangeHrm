package Orangehrm.library;

import Orangehrm.locators.LoginPageLocators;
import Uttils.Apputils;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class LoginPage extends Apputils implements LoginPageLocators {

    public static Logger LOGGER = LogManager.getLogger(LoginPage.class);
    public WebDriver driver;

    public LoginPage() {
        this.driver = getDriver();
    }

    @Step("Login")
    public void login(String user, String pwd) {
        LOGGER.info(user + "|" + pwd + "values into text box");
        WebElement userInput = driver.findElement(LOGIN_USERNAME);
        WebElement passwordInput = driver.findElement(LOGIN_PASSWORD);
        if (user != null){
            userInput.sendKeys(user);
        }else{
            userInput.clear();
        }
        if(pwd != null){
            passwordInput.sendKeys(pwd);
        }else{
            passwordInput.clear();
        }
        try {
            Thread.sleep(6*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("Click on SignIn button");
        driver.findElement(LOGIN_LOGIN_BUTTON).click();

    }

    @Step("Logout from the website")
    public void logout() {

        try {
            LOGGER.info("We are waiting for 5 second to load the HomePage");
            Thread.sleep(5*1000);
            driver.findElement(By.id("welcome")).click();
            driver.findElement(By.linkText("Logout")).click();
            LOGGER.info("Click on Logout");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            LOGGER.error(e.getLocalizedMessage());
        }

    }

    @Step("Checking whether Admin module is present")
    public Boolean isAdminModuleDisplayed() {
        try {
            return driver.findElement(By.linkText("Admin")).isDisplayed();

        } catch (Exception e) {
            return false;
        }

    }

    @Step("Check error message is present")
    public String errorMessage() {

        try {
            return driver.findElement(LOGIN_ERROR_MESSAGE).getText();
        } catch (NoSuchElementException e) {
            System.out.println("unable to find webelement");
        }
        return null;
    }

    @Step("Entering ForgotPassword page and entering details {userName}")
    public void forgotPassword(String userName) {

        driver.findElement(FORGOT_PASSWORD_LINK).click();
        driver.findElement(FORGOT_PASSWORD_USERNAME).sendKeys(userName);
        driver.findElement(FORGOT_PASSWORD_RESET_PASSWORD_BUTTON).click();

    }

    public boolean isErrorMessageDisplayedInForgotPassword(String errMessage) {
        try {
            String[] observeredResult = driver.findElement(FORGOT_PASSWORD_ERROR_MESSAGE).getText().split("\n");
            return errMessage.equalsIgnoreCase(observeredResult[0]);
        } catch (Exception e) {
            return false;

        }

    }

}
