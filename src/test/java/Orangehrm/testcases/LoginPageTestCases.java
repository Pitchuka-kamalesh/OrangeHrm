package Orangehrm.testcases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Orangehrm.library.LoginPage;
import Uttils.Apputils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class LoginPageTestCases {

	@BeforeMethod
	public void Beforelogin() {
		
		Apputils.launchApp("http://orangehrm.qedgetech.com");

	}

	@Test
	@Description("Check the user able to login with valid Crediantials.")
	@Severity(SeverityLevel.BLOCKER)
	@Step("Verfing the Login with invalid crediantials")
	@Epic("EP001")
	@Story("SP00-Login test Cases")
	public void loginTestCase() {
		LoginPage lp = new LoginPage();
		lp.login("Admin", "Qedge123!@#");
		boolean adminPageAvalible = lp.isAdminModuleDisplayed();
		AssertJUnit.assertEquals(adminPageAvalible, true);
		
		

	}
	
	@Test
	@Description("Check the user able to login with invalid Crediantials.")
	@Severity(SeverityLevel.CRITICAL)
	@Step("Verfing the Login with invalid crediantials")
	@Epic("EP001")
	@Story("SP00-Login test Cases")
	public void loginTestCaseInavalid() {
		LoginPage lp = new LoginPage();
		lp.login("Admin", "Qedge123@#");
		boolean adminPageAvalible = lp.isErrorMessageDisplayed();
		AssertJUnit.assertEquals(adminPageAvalible, true);
		
	}
	
	
	@Test
	@Description("Check the user able to login with invalid Crediantials.")
	@Severity(SeverityLevel.CRITICAL)
	@Step("Verfing the Login with username empty and password valid ")
	@Epic("EP001")
	@Story("SP00-Login test Cases")
	public void loginWithEmptyUsername() {
		LoginPage lp = new LoginPage();
		lp.login(" ", "Qedge123@#");
		boolean adminPageAvalible = lp.isErrorMessageDisplayed();
		AssertJUnit.assertEquals(adminPageAvalible, true);
		
	}
	
	
	
	@Test
	@Description("Check the user able to login with invalid Crediantials.")
	@Severity(SeverityLevel.CRITICAL)
	@Step("Verfing the Login with username valid and password empty ")
	@Epic("EP001")
	@Story("SP00-Login test Cases")
	public void loginWithEmptypassword() {
		LoginPage lp = new LoginPage();
		lp.login("Admin", " ");
		boolean adminPageAvalible = lp.isErrorMessageDisplayed();
		AssertJUnit.assertEquals(adminPageAvalible, true);
		
	}
	
	
	@Test
	public void forgotPassword() {
		LoginPage lp = new LoginPage();
		lp.forgotPassword("");
		boolean result = lp.isErrorMessageDisplayedInForgotPassword();
		Assert.assertEquals(result, true);
	}
	
	@AfterMethod
	public void afterlogin() {
		Apputils.closeApp();
	}

}
