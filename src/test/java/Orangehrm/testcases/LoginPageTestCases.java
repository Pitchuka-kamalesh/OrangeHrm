package Orangehrm.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import org.testng.annotations.*;

import Orangehrm.library.LoginPage;
import Uttils.Apputils;

public class LoginPageTestCases {

	@BeforeMethod
	public void Beforelogin() {
		
		Apputils.launchApp("http://orangehrm.qedgetech.com");

	}

	@Test
	public void loginTestCase() {
		LoginPage lp = new LoginPage();
		lp.login("Admin", "Qedge123!@#");
		boolean adminPageAvalible = lp.isAdminModuleDisplayed();
		AssertJUnit.assertEquals(adminPageAvalible, true);
		
		

	}
	
	@Test
	public void loginTestCaseInavalid() {
		LoginPage lp = new LoginPage();
		lp.login("Admin", "Qedge123@#");
		boolean adminPageAvalible = lp.isAdminModuleDisplayed();
		AssertJUnit.assertEquals(adminPageAvalible, false);
		
	}
	
	@AfterMethod
	public void afterlogin() {
		Apputils.closeApp();
	}

}
