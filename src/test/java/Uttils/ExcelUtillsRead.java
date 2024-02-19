package Uttils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtillsRead {

    static String projectDir;
    static XSSFWorkbook workBook;

    static XSSFSheet sheet;


    public ExcelUtillsRead(String excelPath, String sheetName){

        try {
            this.projectDir = System.getProperty("user.dir");
            this.workBook = new XSSFWorkbook(projectDir+excelPath);
            this.sheet = workBook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void getRowCount(){

        try {
            int rowCont=sheet.getPhysicalNumberOfRows();
            System.out.println(rowCont);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
        }




    }

    public static void getCellDataString(int rownum,int colnum){
        try {
            String data = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
            System.out.println(data);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
        }

    }

    public static void getCellDataInteger(int rownum,int colnum){
        try {
            double data = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
            System.out.println(data);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
        }

    }


}
