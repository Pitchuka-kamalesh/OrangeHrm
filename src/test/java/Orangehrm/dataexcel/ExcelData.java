package Orangehrm.dataexcel;

import Uttils.ExcelUtillsRead;
import org.testng.annotations.DataProvider;

public class ExcelData {


    public  Object[][] testData(String excelPath, String sheetName) {
        ExcelUtillsRead excel = new ExcelUtillsRead(excelPath, sheetName);
        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();
        Object[][] data = new Object[rowCount -1][colCount];
        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String cellData = excel.getCellDataString(i, j);
                System.out.println(cellData);
                data[i-1][j] = cellData;
            }
        }
        return data;

    }
@DataProvider(name = "logindata")
    public Object[][] getData(){

        Object[][] data = testData("/src/test/resources/ExcelFiles/testdata.xlsx","LoginDetails");

        return data;



    }



}
