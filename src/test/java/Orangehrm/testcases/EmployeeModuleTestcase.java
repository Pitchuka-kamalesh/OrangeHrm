package Orangehrm.testcases;

import Orangehrm.library.EmployeePage;
import Orangehrm.library.LoginPage;
import Uttils.Apputils;

public class EmployeeModuleTestcase {

    public static void main(String[] args) {
//        Apputils.launchApp("http://orangehrm.qedgetech.com");
        LoginPage lp = new LoginPage();
        lp.login("Admin", "Qedge123!@#");
        EmployeePage ep = new EmployeePage();
        ep.addEmployee("Hello","World");
        boolean emp = ep.isEmployeeCreated();
        System.out.println(emp);

    }
}
