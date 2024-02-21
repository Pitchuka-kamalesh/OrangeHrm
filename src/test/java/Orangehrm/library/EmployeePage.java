package Orangehrm.library;

import Uttils.Apputils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EmployeePage extends Apputils {

    static java.lang.String id = null;

    public void addEmployee(String fname, String lname) {

        driver.findElement(By.linkText("PIM")).click();
        driver.findElement(By.linkText("Add Employee")).click();
        driver.findElement(By.id("firstName")).sendKeys(fname);
        driver.findElement(By.id("lastName")).sendKeys(lname);
        id = driver.findElement(By.id("employeeId")).getAttribute("value");
        driver.findElement(By.id("btnSave")).click();
    }


    public void addEmployee(String fname, String mname, String lname) {

        driver.findElement(By.linkText("PIM")).click();
        driver.findElement(By.linkText("Add Employee")).click();
        driver.findElement(By.id("firstName")).sendKeys(fname);
        driver.findElement(By.id("middleName")).sendKeys(mname);
        driver.findElement(By.id("lastName")).sendKeys(lname);
        id = driver.findElement(By.id("employeeId")).getAttribute("value");
        driver.findElement(By.id("btnSave")).click();


    }

    public Boolean isEmployeeCreated() {
        boolean result = false;
        driver.findElement(By.linkText("Employee List")).click();
        driver.findElement(By.name("empsearch[id]")).sendKeys(id);
        driver.findElement(By.name("_search")).click();
        try {
            WebElement ele = driver.findElement(By.xpath("//table[@id='resultTable']//child::td[2]"));
            result = ele.getText().equalsIgnoreCase(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public void searchEmployee(String empid) {

        driver.findElement(By.linkText("PIM")).click();
        driver.findElement(By.linkText("Employee List")).click();
        driver.findElement(By.name("empsearch[id]")).sendKeys(empid);
        driver.findElement(By.name("_search")).click();
        List<WebElement> ele = driver.findElements(By.linkText(empid));

        System.out.println(ele.size());


    }


    public void searchEmployee(String name,String empid) {

        driver.findElement(By.linkText("PIM")).click();
        driver.findElement(By.linkText("Employee List")).click();
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(name);
        driver.findElement(By.name("empsearch[id]")).sendKeys(empid);
        driver.findElement(By.name("_search")).click();
        List<WebElement> ele = driver.findElements(By.linkText(empid));

        System.out.println(ele.size());


    }

    public void employeeReports() {

    }

}
