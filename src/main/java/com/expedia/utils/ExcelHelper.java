package com.expedia.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelHelper {

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;
    private static String[] datas;

    public void setExcelFile(String excelFilePath) throws IOException {
        workbook = new XSSFWorkbook(excelFilePath);
    }

    public void setExcelSheet(String sheetName) {
        sheet = workbook.getSheet(sheetName);
    }

    public String getCellData(String testCaseName, String columnName) {
        int rowIndex = getRowIndex(testCaseName);
        int colIndex = getColIndex(columnName);

        String data = sheet.getRow(rowIndex).getCell(colIndex).getStringCellValue();
        return data;
    }

    private int getRowIndex(String testCaseName) {
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        int rowIndex = 0;
        for (int i = 0; i <= rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            String tcName = row.getCell(0).getStringCellValue();
            if (tcName.equalsIgnoreCase(testCaseName)) {
                rowIndex = i;
                break;
            }

        }
        return rowIndex;

    }

    private int getColIndex(String columnName) {
        XSSFRow columnNameRow = sheet.getRow(0);
        int colIndex = 0;
        int cellCount = columnNameRow.getLastCellNum();
        for (int i = 0; i < cellCount; i++) {
            String colName = columnNameRow.getCell(i).getStringCellValue();
            if (colName.equalsIgnoreCase(columnName)) {
                colIndex = i;
                break;
            }
        }
        return colIndex;

    }
}

