package Orangehrm.testcases;

import Orangehrm.dataexcel.ExcelData;
import Orangehrm.library.LoginPage;
import Uttils.Apputils;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

@Listeners({Orangehrm.listners.TestListenerClass.class})
public class LoginPageTestCases extends Apputils {

    public static WebDriver driver;

    public static Logger LOGGER = LogManager.getLogger(LoginPageTestCases.class);

    @BeforeTest
    public void setUp(){
        Apputils app = new Apputils();
        driver = app.launchApp();
        LOGGER.info("Instating the Browser");
        driver.get("http://orangehrm.qedgetech.com/");


    }


    @BeforeMethod
    public void goToUrl() {
        LOGGER.info("En");

    }

    @Test(dataProvider = "login", dataProviderClass = ExcelData.class)
    @Description("Check the user able to login with valid Credentials.")
    @Severity(SeverityLevel.BLOCKER)
    @Step("Verfing the Login with valid credentials")
    @Epic("EP001")
    @Story("SP00-Login test Cases")
    public void loginTestCase(String username
            , String password) {
        LoginPage lp = new LoginPage();
        LOGGER.info("Entering the username and password ");
        lp.login(username, password);
        LOGGER.info("Checking Admin module is present");
        boolean adminPageAvalible = lp.isAdminModuleDisplayed();
        LOGGER.info("Logging out from the Orange HRM");
        lp.logout();
        AssertJUnit.assertTrue(adminPageAvalible);
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = ExcelData.class)
    @Description("Check the user able to login with invalid Credentials.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Verfing the Login with invalid credentials")
    @Epic("EP001")
    @Story("SP00-Login test Cases")
    public void loginTestCaseInavalid(String Username
            , String password,String errMessage) {
//        System.out.println(Username + "|" + password + "|"+errMessage);
        LoginPage lp = new LoginPage();
        lp.login(Username, password);
        Assert.assertEquals(lp.errorMessage(),errMessage,"Both the string are not equal");
    }


    @Test
    @Step("Entering Password reset page")
    public void forgotPassword() {
        LoginPage lp = new LoginPage();
        lp.forgotPassword("");
        boolean result = lp.isErrorMessageDisplayedInForgotPassword("Could not find a user with given details");
        Assert.assertTrue(result);
    }

    @AfterTest
    public void closingApp() {
        Apputils.closeApp();
    }

}
