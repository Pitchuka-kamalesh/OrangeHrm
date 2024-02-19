package Uttils;

public class ExcelUtilsDemo {

    public static void main(String[] args) {
        ExcelUtillsRead excel = new ExcelUtillsRead("/src/test/resources/ExcelFiles/testdata.xlsx","LoginDetails");
        excel.getRowCount();
        excel.getCellDataString(0,0);

    }
}
