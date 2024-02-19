package Orangehrm.dataexcel;

import org.testng.annotations.DataProvider;

public class ExcelData {

    @DataProvider(name = "test-data")
    public static Object[][] dataProvFunc(){
        return new Object[][]{
                {"Lambda Test"},{"Automation"}
        };
    }
}
