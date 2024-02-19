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

    public static int getRowCount(){

        int rowCont = 0;

        try {
            rowCont=sheet.getPhysicalNumberOfRows();
            System.out.println(rowCont);
            return rowCont;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
        }

        return rowCont;




    }

    public static int getColCount(){

        int colCont = 0;

        try {
            colCont=sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println(colCont);
            return(colCont);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
        }

        return(colCont);




    }

    public static String getCellDataString(int rownum, int colnum){
        String data = " ";
        try {
            data = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
            System.out.println(data);
            return data;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
        }

        return data;
    }

    public static double  getCellDataInteger(int rownum,int colnum){
        double  data = 0;
        try {
            data = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
            System.out.println(data);
            return data;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
        }

        return data;

    }


}
