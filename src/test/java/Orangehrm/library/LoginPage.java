package Orangehrm.library;

import java.util.Arrays;
import java.util.List;

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
	public boolean isErrorMessageDisplayed() {
		
		List<String> activalResults = Arrays.asList("Invalid credentials","Username cannot be empty","Password cannot be empty");
				
		String observedResults = driver.findElement(By.id("spanMessage")).getText();
		
		if(activalResults.contains(observedResults)) {
			return true;
		}
		
		
		return false;
		
	}
	
	public void forgotPassword(String userName) {
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.id("securityAuthentication_userName")).sendKeys(userName);
		driver.findElement(By.id("btnSearchValues")).click();
		
	}
	
	public boolean isErrorMessageDisplayedInForgotPassword() {
		
		
		String activalResult = "Could not find a user with given details ";
		
		String observeredResult = driver.findElement(By.xpath("(//div[@class='inner'])[1]")).getText();
		System.out.println(observeredResult);
		
		if(activalResult.contains(observeredResult)) {
			return true;
		}
		
		return false;
	}

}
