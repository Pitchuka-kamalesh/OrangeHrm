package Orangehrm.library;

import org.openqa.selenium.By;

import Uttils.Apputils;

public class LoginPage extends Apputils {

	public void login(String user, String pwd) {

		driver.findElement(By.id("txtUsername")).sendKeys(user);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();

	}

	public void logout() {
		
		
		driver.findElement(By.partialLinkText("Welcome")).click();

		driver.findElement(By.linkText("Logout")).click();

	}

	public Boolean isAdminModuleDisplayed() {
		try {

			driver.findElement(By.linkText("Admin")).isDisplayed();
			return true;

		} catch (Exception e) {

			return false;
		}

	}

}
