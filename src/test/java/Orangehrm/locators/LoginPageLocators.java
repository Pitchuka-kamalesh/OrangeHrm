package Orangehrm.locators;

import org.openqa.selenium.By;

public interface LoginPageLocators {


    // forgot password locators
    public static By FORGOT_PASSWORD_LINK = By.linkText("Forgot your password?");
    public static By FORGOT_PASSWORD_USERNAME = By.id("securityAuthentication_userName");
    public static By FORGOT_PASSWORD_RESET_PASSWORD_BUTTON = By.id("btnSearchValues");

    public static By FORGOT_PASSWORD_ERROR_MESSAGE = By.xpath("//div[@class='message warning fadable']");

    // Login locators
    public static By LOGIN_USERNAME = By.id("txtUsername");
    public static By LOGIN_PASSWORD = By.id("txtPassword");
    public static By LOGIN_LOGIN_BUTTON = By.id("btnLogin");
    public static By LOGIN_ERROR_MESSAGE = By.id("spanMessage");


}
