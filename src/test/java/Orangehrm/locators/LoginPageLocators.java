package Orangehrm.locators;

import org.openqa.selenium.By;

public interface LoginPageLocators {

    // forgot password locators
    By FORGOT_PASSWORD_LINK = By.linkText("Forgot your password?");
    By FORGOT_PASSWORD_USERNAME = By.id("securityAuthentication_userName");
    By FORGOT_PASSWORD_RESET_PASSWORD_BUTTON = By.id("btnSearchValues");
    By FORGOT_PASSWORD_ERROR_MESSAGE = By.xpath("//div[@class='message warning fadable']");

    // Login locators
    By LOGIN_USERNAME = By.id("txtUsername");
    By LOGIN_PASSWORD = By.id("txtPassword");
    By LOGIN_LOGIN_BUTTON = By.id("btnLogin");
    By LOGIN_ERROR_MESSAGE = By.id("spanMessage");

    // Logout Locator By.id("welcome"),By.linkText("Logout"),




}
