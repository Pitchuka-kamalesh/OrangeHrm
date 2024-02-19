package Orangehrm.library;

import Orangehrm.locators.LoginPageLocators;
import Uttils.Apputils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class LoginPage extends Apputils implements LoginPageLocators {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = getDriver();
    }

    @Step("Login")
    public void login(String user, String pwd) {

        driver.findElement(LOGIN_USERNAME).sendKeys(user);
        driver.findElement(LOGIN_PASSWORD).sendKeys(pwd);
        driver.findElement(LOGIN_LOGIN_BUTTON).click();

    }

    @Step("Logout from the website")
    public void logout() {

        driver.findElement(By.partialLinkText("Welcome")).click();

        driver.findElement(By.linkText("Logout")).click();

    }

    @Step("Checking whether Admin module is present")
    public Boolean isAdminModuleDisplayed() {
        try {

            driver.findElement(By.linkText("Admin")).isDisplayed();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    @Step("Check error message is present")
    public boolean isErrorMessageDisplayed() {

        List<String> activalResults = Arrays.asList("Invalid credentials", "Username cannot be empty",
                "Password cannot be empty");

        String observedResults = driver.findElement(LOGIN_ERROR_MESSAGE).getText();

        return activalResults.contains(observedResults);

    }

    @Step("Entering ForgotPassword page and entering details {userName}")
    public void forgotPassword(String userName) {

        driver.findElement(FORGOT_PASSWORD_LINK).click();
        driver.findElement(FORGOT_PASSWORD_USERNAME).sendKeys(userName);
        driver.findElement(FORGOT_PASSWORD_RESET_PASSWORD_BUTTON).click();

    }

    public boolean isErrorMessageDisplayedInForgotPassword() {

        String activalResult = "Could not find a user with given details";

        String[] observeredResult = driver.findElement(FORGOT_PASSWORD_ERROR_MESSAGE).getText()
                .split("\n");
//

        return activalResult.equalsIgnoreCase(observeredResult[0]);
    }

}
