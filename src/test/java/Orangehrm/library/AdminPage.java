package Orangehrm.library;

import Uttils.Apputils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends Apputils {


    public void addUser(String fullname,String username,String role,String value,String password) throws InterruptedException {
        driver.findElement(By.linkText("Admin")).click();
        driver.findElement(By.linkText("User Management")).click();
        driver.findElement(By.id("btnAdd")).click();

        // drop downmenu with select class with id = systemUser_userType

        WebElement user_role = driver.findElement(By.id("systemUser_userType"));
        Select user_role_dropdown = new Select(user_role);
        user_role_dropdown.selectByVisibleText(role);

        driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(fullname);
        driver.findElement(By.id("systemUser_userName")).sendKeys(username);

        WebElement status = driver.findElement(By.id("systemUser_status"));
        Select status_dropdown = new Select(status);
        status_dropdown.selectByVisibleText(value);

        driver.findElement(By.id("systemUser_password")).sendKeys(password);
        driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(password);
//        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        wait.until(d -> revealed.isDisplayed());
        driver.findElement(By.className("addbutton")).sendKeys(Keys.ENTER);


    }

    public Boolean searchUser(String username){
        boolean result = false;

        driver.findElement(By.id("searchSystemUser_userName")).sendKeys(username);
        driver.findElement(By.id("searchBtn")).click();
        try {
            WebElement ele = driver.findElement(By.xpath("//table[@id='resultTable']//child::td[2]"));
            result = ele.getText().equalsIgnoreCase(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;


    }


}
