package Uttils;

import Orangehrm.dataexcel.ExcelData;

public class ExcelUtilsDemo {

    public static void main(String[] args) {
        ExcelData excel = new ExcelData();
        excel.testData("/src/test/resources/ExcelFiles/testdata.xlsx","LoginDetails");


    }
}
