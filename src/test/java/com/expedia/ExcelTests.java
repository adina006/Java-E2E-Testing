package com.expedia;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExcelTests {


    @Test
    public void test() throws IOException {
        String excelPath = System.getProperty("user.dir") + "//src//main//resources//data//DemoExcel.xlsx";
        XSSFWorkbook workBooK = new XSSFWorkbook(excelPath);
        XSSFSheet sheet =  workBooK.getSheet("LoginTest");

        //get all the info
        int lastRowNum = sheet.getLastRowNum();
        int firstRowNum = sheet.getFirstRowNum();
        int rowCount = lastRowNum - firstRowNum;
        for(int i =0; i<=rowCount; i++){
            XSSFRow row = sheet.getRow(i);
            int cellCount = row.getLastCellNum();
            for(int j=0; j<cellCount; j++){
                XSSFCell cell = row.getCell(j);
                System.out.println(cell.getStringCellValue());
            }
        }
//        XSSFRow row = sheet.getRow(1);
//        XSSFCell cell = row.getCell(0);
//        //String value = cell.getStringCellValue();
//        System.out.println(cell);

    }
}
