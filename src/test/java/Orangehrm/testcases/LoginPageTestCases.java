package Orangehrm.testcases;

import Orangehrm.dataexcel.ExcelData;
import Orangehrm.library.LoginPage;
import Uttils.Apputils;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Orangehrm.listners.TestListenerClass.class})
public class LoginPageTestCases extends Apputils {

    public WebDriver driver;

    @BeforeMethod
    public void beforelogin() {

        Apputils app = new Apputils();
        driver = app.launchApp();
        driver.get("http://orangehrm.qedgetech.com/");
//        System.out.println(driver.getTitle());

    }

    @Test
    @Description("Check the user able to login with valid Crediantials.")
    @Severity(SeverityLevel.BLOCKER)
    @Step("Verfing the Login with valid crediantials")
    @Epic("EP001")
    @Story("SP00-Login test Cases")
    public void loginTestCase() {
        LoginPage lp = new LoginPage();
        lp.login("Admin", "Qedge123!@#");
        boolean adminPageAvalible = lp.isAdminModuleDisplayed();
        lp.logout();
        AssertJUnit.assertTrue(adminPageAvalible);


    }

    @Test(dataProvider = "logindata", dataProviderClass = ExcelData.class)
    @Description("Check the user able to login with invalid Crediantials.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Verfing the Login with invalid crediantials")
    @Epic("EP001")
    @Story("SP00-Login test Cases")
    public void loginTestCaseInavalid(String Username
            , String password) {
        System.out.println(Username+"|"+password);
        LoginPage lp = new LoginPage();
        lp.login(Username, password);
        boolean adminPageAvalible = lp.isErrorMessageDisplayed();
        AssertJUnit.assertTrue(adminPageAvalible);


    }


    @Test
    @Step("Entering Password reset page")
    public void forgotPassword() {
        LoginPage lp = new LoginPage();
        lp.forgotPassword("");
        boolean result = lp.isErrorMessageDisplayedInForgotPassword();
        Assert.assertTrue(result);
    }

    @AfterMethod
    public void afterlogin() {
        Apputils.closeApp();
    }

}
