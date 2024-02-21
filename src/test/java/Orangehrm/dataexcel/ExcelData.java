package Orangehrm.dataexcel;

import Uttils.ExcelUtillsRead;
import org.testng.annotations.DataProvider;

public class ExcelData {


    public  Object[][] testData(String excelPath, String sheetName) {
        ExcelUtillsRead excel = new ExcelUtillsRead(excelPath, sheetName);
        int rowCount = ExcelUtillsRead.getRowCount();
        int colCount = ExcelUtillsRead.getColCount();
        Object[][] data = new Object[rowCount -1][colCount];
        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String cellData = ExcelUtillsRead.getCellDataString(i, j);
                data[i-1][j] = cellData;
            }
        }
        return data;

    }
@DataProvider(name = "invalidLoginData")
    public Object[][] getData(){

        return testData("/src/test/resources/ExcelFiles/testdata.xlsx","LoginDetails");

    }
    @DataProvider(name = "login")
    public Object[][] getLoginData(){

        return testData("/src/test/resources/ExcelFiles/testdata.xlsx","ValidLoginDetails");

    }




}
