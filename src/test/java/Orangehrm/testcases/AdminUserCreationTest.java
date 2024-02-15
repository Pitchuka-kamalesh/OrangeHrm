package Orangehrm.testcases;

import Orangehrm.library.AdminPage;
import Orangehrm.library.LoginPage;
import Uttils.Apputils;

public class AdminUserCreationTest {
    public static void main(String[] args) throws InterruptedException {
        Apputils.launchApp("http://orangehrm.qedgetech.com/");
        LoginPage lp = new LoginPage();
        lp.login("Admin", "Qedge123!@#");
        AdminPage admin = new AdminPage();
        admin.addUser("Hello world","Helloworldtestsw","ESS","Enabled","Qedge123!@#");
        boolean result = admin.searchUser("Helloworldtestsw");
        System.out.println(result);
//        lp.logout();
//        Apputils.closeApp();

    }
}
