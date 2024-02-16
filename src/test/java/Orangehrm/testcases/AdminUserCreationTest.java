package Orangehrm.testcases;

import Orangehrm.library.User;
import Orangehrm.library.LoginPage;
import Uttils.Apputils;

public class AdminUserCreationTest {
    public static void main(String[] args){
        Apputils.launchApp("http://orangehrm.qedgetech.com/");
        LoginPage lp = new LoginPage();
        lp.login("Admin", "Qedge123!@#");
        User admin = new User();
        admin.addUser("Hello world","Helloworldtestsw","ESS","Enabled","Qedge123!@#");
        boolean result = admin.searchUser("Helloworldtestsw");
        System.out.println(result);
//        lp.logout();
//        Apputils.closeApp();

    }
}
